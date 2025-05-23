import com.android.build.gradle.BaseExtension
import com.android.build.gradle.BasePlugin
import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

buildscript {
    dependencies {
        classpath(libs.aboutLibraries.gradle)
        classpath(libs.sqldelight.gradle)
        classpath(libs.moko.gradle)
        classpath(sylibs.versionsx)
    }
}

plugins {
    alias(kotlinx.plugins.serialization) apply false
    id("com.github.ben-manes.versions") version "0.41.0"
    id("nl.littlerobots.version-catalog-update") version "0.8.4"
}

versionCatalogUpdate {
    sortByKey.set(true)
    versionCatalogs {
        create("AndroidxCatalog") {
            catalogFile.set(file("gradle/androidx.versions.toml"))
        }
        create("ComposeCatalog") {
            catalogFile.set(file("gradle/compose.versions.toml"))
        }
        create("KotlinxCatalog") {
            catalogFile.set(file("gradle/kotlinx.versions.toml"))
        }
        create("SYCatalog") {
            catalogFile.set(file("gradle/sy.versions.toml"))
        }
    }
}

tasks.withType<DependencyUpdatesTask> {
  rejectVersionIf {
    isNonStable(candidate.version)
  }
}

subprojects {
    tasks.withType<KotlinJvmCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_17.toString()
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
        testLogging {
            events(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
        }
    }

    plugins.withType<BasePlugin> {
        plugins.apply("detekt")

        configure<BaseExtension> {
            compileSdkVersion(AndroidConfig.compileSdk)
            defaultConfig {
                minSdk = AndroidConfig.minSdk
                targetSdk = AndroidConfig.targetSdk
                ndk {
                    version = AndroidConfig.ndk
                }
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
                isCoreLibraryDesugaringEnabled = true
            }

            dependencies {
                add("coreLibraryDesugaring", libs.desugar)
            }
        }
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.uppercase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}
