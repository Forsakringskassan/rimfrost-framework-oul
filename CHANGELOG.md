# rimfrost-framework-oul changelog

Changelog of rimfrost-framework-oul.

## 1.1.1 (2026-06-10)

### Bug Fixes

-  Bump rimfrost-service-oul-asyncapi version ([0db21](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/0db21438e0f690d) Lars Persson)  

## rimfrost-1.1 (2026-06-04)

### Bug Fixes

-  Remove a few unused dependencies ([9e6a2](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/9e6a28fbfc87ef3) Lars Persson)  

## 1.0.5 (2026-06-02)

### Bug Fixes

-  Bump rimfrost-service-oul-asyncapi version ([bb0b4](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/bb0b402e416634c) Lars Persson)  
-  **deps**  update dependency org.immutables:value to v2.12.2 ([7088a](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/7088a9b18818490) renovate[bot])  
-  Add basic tests for verifying rimfrost-framework-oul ([088a8](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/088a8b6ba2c367e) Lars Persson)  

### Dependency updates

- update dependency org.immutables:value-processor to v2.12.2 ([1ae78](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/1ae782a61410674) renovate[bot])  
- update dependency org.junit.jupiter:junit-jupiter to v5.14.4 ([3a713](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/3a7131e7b53fba6) renovate[bot])  
- add renovate.json ([3b1b6](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/3b1b672901d3424) renovate[bot])  
## 1.0.4 (2026-05-13)

### Bug Fixes

-  removed OUL kafka messaging ([95679](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/95679c137966afe) Ulf Slunga)  

### Other changes

**Restore kafka functionality still required by OUL**

* This commit restores some parts removed in previous commit that 
* is still needed by OUL (parts related to status notification). It 
* also removes parts related to OulResponse since that is handled by 
* REST api. The commit also bumps dependency versions. 

[68dfa](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/68dfacceaa726de) Lars Persson *2026-05-13 07:20:57*


## 1.0.3 (2026-05-08)

### Bug Fixes

-  lägger till cloudevent attributes till OUL response, inklusive test ([01a93](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/01a936690c91f38) Ulf Slunga)  

## 1.0.2 (2026-05-07)

### Bug Fixes

-  lägger till testfall ([547bc](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/547bc1d6488b482) Ulf Slunga)  
-  ny status Avbruten ([c7c88](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/c7c88ecbabd1abd) Ulf Slunga)  

## 1.0.1 (2026-05-07)

### Bug Fixes

-  cloudevent attributes ([f1e07](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/f1e07e490a23da6) Ulf Slunga)  

## 1.0.0 (2026-04-28)

### Breaking changes

-  release 1.0 ([38b94](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/38b94576c9d3536) Ulf Slunga)  

### Features

-  release 1.0 ([38b94](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/38b94576c9d3536) Ulf Slunga)  

### Bug Fixes

-  released versions ([d3421](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/d34216ad758cd0f) Ulf Slunga)  

## 0.1.7 (2026-04-14)

### Bug Fixes

-  mappar till UppgiftStatus ([198bf](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/198bf7e3623d7a0) Ulf Slunga)  
-  bump asyncapi. Status som enum ist för string ([9f3e2](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/9f3e235510410aa) Ulf Slunga)  

## 0.1.6 (2026-04-10)

### Bug Fixes

-  status och idtyp uppdaterad. public toApiIdtyp ([2a189](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/2a1892d9b0185e3) Ulf Slunga)  

## 0.1.5 (2026-04-08)

### Bug Fixes

-  Use Idtyp for individ list and utforarId ([5cc56](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/5cc56fcbf2f760b) Lars Persson)  

## 0.1.4 (2026-03-24)

### Bug Fixes

-  Add individuals involved in yrkande to OUL request message ([906b2](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/906b2e5f578f3c2) Lars Persson)  

## 0.1.3 (2026-03-04)

### Bug Fixes

-  Rename kundbehovsflode to handlaggning ([5ba57](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/5ba579fc5f3672d) Lars Persson)  

