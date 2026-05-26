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

layout.buildDirectory.set(file("$rootDir/.build/user-app/android"))