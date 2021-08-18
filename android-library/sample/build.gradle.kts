plugins {
    android("application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdk = SDK_TARGET
    defaultConfig {
        minSdk = SDK_MIN
        targetSdk = SDK_TARGET
        multiDexEnabled = true
        applicationId = "com.example.$RELEASE_ARTIFACT"
        version = RELEASE_VERSION
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    sourceSets {
        named("main") {
            manifest.srcFile("AndroidManifest.xml")
            java.srcDir("src")
            res.srcDir("res")
            resources.srcDir("src")
        }
    }
    buildTypes {
        named("debug") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        named("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    lint {
        isAbortOnError = false
    }
}

dependencies {
    implementation(kotlin("stdlib", VERSION_KOTLIN))
    implementation(project(":$RELEASE_ARTIFACT"))
    implementation(material())
    implementation(androidx("multidex", version = VERSION_MULTIDEX))
    implementation(androidx("core", "core-ktx"))
}