plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}