# Kotlin + Jetpack Compose — aplikacja Android budowana z JDK 25

Projekt zawiera:  **jedną aktywność `MainActivity`**, `Text` (odpowiednik Label), `Button`, `Row`, `Column`, interaktywny stan Compose oraz wszystkie podstawowe metody cyklu życia Activity.

## Wersje i rozróżnienie JDK / JVM

| Element | Ustawienie |
|---|---|
| **JDK do kompilowania i uruchamiania Gradle** | **25** |
| **Gradle** | **9.6.1** |
| **Android Gradle Plugin** | **9.4.0** |
| **Compose Compiler Gradle Plugin / Kotlin** | **2.4.10** |
| **Wersja bytecode JVM** | **17** |
| **compileSdk** | **36** |
| **minSdk / targetSdk** | **24 / 35** |
| **Compose BOM** | **2026.06.00** |

## Źródła

- Gradle / Java 25: https://docs.gradle.org/current/userguide/compatibility.html
- AGP 9.4: https://developer.android.com/build/releases/agp-9-4-0-release-notes
- Migracja do built-in Kotlin: https://developer.android.com/build/migrate-to-built-in-kotlin
- JDK a kompilacja aplikacji Android: https://developer.android.com/build/jdks
- Compose Compiler: https://kotlinlang.org/docs/compose-compiler-migration-guide.html
- Activity lifecycle: https://developer.android.com/guide/components/activities/activity-lifecycle