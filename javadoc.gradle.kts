plugins {
    `java-library`
    `maven-publish`
}

repositories {
    jcenter()
}

group = "org.test.javadoc"
version = "1.0-SNAPSHOT"

java {
    withJavadocJar()
}

dependencies {
    api("org.apache.commons:commons-math3:3.6.1")

    implementation("com.google.guava:guava:28.0-jre")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.1")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.1")
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("main") {
            from(components["java"])
        }
    }

    repositories {
        maven {
            name = "local"
            url = uri("$buildDir/repo")
        }
        maven {
            name = "remote"
            // Adapt the URL for your remote repository
            url = uri("https://maven.pkg.github.com/" + System.getenv("GITHUB_REPOSITORY"))
            credentials { 
                // Use this if the repo requires auth 
                // see https://docs.gradle.org/6.4/userguide/declaring_repositories.html#sec:supported_transport_protocols
                username = System.getenv("USERNAME")
                password = System.getenv("TOKEN")
            }
        }
    }
}
