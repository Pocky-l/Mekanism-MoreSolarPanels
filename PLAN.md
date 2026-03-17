# Plan: Porting Solar Panels into the Addon Mod

## Source and Target

| | Path |
|---|---|
| **Source** (Mekanism Generators fork) | `C:\Users\rkush\OneDrive\Desktop\MyMods\Mekanism-AdvancedGenerators-1-21-1` |
| **Target** (addon mod, "my mod") | `C:\Users\rkush\OneDrive\Desktop\бобота\Mekanism Advanced Generators` |

**Source mod ID:** `mekanismgenerators`
**Target mod ID:** `solarpanels` | group: `com.pocky.solarpanels`

---

## Current State

### What already exists in the target mod

The target mod already has a working foundation:
- 9-tier solar panel system: Advanced, Hybrid, Ultimate, Quantum, Spectral, Singular, LightAbsorbing, Photonic, Creative
- `TileEntitySolarGenerator.java` — base tile with biome/weather multipliers
- `TileEntitySolarGenerators.java` — all 9 tier subclasses
- `SolarBlocks.java`, `SolarItems.java`, `SolarTileEntityTypes.java`, `SolarContainerTypes.java`
- `SolarConfig.java`, `SolarStorageConfig.java`, `SolarGearConfig.java`
- `SolarCreativeTabs.java`, `SolarLang.java`, `Generator.java`, `BlockShapes.java`
- Lang file `en_us.json` with block/item names
- **Missing:** blockstate JSONs, block/item model JSONs, textures

### What exists in the source mod (relevant solar parts)

- `TileEntitySolarGenerator.java` — original single-block solar generator
- `TileEntityAdvancedSolarGenerator.java` — advanced variant
- `blockstates/solar_generator.json`, `blockstates/advanced_solar_generator.json`
- Textures and models for the solar generators under `assets/mekanismgenerators/`
- Config entries for solar generator output
- Recipe JSONs for solar generators

---

## Migration Steps

### Step 1 — Audit missing assets in the target mod

Check which asset files are empty or missing:
- `src/main/resources/assets/solarpanels/blockstates/` — all 9 `.json` files missing
- `src/main/resources/assets/solarpanels/models/block/` — all block model JSONs missing
- `src/main/resources/assets/solarpanels/models/item/` — all item model JSONs missing
- `src/main/resources/assets/solarpanels/textures/` — all texture files missing

**Action:** List all blockstate/model/texture files in the source mod under `assets/mekanismgenerators/` that correspond to the solar generators.

---

### Step 2 — Copy and adapt blockstate JSONs

For each of the 9 panels, create a blockstate JSON in `assets/solarpanels/blockstates/`.

The source has `solar_generator.json` and `advanced_solar_generator.json` as references.
Each blockstate needs to reference models under `solarpanels:block/` (not `mekanismgenerators:`).

Files to create (one per tier):
- `advanced_solar_panel.json`
- `hybrid_solar_panel.json`
- `ultimate_solar_panel.json`
- `quantum_solar_panel.json`
- `spectral_solar_panel.json`
- `singular_solar_panel.json`
- `light_absorbing_solar_panel.json`
- `photonic_solar_panel.json`
- `creative_solar_panel.json`

**Action:** Copy structure from `mekanismgenerators` blockstates and replace namespace with `solarpanels`.

---

### Step 3 — Copy and adapt block model JSONs

Source models live under `assets/mekanismgenerators/models/block/`.

For each panel tier, create a corresponding model JSON in `assets/solarpanels/models/block/`.
Each model references textures — update texture paths from `mekanismgenerators:` to `solarpanels:`.

