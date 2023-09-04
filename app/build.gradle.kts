plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = Config.applicationId
    compileSdk = 34

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependencies.AndroidX.CoreKtx)

    implementation(Dependencies.Lyfecycle.runtime)
    implementation(Dependencies.Compose.Activity)

    implementation(platform(Dependencies.Compose.Boom))
    implementation(Dependencies.Compose.UI)
    implementation(Dependencies.Compose.Graphics)
    implementation(Dependencies.Compose.Preview)

    debugImplementation(Dependencies.Compose.Tooling)
    debugImplementation(Dependencies.Compose.Manifest)

    implementation(Dependencies.Compose.Material)
    implementation(Dependencies.Compose.Material3)

    testImplementation(Dependencies.Test.Junit)
    androidTestImplementation(Dependencies.Test.JunitExt)
    androidTestImplementation(Dependencies.Test.EspressoCore)

    implementation(Dependencies.ConstraintLayout.Compose)
    implementation(Dependencies.ConstraintLayout.Flowlayout)

    implementation(Dependencies.Navigation.Hilt_Compose)
    implementation(Dependencies.Navigation.Compose)

    implementation(Dependencies.Hilt.Hilt)
    kapt(Dependencies.Hilt.Compiler)

    implementation(Dependencies.Iol.Compose)

    implementation(Dependencies.Maps.Services)
    implementation(Dependencies.Maps.Compose)
    implementation(project(":data"))


}