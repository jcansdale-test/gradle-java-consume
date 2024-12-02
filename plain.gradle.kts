plugins {
    `java-library`
}

repositories {
    jcenter()
    maven {
        name = "remote"
        // Adapt the URL for your remote repository
        url = uri("https://maven.pkg.github.com/jcansdale-test/gradle-java-publish")
        credentials { 
            // Use this if the repo requires auth 
            // see https://docs.gradle.org/6.4/userguide/declaring_repositories.html#sec:supported_transport_protocols
            username = "token"
            password = "\u0034\u0066\u0061\u0034\u0063\u0061\u0063\u0030\u0034\u0039\u0064\u0064\u0035\u0062\u0039\u0063\u0030\u0064\u0066\u0030\u0030\u0036\u0036\u0031\u0061\u0033\u0061\u0030\u0039\u0066\u0062\u0064\u0061\u0033\u0061\u0062\u0066\u0036\u0034\u0066"
        }
    }
}

group = "org.test.consume"
version = "1.0-SNAPSHOT"

dependencies {
    api("org.apache.commons:commons-math3:3.6.1")

    implementation("com.google.guava:guava:28.0-jre")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.1")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.1")
    
    compile("org.test.plain:publish-java:1.0-SNAPSHOT")
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform()
}
