plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id ("androidx.navigation.safeargs.kotlin")
}

android {
    namespace ="com.elewa.thmanyahpodcast"
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId  = "com.elewa.thmanyahpodcast"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner  = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility  = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // -------------------------------------- Hilt -------------------------------
    implementation(Hilt.hiltAndroid)
    kapt(Hilt.hiltCompiler)

    // timber
    implementation(Utils.timber)

    // glide
    implementation(Glide.glide)
    kapt(Glide.glideKapt)

    // navigation
    implementation(Navigation.navigation)
    implementation(Navigation.navigationFragment)

    // gson
    implementation(Retrofit.retrofitGson)


    // -------------------------------------------- lifecycle -------------------------------
    implementation(Lifecycle.coreLifeCycle)
    implementation(Lifecycle.fragmentLifeCycle)
    implementation(Lifecycle.activityLifeCycle)
    implementation(Lifecycle.runtimeLifeCycle)
    implementation(Lifecycle.livedataLifeCycle)
    implementation(Lifecycle.viewmodelLifeCycle)

    // ------------ android ui-------------------------------------
    implementation(AndroidUI.appCompact)
    implementation(AndroidUI.materialDesign)
    implementation(AndroidUI.constraintLayout)

    // ------------ testing -------------------------------------
    // Local Unit Tests
    testImplementation (Test.junit)
    testImplementation (Test.hamcrest)
    testImplementation (Test.testingCore)
    testImplementation (Test.robolectric)
    testImplementation (Test.testingCoroutines)
    testImplementation (Test.truth)
    testImplementation (Test.mockito)
    testImplementation (Test.hilt)
    kaptTest (Test.kaptHilt)

    // Instrumented Unit Tests
    androidTestImplementation (Test.junit)
    androidTestImplementation (Test.testingCoroutines)
    androidTestImplementation (Test.testingCore)
    androidTestImplementation (Test.truth)
    androidTestImplementation (Test.junitExt)
    androidTestImplementation (Test.espresso)
    androidTestImplementation (Test.mockito)
    androidTestImplementation (Test.hilt)
    kaptAndroidTest (Test.kaptHilt)
}