## 0.1.2 (2026-02-11)

### Bug Fixes

-  Remove rule rest dependencies ([ce3d3](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/ce3d3898bf2d8df) Lars Persson)  
-  uppdaterar README ([b3ce9](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/b3ce9923baa2cfb) Ulf Slunga)  
-  uppdaterar README ([fa31b](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/fa31bc7a73f6165) Ulf Slunga)  

## 0.1.1 (2026-02-05)

### Bug Fixes

-  remove Message from emitter in oulproducer. ([f8813](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/f8813a61a50a450) Nils Elveros)  

## 0.1.0 (2026-02-05)

### Features

-  add replyTo metadata header in OulRequestMessage ([04abf](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/04abfd7cfaf7306) Nils Elveros)  

## 0.0.5 (2026-02-05)

### Bug Fixes

-  Add shared /done endpoint ([d3513](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/d3513a99bf400cd) Lars Persson)  

## 0.0.4 (2026-02-02)

### Bug Fixes

-  spotless ([e47c6](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/e47c6698d9c76cf) Nils Elveros)  
-  reintroduce integration package which was removed by misstake ([64aa7](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/64aa7d196b2c693) Nils Elveros)  

### Other changes

**fix**


[12ad5](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/12ad5e286ee031f) Nils Elveros *2026-02-02 09:34:17*


## 0.0.3 (2026-01-30)

### Bug Fixes

-  groupid se.fk.rimfrost.framework.oul ([8ceff](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/8ceffd289d27b7b) Nils Elveros)  

### Other changes

**change parent artifact**


[c62ac](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/c62ac27c634fd36) Nils Elveros *2026-01-30 13:01:31*


## 0.0.2 (2026-01-29)

### Bug Fixes

-  bump version to trigger release ([69e9c](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/69e9c98bf6978b1) Ulf Slunga)  

### Other changes

**Delete .github/workflows/maven-ci.yaml**


[6c380](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/6c3804ea11c546d) Ulf Slunga *2026-01-29 11:18:15*

**Delete .github/workflows/maven-release.yaml**


[1480e](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/1480e1a08c4fcd2) Ulf Slunga *2026-01-29 11:17:59*

**Add files via upload**


[f30a9](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/f30a9d43b0e7b4a) Ulf Slunga *2026-01-29 11:16:57*


## 0.0.1 (2026-01-28)

### Bug Fixes

-  Copy/paste av reusable-components för manuella regler från rimfrost-common ([3e6c3](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/3e6c3fca15a6d5b) Ulf Slunga)  

### Other changes

**spotless apply**


[9aade](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/9aade5bbd653fa7) Ulf Slunga *2026-01-28 11:21:19*

**Lägger till utforarId i OUL status**


[3861b](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/3861bb66133c827) Ulf Slunga *2026-01-28 11:16:00*

**Tar bort dependency till common async api**


[44d3c](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/44d3c7b07ed9052) Ulf Slunga *2026-01-27 14:26:26*

**spotless apply**


[5bad9](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/5bad96d0a684c8c) Ulf Slunga *2026-01-27 13:09:09*

**renaming to Oul-prefix for consumers, producers and mappers**


[34b40](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/34b402e6d2b2151) Ulf Slunga *2026-01-27 13:03:55*

**maven support**


[34616](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/34616735d96e9ec) Ulf Slunga *2026-01-27 06:20:10*

**Create CODEOWNERS**


[f77ca](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/f77cae121f6bd98) Ulf Slunga *2026-01-27 06:03:51*

**Create maven-release.yaml**


[31e64](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/31e64ac06a5ed49) Ulf Slunga *2026-01-27 06:03:22*

**Create maven-ci.yaml**


[5a84c](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/5a84cbf5a41037f) Ulf Slunga *2026-01-27 06:02:52*

**Initial commit**


[1178b](https://github.com/Forsakringskassan/rimfrost-framework-oul/commit/1178b74cdb3c30a) Ulf Slunga *2026-01-27 06:01:30*


