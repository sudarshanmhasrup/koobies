import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {
    androidLibrary {
        namespace = libs.versions.features.userOnboarding.androidLibrary.namespace.get()
        compileSdk = libs.versions.features.userOnboarding.androidLibrary.compileSdk.get().toInt()
        minSdk = libs.versions.features.userOnboarding.androidLibrary.minSdk.get().toInt()
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
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.bundles.compose.multiplatform)
        }
    }
}

compose.resources {
    generateResClass = never
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/features/user-onboarding"))