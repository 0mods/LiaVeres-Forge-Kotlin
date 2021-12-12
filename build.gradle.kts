import net.minecraftforge.gradle.userdev.UserDevExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

repositories {
    mavenCentral()
}

buildscript {
    repositories {
        maven {
            url = uri("https://files.minecraftforge.net/maven")
        }
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
        mavenCentral()
    }
    dependencies {
        classpath("net.minecraftforge.gradle", "ForgeGradle", "5.1.+") {
            isChanging = true
        }
        classpath("org.jetbrains.kotlin", "kotlin-gradle-plugin", findProperty("kotlin_version").toString())
    }
}

apply {
    plugin("net.minecraftforge.gradle")
    plugin("idea")
    plugin("maven-publish")
    plugin("kotlin")
}

configurations["implementation"].extendsFrom(configurations.create("shade"))

version = "1.16.5-R2"
group = "com.algorithmlx"
project.setProperty("archivesBaseName", "LiaVeres")

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

configure<UserDevExtension> {
    mappings(findProperty("mapping_channel").toString(), findProperty("mc_version").toString())

    runs.create("client") {
        workingDirectory(project.file("run"))
        property("forge.logging.markers", "COREMOD,CORE,LOADING,CONFIG")
        property("forge.logging.console.level", "info")
        mods.create("liaveres") {
            source(the<JavaPluginExtension>().sourceSets.getByName("main"))
        }
    }

    runs.create("server") {
        workingDirectory(project.file("run"))
        property("forge.logging.markers", "COREMOD,CORE,LOADING,CONFIG")
        property("forge.logging.console.level", "info")
        mods.create("liaveres") {
            source(the<JavaPluginExtension>().sourceSets.getByName("main"))
        }
    }
}

dependencies {
    val implementation = configurations["implementation"]
    implementation("org.jetbrains.kotlin", "kotlin-stdlib-jdk8", findProperty("kotlin_version").toString())

    val shade = configurations["shade"]
    shade("org.jetbrains.kotlin", "kotlin-stdlib-jdk8", findProperty("kotlin_version").toString())

    val minecraft = configurations["minecraft"]
    minecraft("net.minecraftforge", "forge", findProperty("mc_version").toString() + "-"+ findProperty("forge_version").toString())
}

tasks.withType<Jar> {
    manifest {
        attributes(
            mapOf(
                "Specification-Title" to "LiaVeres",
                "Specification-Vendor" to "AlgorithmLX",
                "Specification-Version" to "1",
                "Implementation-Title" to project.name,
                "Implementation-Version" to version,
                "Implementation-Vendor" to "AlgorithmLX",
                "Implementation-Timestamp" to ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ"))
            )
        )
    }
    configurations.getByName("shade").onEach {
        from(project.zipTree(it)) {
            exclude("META-INF", "META-INF/**")
        }
    }
}