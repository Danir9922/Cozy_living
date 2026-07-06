# Cozy Living — Fabric mod (Minecraft 1.20.1)

Мод добавляет уютную мебель:
- **Cozy Lamp** — светящаяся лампа (light level 15), крафтится из факела + железного слитка.
- **Cozy Sofa** — диван (декоративный, с формой сиденья+спинки+подлокотников).
- **Cozy Table** — стол на 4 ножках.
- **Cozy Chair** — стул, на который можно **сесть** (ПКМ по блоку).
- **Cozy Rug** — тонкий ковёр (как ковёр из шерсти).

Все блоки крафтятся из ванильных материалов (дерево, шерсть, палки, железо) — рецепты лежат в `data/cozy_living/recipes/`.

## Как собрать

1. Установи **JDK 17** (обязательно, Fabric 1.20.1 требует именно 17).
2. Открой папку проекта в IntelliJ IDEA (File → Open → выбери папку `cozy_living`), она сама подтянет Gradle.
   - Либо в терминале: `./gradlew build` (на Windows: `gradlew.bat build`) — но сначала нужно сгенерировать gradle wrapper (см. ниже).
3. Если у тебя нет `gradlew`/`gradlew.bat` — в IntelliJ выбери Gradle-проект, и IDE сама скачает нужный Gradle через `gradle.properties`. Либо выполни у себя (при наличии интернета и установленного Gradle):
   ```
   gradle wrapper --gradle-version 8.5
   ```
   в корне проекта, это создаст `gradlew`, `gradlew.bat` и папку `gradle/wrapper`.
4. Запусти `runClient` gradle-таску (в IDEA: панель Gradle → Tasks → fabric → runClient), чтобы протестировать мод в игре.
5. Собранный `.jar` появится в `build/libs/cozy_living-1.0.0.jar` после `build` — его нужно положить в папку `mods` установленного Fabric Loader 1.20.1 + Fabric API.

## Версии (gradle.properties)
- Minecraft: 1.20.1
- Yarn mappings: 1.20.1+build.10
- Fabric Loader: 0.15.11
- Fabric API: 0.92.2+1.20.1

Если сборка ругается на версии (Mojang могли обновить репозитории) — зайди на https://fabricmc.net/develop и подставь актуальные версии в `gradle.properties`.

## Структура
```
src/main/java/net/cozyliving/
  CozyLiving.java          — точка входа, регистрация + очистка "сидений" стула
  block/ModBlocks.java     — регистрация всех блоков и BlockItem'ов
  block/CozyLampBlock.java
  block/CozySofaBlock.java
  block/CozyTableBlock.java
  block/CozyChairBlock.java — логика посадки на стул через ArmorStand
  block/CozyRugBlock.java
  item/ModItemGroup.java   — вкладка "Уютный дом" в творческом инвентаре

src/main/resources/
  fabric.mod.json
  assets/cozy_living/      — blockstates, models, textures, lang (en_us, ru_ru)
  data/cozy_living/        — loot_tables (выпадение блоков) и recipes (крафт)
```

## Известные ограничения
- Диван, стол и стул — не полноценные "сидячие" 3D-модели со сглаженными формами, а составлены из простых кубов (voxel-style), но при желании можно доработать в Blockbench и просто заменить JSON-модели в `models/block/`.
- Только стул поддерживает механику сидения (через невидимый ArmorStand). Диван — чисто декоративный блок.
