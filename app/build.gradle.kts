plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.atividade2"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.atividade2"
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


    // Jetpack Compose BOM - SEMPRE verifique a versão mais recente!
    // Exemplo: '2024.06.00' é uma boa aposta para uma versão recente, mas confira no site oficial.
    implementation(platform("androidx.compose:compose-bom:2024.06.00")) // Verifique aqui: developer.android.com/jetpack/compose/bom
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3") // Ou 'material' se você estiver usando a versão antiga do Material Design

    // ExoPlayer (Media3) - SEMPRE verifique a versão mais recente!
    // Exemplo: '1.3.1' é uma boa aposta para uma versão recente, mas confira no site oficial.
    implementation("androidx.media3:media3-exoplayer:1.3.1") // Verifique aqui: developer.android.com/jetpack/androidx/releases/media3
    implementation("androidx.media3:media3-common:1.3.1")
    // A linha abaixo é opcional, mas boa se for usar componentes de UI padrão do ExoPlayer
    // implementation("androidx.media3:media3-ui:1.3.1")

    dependencies {
        // ... suas outras dependências

        // ExoPlayer (Media3)
        implementation("androidx.media3:media3-exoplayer:1.3.1") // Verifique a versão mais recente
        implementation("androidx.media3:media3-common:1.3.1")
        // implementation("androidx.media3:media3-ui:1.3.1") // Opcional para UI
    }


    dependencies {
        // ... suas outras dependências (Compose BOM, Material3, ExoPlayer, etc.)

        // Dependência do Navigation Compose
        implementation("androidx.navigation:navigation-compose:2.8.0-beta02") // Verifique a versão mais recente e estável!
    }

    dependencies {
        // Jetpack Compose BOM - CRÍTICO: USE SEMPRE A VERSÃO MAIS RECENTE!
        // Consulte: https://developer.android.com/jetpack/compose/bom
        // Verifique a versão mais atual, exemplo:
        implementation(platform("androidx.compose:compose-bom:2024.06.00")) // Ou a mais recente estável!

        // Compose UI
        implementation("androidx.compose.ui:ui")
        implementation("androidx.compose.ui:ui-graphics")
        implementation("androidx.compose.ui:ui-tooling-preview") // Essencial para o preview e ferramentas

        // Compose Material Design
        implementation("androidx.compose.material3:material3")

        // Navigation Compose - CRÍTICO para navegação!
        // Consulte: https://developer.android.com/jetpack/androidx/releases/navigation
        // Verifique a versão mais atual, exemplo:
        implementation("androidx.navigation:navigation-compose:2.8.0-beta02") // Ou a mais recente estável!

        // ExoPlayer (Media3) - CRÍTICO para o player de áudio!
        // Consulte: https://developer.android.com/jetpack/androidx/releases/media3
        // Verifique a versão mais atual, exemplo:
        implementation("androidx.media3:media3-exoplayer:1.3.1") // Ou a mais recente estável!
        implementation("androidx.media3:media3-common:1.3.1")
        // implementation("androidx.media3:media3-ui:1.3.1") // Opcional, para componentes de UI do ExoPlayer

        // Dependências de teste (geralmente já vêm por padrão)
        testImplementation(kotlin("test"))
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
        androidTestImplementation(platform("androidx.compose:compose-bom:2024.06.00"))
        androidTestImplementation("androidx.compose.ui:ui-test-junit4")
        debugImplementation("androidx.compose.ui:ui-tooling")
        debugImplementation("androidx.compose.ui:ui-test-manifest")
    }





    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation ("androidx.navigation:navigation-compose:2.9.0")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)




    implementation("androidx.navigation:navigation-compose:2.7.0") // Or the latest stable version
    implementation("androidx.media3:media3-exoplayer:1.2.1") // Or the latest stable version
    implementation("androidx.media3:media3-ui:1.2.1") // For player UI components, if you were to use them later
// For Material Icons Extended if you use more icons
    implementation("androidx.compose.material:material-icons-extended")
}