import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.shared.group.get()
version = libs.versions.shared.version.get()

kotlin {
    androidLibrary {
        namespace = libs.versions.shared.androidLibrary.namespace.get()
        compileSdk = libs.versions.shared.androidLibrary.compileSdk.get().toInt()
        minSdk = libs.versions.shared.androidLibrary.minSdk.get().toInt()
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
            implementation(projects.designSystem.compose)
        }
    }
}

compose.resources {
    val directoryProvider = provider { layout.projectDirectory.dir("src/commonMain/resources") }
    customDirectory(sourceSetName = "commonMain", directoryProvider = directoryProvider)
    publicResClass = true
    packageOfResClass = libs.versions.shared.packageOfResClass.get()
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/Shared"))