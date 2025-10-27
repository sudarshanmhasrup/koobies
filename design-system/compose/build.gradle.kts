import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    androidLibrary {
        namespace = libs.versions.designSystem.compose.androidLibrary.namespace.get()
        compileSdk = libs.versions.designSystem.compose.androidLibrary.compileSdk.get().toInt()
        minSdk = libs.versions.designSystem.compose.androidLibrary.minSdk.get().toInt()
    }

    jvm {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_21
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.bundles.compose.multiplatform)
        }
    }
}

compose.resources {
    generateResClass = never
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/design-system/Compose"))