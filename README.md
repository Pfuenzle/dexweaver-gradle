# DexWeaver-gradle
### Modify Android APK files at source-level using Java, graphical resource editors, and the full power of Android Studio in all major platforms.

**DexWeaver** is a fork of [DexPatcher-gradle](https://github.com/DexPatcher/dexpatcher-gradle) by
**Rodrigo Balerdi (Lanchon)** — <https://dexpatcher.github.io/>.

---

## Attribution

DexWeaver-gradle is a **fork** of the following upstream project and is derived from its source code:

| | |
| - | - |
| Upstream project | [DexPatcher/dexpatcher-gradle](https://github.com/DexPatcher/dexpatcher-gradle) |
| Upstream author | Rodrigo Balerdi ([Lanchon](https://github.com/Lanchon)) |
| Upstream website | <https://dexpatcher.github.io/> |
| License | GNU General Public License v3.0 or later |
| Upstream version forked | `2.1.3` |

The upstream project is licensed under the **GNU General Public License, version 3 or later**.
That license is retained in full for this fork — see [`LICENSE.txt`](LICENSE.txt) and
[`NOTICE.txt`](NOTICE.txt). The original copyright headers of the upstream author are preserved
verbatim in every source file that was carried over.

Upstream notices that apply to this fork:

* DexPatcher is free software: you can redistribute it and/or modify it under the terms of the
  GNU General Public License as published by the Free Software Foundation, either version 3 of the
  License, or (at your option) any later version.
* DexPatcher is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
  even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
  General Public License for more details.
* You should have received a copy of the GNU General Public License along with DexPatcher. If not,
  see <https://www.gnu.org/licenses/gpl.txt>.

This fork is maintained independently and is not affiliated with or endorsed by the upstream
project.

---

## Packages

The Groovy packages were renamed from `lanchon.dexpatcher.gradle` to `io.pfuenzle.dexweaver.gradle`,
and the plugin ids from `com.github.lanchon.dexpatcher.*` to `io.pfuenzle.dexweaver.*`:

| Upstream | This fork |
| - | - |
| `com.github.lanchon.dexpatcher.base` | `io.pfuenzle.dexweaver.base` |
| `com.github.lanchon.dexpatcher.apk-library` | `io.pfuenzle.dexweaver.apk-library` |
| `com.github.lanchon.dexpatcher.patched-application` | `io.pfuenzle.dexweaver.patched-application` |
| `com.github.lanchon.dexpatcher.patch-library` | `io.pfuenzle.dexweaver.patch-library` |

The Gradle extension and task names (`dexpatcherConfig`, `dexpatcher`, …) are unchanged, so existing
build scripts keep working.

---

## Usage

Artifacts are published to [JitPack](https://jitpack.io) and can be consumed anonymously:

```gradle
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.Pfuenzle.dexweaver-gradle:dexweaver-gradle:v2.1.4'
}
```

```gradle
plugins {
    id 'io.pfuenzle.dexweaver.base' version 'v2.1.4'
}
```

The version is the Git tag name, so it always carries the `v` prefix.

### Mapping checks

The patched-application plugin creates one finder validation task per Android variant:

```sh
./gradlew :app:checkMappingsRelease
```

The task compiles the patch sources but does not package or sign an APK. It validates every
`@DexFinder` against the decoded source APK, prints the resolved source member for each mapping,
and fails with every missing class, method, or field. `checkMappings` aggregates all variants.

DexWeaver is free software. (GPLv3+)
