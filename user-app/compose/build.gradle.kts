import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    androidLibrary {
        namespace = libs.versions.userApp.compose.androidLibrary.namespace.get()
        compileSdk = libs.versions.userApp.compose.androidLibrary.compileSdk.get().toInt()
        minSdk = libs.versions.userApp.compose.androidLibrary.minSdk.get().toInt()
    }

    jvm("desktop") {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_21
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.localina)
            implementation(libs.koin.core)
            implementation(libs.bundles.compose.multiplatform)
            implementation(projects.designSystem.compose)
            implementation(projects.shared)
            implementation(projects.features.userOnboarding)
        }
    }
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/user-app/Compose"))