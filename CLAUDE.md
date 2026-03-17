# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a **NeoForge Minecraft mod** for Minecraft 1.21.1, built with NeoForge 21.1.219 and Java 21. It is based on the NeoForge MDK template and is intended to become "Mekanism Advanced Generators" — a mod that adds advanced power generation machinery. The mod ID, group, and class names are still set to the MDK defaults (`examplemod`, `com.example.examplemod`) and will need to be updated.

## Commands

### Build
```bash
./gradlew build
```
Output JAR is in `build/libs/`.

### Run in-game (development)
```bash
./gradlew runClient   # Launches Minecraft client with the mod loaded
./gradlew runServer   # Launches a dedicated server (no GUI)
```

### Data generation
```bash
./gradlew runData
```
Outputs generated resources to `src/generated/resources/` (already included in the main source set).

### Game tests
```bash
./gradlew runGameTestServer
```

### Refresh / clean
```bash
./gradlew --refresh-dependencies   # Re-download all dependencies
./gradlew clean                    # Delete build outputs (does not touch source)
```

## Architecture

### Entry points
- **`ExampleMod.java`** — Main mod class annotated with `@Mod`. Runs on both sides. Owns all `DeferredRegister` instances for blocks, items, and creative tabs. Registers config and subscribes to NeoForge game events.
- **`ExampleModClient.java`** — Client-only class annotated with `@Mod(dist = Dist.CLIENT)` and `@EventBusSubscriber`. Safe to reference client-only classes here. Registers the config screen factory.
- **`Config.java`** — Declares `ModConfigSpec` entries using NeoForge's config API. The built `SPEC` is registered in `ExampleMod`'s constructor.

### Registration pattern
All game objects (blocks, items, etc.) use `DeferredRegister` declared as `static final` fields on the main mod class. Registers are attached to the mod event bus in the constructor. When adding new object types (tile entities, recipes, etc.), create a new `DeferredRegister` for that registry.

### Event buses
- **Mod event bus** (`modEventBus` / `@EventBusSubscriber(bus = BUS.MOD)`) — lifecycle events, registry events, `BuildCreativeModeTabContentsEvent`.
- **NeoForge game bus** (`NeoForge.EVENT_BUS` / `@EventBusSubscriber`) — gameplay events (`ServerStartingEvent`, player events, etc.).

### Resource files
- `src/main/resources/META-INF/neoforge.mods.toml` — Mod metadata and dependency declarations. Variables like `${mod_id}` are expanded at build time from `gradle.properties`.
- `src/main/resources/assets/<modid>/lang/en_us.json` — All translatable strings.
- `src/generated/resources/` — Output of data generators; checked in and treated as normal resources.

## Key configuration (`gradle.properties`)
| Property | Current value |
|---|---|
| `mod_id` | `examplemod` |
| `mod_group_id` | `com.example.examplemod` |
| `minecraft_version` | `1.21.1` |
| `neo_version` | `21.1.219` |

To rename the mod, update `mod_id`, `mod_group_id`, `mod_name`, and `mod_version` in `gradle.properties`, rename the Java package accordingly, and update the `MODID` constant in the main class.
