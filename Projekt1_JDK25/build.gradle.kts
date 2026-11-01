// Android Gradle Plugin 9.x zawiera obsługę języka Kotlin (built-in Kotlin).
// Nie należy dodatkowo włączać org.jetbrains.kotlin.android.
plugins {
    id("com.android.application") version "9.4.0" apply false

    // Plugin Compose Compiler musi mieć zgodną wersję z Kotlinem.
    id("org.jetbrains.kotlin.plugin.compose") version "2.4.10" apply false
}
