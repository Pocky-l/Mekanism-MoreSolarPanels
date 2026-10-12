# Changelog

All notable changes to this mod are documented in this file.
The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).
Versions before 2.3.0 are listed on [CurseForge](https://www.curseforge.com/minecraft/mc-mods/mekanism-advancedgenerators/files).

## [2.3.0] - Unreleased
### Added
- [Jade](https://www.curseforge.com/minecraft/mc-mods/jade) shows how much a solar panel or big solar generator is
  producing right now and whether it sees the sun.
- Energy cubes show the spinning energy core inside them when placed, like
  [Mekanism](https://www.curseforge.com/minecraft/mc-mods/mekanism)'s own cubes.
- The capacity and output rate of every energy cube and the capacity of every universal cable can be changed in the
  config (`solarpanels-storage.toml`). The defaults are the same as before.
- The sun indicator in the panel screen has a tooltip.
- Complete Russian translation.
- Upgrading an energy cube to the next tier keeps its energy, side configuration and owner, as with Mekanism's cubes.

### Changed
- The config screen shows a readable name and description for every option instead of the same "Energy Generation"
  title nine times.
- All items are in the shared "Pocky Mods" creative tab (and still in the vanilla tabs).
- New logo.
- The mod was rebuilt from the ground up for easier updates. Worlds, configs and recipes from 2.2 keep working.

### Fixed
- The descriptions of the energy cubes and universal cables showed capacities 1000 times too high (for example
  "2,048 GJ" for the Cosmic Energy Cube, which holds 2.05 GJ). The cubes and cables themselves are unchanged.
- Big solar generators and universal cables are no longer picked up by Mekanism's Cardboard Box and other block-moving
  tools (common `c:relocation_not_supported` tag), the same as Mekanism's own multiblock generators and cables.
