import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.userApp.compose.group.get()
version = libs.versions.userApp.compose.version.get()

kotlin {
    androidLibrary {
        namespace = libs.versions.userApp.compose.androidLibrary.namespace.get()
        compileSdk = libs.versions.userApp.compose.androidLibrary.compileSdk.get().toInt()
        minSdk = libs.versions.userApp.compose.androidLibrary.minSdk.get().toInt()
    }

    jvm {
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
            implementation(libs.compose.multiplatform.runtime)
            implementation(libs.koin.core)
        }
    }
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/user-app/Compose"))