If you want to reuse Mekanism textures without copying them, reference `mekanismgenerators:` textures directly (requires Mekanism to be installed — which it is, since it's a dependency).

**Decision point:**
- **Option A (recommended):** Reference `mekanismgenerators:` textures directly — simpler, no duplication.
- **Option B:** Copy textures into `assets/solarpanels/textures/` and update references — fully standalone appearance.

---

### Step 4 — Copy and adapt item model JSONs

For each panel block and each crafting element/tablet item, create an item model JSON in `assets/solarpanels/models/item/`.

Standard pattern for block items:
```json
{
  "parent": "solarpanels:block/advanced_solar_panel"
}
```

For tablet items (energized items), use the Mekanism energized item model as parent or define a custom one.

---

### Step 5 — Copy textures (if Option B chosen in Step 3)

Source textures are under `assets/mekanismgenerators/textures/block/` and `textures/item/`.
Copy the relevant solar generator textures and rename/recolor as needed for each tier.

If tiers should have visually distinct appearances (different colors per tier), create separate texture files per tier, potentially with hue shifts to indicate power level.

---

### Step 6 — Add recipe JSONs

The source mod has recipe JSONs under `data/mekanismgenerators/recipes/`.
Create corresponding recipe JSONs under `data/solarpanels/recipes/` for each panel and crafting element.

Define a crafting progression (each tier requires the previous tier + new materials):
- Advanced Solar Panel: basic Mekanism + solar materials
- Hybrid: Advanced + more advanced materials
- ...up to Creative

Also add recipes for the energy tablets if they should be craftable.

---

### Step 7 — Add loot table JSONs

Each block needs a loot table so it drops itself when broken.
Create `data/solarpanels/loot_tables/blocks/<panel_name>.json` for all 9 panels.

Standard self-drop pattern:
```json
{
  "type": "minecraft:block",
  "pools": [{
    "rolls": 1,
    "entries": [{ "type": "minecraft:item", "name": "solarpanels:<panel_name>" }],
    "conditions": [{ "condition": "minecraft:survives_explosion" }]
  }]
}
```

---

### Step 8 — Add tag JSONs

Add the panels to relevant Minecraft/Mekanism/NeoForge tags:
- `data/minecraft/tags/blocks/mineable/pickaxe.json` — make panels mineable
- `data/minecraft/tags/blocks/needs_iron_tool.json` (or stone/diamond as appropriate)
- Any Mekanism energy block tags if needed

---

### Step 9 — Verify GUI / Container

The target already has `SolarContainerTypes.java` with 9 container types.
Confirm that corresponding `GuiSolarPanel` / `GuiSolarGenerator` screen classes exist or need to be created.

Check if the source has `GuiSolarGenerator.java` or `GuiAdvancedSolarGenerator.java` and adapt them for the target's package (`com.pocky.solarpanels.client.gui`).

---

### Step 10 — Verify NeoForge version compatibility

- Source uses NeoForge `21.1.162`
- Target uses NeoForge `21.1.219`

Any API differences between these versions must be checked — particularly around:
- `DeferredRegister` and `DeferredHolder` patterns
- `BlockEntityType` registration
- Energy capability APIs (`IEnergyStorage`, `Capabilities.EnergyStorage.BLOCK`)

Since 21.1.219 > 21.1.162, the target is on a newer version — source code may need minor updates if APIs changed.

---

### Step 11 — Build and fix compile errors

```bash
./gradlew build
```

Fix any compile errors that arise from namespace differences, missing imports, or API changes.

---

### Step 12 — Run in-game and test

```bash
./gradlew runClient
```

Verify:
- [ ] All 9 panels appear in creative tab
- [ ] Panels place and break correctly (correct drops)
- [ ] Panels generate energy in sunlight
- [ ] Weather (rain) reduces output
- [ ] Energy outputs to adjacent cables/machines
- [ ] GUI opens and shows energy bar
- [ ] Config values are applied correctly
- [ ] Energy tablets charge in the slot
- [ ] Recipes are craftable

---

## File Checklist

### Java (already exists — review only)
- [x] `TileEntityGenerator.java`
- [x] `TileEntitySolarGenerator.java`
- [x] `TileEntitySolarGenerators.java` (9 tiers)
- [x] `SolarBlocks.java`
- [x] `SolarItems.java`
- [x] `SolarTileEntityTypes.java`
- [x] `SolarContainerTypes.java`
- [x] `SolarCreativeTabs.java`
- [x] `SolarConfig.java`, `SolarStorageConfig.java`, `SolarGearConfig.java`
- [x] `Generator.java`, `BlockShapes.java`
- [ ] GUI screen classes — verify or create

### Assets (need to be created)
- [ ] `blockstates/` — 9 JSON files
- [ ] `models/block/` — 9+ JSON files
- [ ] `models/item/` — 9 panel items + crafting elements + tablets
- [ ] `textures/block/` — textures (or reference mekanismgenerators: directly)
- [ ] `textures/item/` — item textures

### Data (need to be created)
- [ ] `recipes/` — 9 panel recipes + element recipes + tablet recipes
- [ ] `loot_tables/blocks/` — 9 loot table files
- [ ] `tags/blocks/mineable/` — pickaxe tag

---

## Priority Order

1. **Blockstates + models + textures** — without these panels are invisible/crash
2. **Loot tables** — without these panels don't drop when broken
3. **Recipes** — needed for survival mode
4. **Tags** — needed for tool mining
5. **GUI screens** — needed for energy display
6. **Testing** — run in-game verification
