plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")

    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
}

android {
    namespace = Config.applicationDataId
    compileSdk = Config.compileSdkVersion

    defaultConfig {
        minSdk = Config.minSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {
            buildConfigField("String", "BASE_URL", "\"https://demo7322680.mockable.io/\"")


        }
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(Dependencies.AndroidX.CoreKtx)

    api(Dependencies.Retrofit.Retrofit)
    implementation(Dependencies.Retrofit.MoshiAdapter)

    implementation(Dependencies.Hilt.Hilt)
    kapt(Dependencies.Hilt.Compiler)

    implementation(Dependencies.Retrofit.Interceptor.OkHttp)
    implementation(Dependencies.Retrofit.Interceptor.Interceptor)

    implementation(Dependencies.Room.Runtime)
    kapt(Dependencies.Room.Compiler)

    implementation(platform("com.google.firebase:firebase-bom:32.2.3"))
    implementation("com.google.firebase:firebase-firestore-ktx")
    implementation("com.google.firebase:firebase-auth-ktx")

    implementation("com.google.android.gms:play-services-auth:20.7.0")
}