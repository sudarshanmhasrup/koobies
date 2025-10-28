import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.hot.reload)
}

group = libs.versions.userApp.desktop.group.get()
version = libs.versions.userApp.desktop.version.get()

kotlin {
    jvm("desktop") {
        java {
            @Suppress("UnstableApiUsage")
            toolchain {
                languageVersion.set(JavaLanguageVersion.of("21"))
                vendor.set(JvmVendorSpec.JETBRAINS)
            }
            sourceCompatibility = JavaVersion.VERSION_21
            targetCompatibility = JavaVersion.VERSION_21
        }

        compilerOptions {
            jvmTarget = JvmTarget.JVM_21
        }
    }

    sourceSets {
        val desktopMain by getting
        commonMain.dependencies {
            implementation(libs.bundles.koin.multiplatform)
            implementation(libs.bundles.compose.multiplatform.lifecycle)
            implementation(libs.bundles.compose.multiplatform)
            implementation(projects.userApp.compose)
            implementation(projects.shared)
        }
        desktopMain.dependencies {
            implementation(libs.kotlinx.coroutines.swing)
            implementation(compose.desktop.currentOs)
        }
    }
}

compose{
    resources {
        generateResClass = never
    }
    desktop {
        application {
            mainClass = libs.versions.userApp.desktop.mainClass.get()

            nativeDistributions {
                targetFormats = setOf(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
                packageName = libs.versions.userApp.desktop.distributionPackageName.get()
                packageVersion = libs.versions.userApp.desktop.distributionPackageVersion.get()
            }
        }
    }
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/user-app/desktop"))