plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.gms.google-services")
    id("com.google.devtools.ksp")
    id ("com.google.dagger.hilt.android")

}

android {
    namespace = "com.example.pingme"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.pingme"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation("androidx.compose.material:material-icons-extended:1.7.7")
   // implementation ("androidx.compose.material:material-icons-extended:$compose_version")
    implementation(platform("com.google.firebase:firebase-bom:33.8.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.firebase.auth)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.runtime.livedata)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation( libs.hilt.android)
    ksp (libs.google.hilt.compiler)

    // For instrumentation tests
    androidTestImplementation  (libs.hilt.android.testing)
    kspAndroidTest (libs.google.hilt.compiler)

    // For local unit tests
    testImplementation (libs.hilt.android.testing)
    kspTest (libs.google.hilt.compiler)

    val voyagerVersion = "1.1.0-beta02"
    // Navigator
    implementation(libs.voyager.navigator)

    // Screen Model
    implementation(libs.voyager.screenmodel)

    // BottomSheetNavigator
    implementation(libs.voyager.bottom.sheet.navigator)

    // TabNavigator
    implementation(libs.voyager.tab.navigator)
}