object Dependencies {

    object Kotlin {
        const val Stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
        const val Coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9"
    }

    object Compose {
        const val Boom = "androidx.compose:compose-bom:2023.03.00"
        const val UI = "androidx.compose.ui:ui"
        const val Graphics = "androidx.compose.ui:ui-graphics"
        const val Preview = "androidx.compose.ui:ui-tooling-preview"
        const val Tooling = "androidx.compose.ui:ui-tooling"
        const val Manifest = "androidx.compose.ui:ui-test-manifest"
        const val Activity = "androidx.activity:activity-compose:1.7.2"
        const val Material = "androidx.compose.material:material:1.5.0"
        const val Material3 = "androidx.compose.material3:material3"
    }

    object AndroidX {
        const val CoreKtx = "androidx.core:core-ktx:1.10.0"
    }

    object Test {
        const val EspressoCore = "androidx.test.espresso:espresso-core:3.4.0"
        const val Junit = "junit:junit:4.13.2"
        const val JunitExt = "androidx.test.ext:junit:1.1.3"
    }

    object ConstraintLayout {
        const val Compose = "androidx.constraintlayout:constraintlayout-compose:1.0.1"
        const val Flowlayout = "com.google.accompanist:accompanist-flowlayout:0.20.0"
    }

    object Navigation {
        const val Compose = "androidx.navigation:navigation-compose:2.6.0"
        const val Hilt_Compose = "androidx.hilt:hilt-navigation-compose:1.0.0"
    }

    object Hilt {
        const val Hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val Compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    }

    object Room {
        const val Runtime = "androidx.room:room-runtime:${Versions.room}"
        const val Compiler = "androidx.room:room-compiler:${Versions.room}"
        const val Testing = "androidx.room:room-testing:${Versions.room}"
        const val Coroutines = "androidx.room:room-coroutines:${Versions.room}"
        const val Ktx = "androidx.room:room-ktx:${Versions.room}"
    }

    object Iol {
        const val Compose = "io.coil-kt:coil-compose:2.0.0-rc01"
    }

    object Maps {
        const val Compose = "com.google.maps.android:maps-compose:1.0.0"
        const val Services = "com.google.android.gms:play-services-maps:18.0.2"
    }

    object Retrofit {
        const val Retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val MoshiAdapter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

        object Interceptor {
            const val OkHttp = "com.squareup.okhttp3:okhttp:4.10.0"
            const val Interceptor = "com.squareup.okhttp3:logging-interceptor:4.9.3"
        }
    }

    object Lyfecycle {
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
        const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    }

}