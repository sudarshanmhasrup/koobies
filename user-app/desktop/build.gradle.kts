import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.userApp.desktop.group.get()
version = libs.versions.userApp.desktop.version.get()

kotlin {
    jvm("desktop") {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
    }
}

layout.buildDirectory.set(file("$rootDir/.build/user-app/desktop"))