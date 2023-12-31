plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.team99"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.team99"
        minSdk = 33
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        dataBinding = true
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation ("com.squareup.picasso:picasso:2.71828") // Picasso 의존성 추가
    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    // Fragment KTX (includes viewModels function)
    implementation ("androidx.fragment:fragment-ktx:1.3.6")

    //splash
    implementation ("pl.droidsonroids.gif:android-gif-drawable:1.2.19")



    implementation ("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.constraintlayout:constraintlayout-core:1.0.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
    //cardview
    implementation ("androidx.recyclerview:recyclerview:1.0.0")
    implementation ("androidx.cardview:cardview:1.0.0")
    //glide
    implementation ("com.github.bumptech.glide:glide:4.11.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.11.0")
    // Room components
    implementation ("androidx.room:room-runtime:2.5.2")
    annotationProcessor ("androidx.room:room-compiler:2.5.2")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation ("androidx.room:room-ktx:2.5.2")
    // optional - Test helpers
    testImplementation ("androidx.room:room-testing:2.5.2")
    // Kotlinx Serilaization
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    //Retrofit
    implementation ("com.squareup.okhttp3:okhttp:4.9.1")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.10.0")
    //Okhttp


    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
    // cardview
    implementation("androidx.recyclerview:recyclerview:1.0.0")
    implementation("androidx.cardview:cardview:1.0.0")

    // Retrofit and Gson
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // OkHttp and Logging Interceptor
    implementation("com.squareup.okhttp3:okhttp:4.9.1")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
    //Exoplayer
    implementation ("com.google.android.exoplayer:exoplayer:2.19.1")
    implementation ("com.google.android.exoplayer:exoplayer-core:2.19.1")
    implementation ("com.google.android.exoplayer:exoplayer-dash:2.19.1")
    implementation ("com.google.android.exoplayer:exoplayer-ui:2.19.1")
    implementation ("com.squareup.picasso:picasso:2.71828")
}
