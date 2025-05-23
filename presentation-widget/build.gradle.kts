plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "tachiyomi.presentation.widget"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = compose.versions.compiler.get()
    }
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.domain)
    implementation(projects.presentationCore)
    api(projects.i18n)
    api(project(":i18n-sy"))

    implementation(compose.glance)

    implementation(kotlinx.immutables)

    implementation(platform(libs.coil.bom))
    implementation(libs.coil.core)

    // SY -->
    implementation(libs.material)
    // SY <--
    
    api(libs.injekt.core)
}
