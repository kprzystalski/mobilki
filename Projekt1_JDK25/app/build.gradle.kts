plugins {
    id("com.android.application")
    // AGP 9.x ma wbudowaną obsługę Kotlin — bez kotlin-android.
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "pl.edu.demo.compose"
    compileSdk = 36

    defaultConfig {
        applicationId = "pl.edu.demo.compose"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    // UWAGA DLA STUDENTÓW:
    // JDK 25 służy do budowania aplikacji, ale urządzenie Android nie
    // uruchamia JVM 25. Kod kompilujemy do zgodnego bytecode JVM 17,
    // który AGP konwertuje do formatu DEX dla środowiska Android (ART).
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
    }
}

// Wymagamy JDK 25 na komputerze budującym (toolchain do kompilacji).
// W Android Studio ustaw ponadto Gradle JDK = 25.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

// Zgodnie z sourceCompatibility i targetCompatibility:
// wygenerowany kod Kotlin pozostaje kompatybilny z Androidem.
kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }
}

dependencies {
    // Współdziałające biblioteki Jetpack Compose.
    implementation(platform("androidx.compose:compose-bom:2026.06.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.activity:activity-compose:1.13.0")
}
