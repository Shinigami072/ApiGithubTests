import org.gradle.api.tasks.testing.logging.TestExceptionFormat

rootProject.name = "ApiGithubTests"

pluginManagement {
//    val kotlinVersion: String by settings
    val kotlinVersion = settings.extra.properties.getValue("kotlin.version").toString()

    repositories {
        mavenCentral()
        gradlePluginPortal()
        mavenLocal()
    }

    plugins {
        kotlin("jvm") version kotlinVersion
        kotlin("multiplatform") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion
        kotlin("plugin.allopen") version kotlinVersion
    }
}

include(
    "app"
)

gradle.projectsLoaded {
    allprojects {
        group = "com.github.shinigami"
        version = "1.0-SNAPSHOT"

        repositories {
            mavenCentral()
            maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
        }


        tasks.withType<Test> {
            environment["ENVIRONMENT"] = "test"
            testLogging {
                events("passed","skipped","failed")
                exceptionFormat = TestExceptionFormat.FULL
                showStandardStreams = logger.isDebugEnabled
            }
        }
    }

}