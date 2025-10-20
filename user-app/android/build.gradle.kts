plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = libs.versions.userApp.android.namespace.get()
    compileSdk = libs.versions.userApp.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = libs.versions.userApp.android.applicationId.get()
        minSdk = libs.versions.userApp.android.minSdk.get().toInt()
        targetSdk = libs.versions.userApp.android.targetSdk.get().toInt()
        versionCode = libs.versions.userApp.android.versionCode.get().toInt()
        versionName = libs.versions.userApp.android.versionName.get()
    }
}

dependencies {
    implementation(libs.activity.compose)
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/user-app/Android"))