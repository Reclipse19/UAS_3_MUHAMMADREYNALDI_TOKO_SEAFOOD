plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.example.lastchance"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.lastchance"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.room.common)
    implementation (libs.room.rxjava3)
    implementation (libs.room.runtime)
    annotationProcessor (libs.room.compiler)
    implementation (libs.glide)
    annotationProcessor (libs.compiler)
    implementation (libs.rxandroid)
    implementation (libs.rxjava)
    implementation (libs.androidx.lifecycle.livedata)
    implementation (libs.androidx.lifecycle.viewmodel)
    implementation (libs.lifecycle.extensions)
    annotationProcessor (libs.lifecycle.compiler)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    annotationProcessor(libs.room.compiler)
}