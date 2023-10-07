import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "tech.blocksquare.goya.build_logic.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.firebase.crashlytics.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("Application") {
            id = "eunmin.application"
            implementationClass = "ApplicationConventionPlugin"
        }
        register("ApplicationFirebase") {
            id = "eunmin.application.firebase"
            implementationClass = "ApplicationFirebaseConventionPlugin"
        }
        register("ApplicationSafeargs") {
            id = "eunmin.application.safeargs"
            implementationClass = "ApplicationSafeArgsConventionPlugin"
        }
        register("Library") {
            id = "eunmin.library"
            implementationClass = "LibraryConventionPlugin"
        }
        register("Hilt") {
            id = "eunmin.hilt"
            implementationClass = "HiltConventionPlugin"
        }
    }
}
