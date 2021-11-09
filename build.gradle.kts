plugins {
    scala
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

group = properties["pluginGroup"]!!
version = properties["pluginVersion"]!!

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    implementation("org.scala-lang:scala-library:2.13.7")
    compileOnly("io.paper:paper-api:1.17.1-R0.1-SNAPSHOT")
}

tasks {
    javadoc {
        options.encoding = "UTF-8"
    }

    compileScala {
        scalaCompileOptions.isOptimize = true
    }

    processResources {
        filesMatching("*.yml") {
            expand(project.properties)
        }
    }

    create<Jar>("sourceJar") {
        archiveClassifier.set("source")
        sourceSets["main"].allSource
    }

    shadowJar {
        archiveBaseName.set(project.name)
        archiveClassifier.set("")
        archiveVersion.set("")
    }
}
