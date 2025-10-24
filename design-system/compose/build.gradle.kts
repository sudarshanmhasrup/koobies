import com.android.build.api.dsl.androidLibrary

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.designSystem.compose.group.get()
version = libs.versions.designSystem.compose.version.get()

kotlin {
    @Supress("UnstableApiUsage")
    androidLibrary {
        namespace = libs.versions.designSystem.compose.androidLibrary.namespace.get()
        compileSdk = libs.versions.designSystem.compose.androidLibrary.compileSdk.get().toInt()
        minSdk = libs.versions.designSystem.compose.androidLibrary.minSdk.get().toInt()
    }

    jvm()
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/design-system/Compose"))