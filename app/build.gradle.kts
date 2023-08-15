plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.sunflower_myself"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.sunflower_myself"
        minSdk = 24
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
}

dependencies {
    // 뷰페이저2 라이브러리 추가
    implementation("androidx.viewpager2:viewpager2:1.0.0")
    implementation("com.google.android.material:material:1.9.0")

    implementation("androidx.room:room-runtime:2.4.0")
    annotationProcessor("androidx.room:room-compiler:2.4.0")

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}