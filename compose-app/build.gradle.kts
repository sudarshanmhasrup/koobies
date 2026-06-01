plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.composeApp.group.get()
version = libs.versions.composeApp.version.get()

kotlin {
    android {
        namespace = libs.versions.composeApp.androidLibrary.namespace.get()
        compileSdk = libs.versions.composeApp.androidLibrary.compileSdk.get().toInt()
        minSdk = libs.versions.composeApp.androidLibrary.minSdk.get().toInt()
    }
}

layout.buildDirectory.set(file("$rootDir/.build/compose-app"))