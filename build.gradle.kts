plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id ("com.github.ben-manes.versions") version "0.51.0"

}

android {
    namespace = "exa.sa.myappwael" // استبدلها بـ namespace الخاص بمشروعك.
    compileSdk = 35 // ضع إصدار SDK المطلوب هنا.

    defaultConfig {
        applicationId = "exa.sa.myappwael"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        signingConfig = signingConfigs.getByName("debug")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
    buildToolsVersion = "35.0.0"
}
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath (libs.androidx.room.gradle.plugin)
    }
}
