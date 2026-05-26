import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.userApp.android.group.get()
version = libs.versions.userApp.android.version.get()

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_11
    }
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
    implementation(libs.activity)
}

layout.buildDirectory.set(file("$rootDir/.build/user-app/android"))