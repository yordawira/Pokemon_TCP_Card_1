plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}


val API_BASE = "https://pokeapi.co/api/v2/"



android {
    namespace = "com.catty.pokemon_tcp_card_1"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.catty.pokemon_tcp_card_1"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        manifestPlaceholders
        var can_export_components = false

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            versionNameSuffix = "-debug"
            buildConfigField("String", "API_BASE", "\"$API_BASE\"")

            manifestPlaceholders["can_export_components"] = "true"
        }
        release {
            buildConfigField("String", "API_BASE", "\"$API_BASE\"")
            var minifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {

    implementation ("androidx.core:core-ktx:1.12.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.9.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")

    // Retrofit
    // https://square.github.io/retrofit/
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:4.10.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.3")

    // Coroutine Lifecycle Scopes
    // https://developer.android.com/topic/libraries/architecture/coroutines#lifecyclescope
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

    // Compose
    // https://developer.android.com/jetpack/compose

    implementation ("androidx.compose.material:material:1.5.1")
    implementation ("androidx.navigation:navigation-compose:2.7.3") // Needed for hilt navigation
    implementation ("com.google.accompanist:accompanist-swiperefresh:0.26.5-rc")

    // TODO: Try to use latest version of accompanist swiperefresh, not too much information :(

    //Dagger - Hilt
    // https://developer.android.com/training/dependency-injection/hilt-android
    implementation ("com.google.dagger:hilt-android:2.44")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")
    kapt ("com.google.dagger:hilt-compiler:2.44")

    // Images - Coil (More lightweight than Glide, More modern than Picasso)
    // https://coil-kt.github.io/coil/
    implementation ("io.coil-kt:coil-compose:2.2.2")

    // Testing
    implementation ("androidx.test:core:1.5.0")
    testImplementation ("junit:junit:4.13.2")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    testImplementation ("androidx.arch.core:core-testing:2.2.0")
    testImplementation ("org.mockito:mockito-core:4.4.0")
    testImplementation ("org.mockito:mockito-inline:3.11.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androwidx.test.espresso:espresso-core:3.5.1")

}