plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.designSystem.compose.group.get()
version = libs.versions.designSystem.compose.version.get()

kotlin {
    android {
        namespace = libs.versions.designSystem.compose.androidLibrary.namespace.get()
        compileSdk = libs.versions.designSystem.compose.androidLibrary.compileSdk.get().toInt()
        minSdk = libs.versions.designSystem.compose.androidLibrary.minSdk.get().toInt()
    }
}

layout.buildDirectory.set(file("$rootDir/.build/design-system/compose"))