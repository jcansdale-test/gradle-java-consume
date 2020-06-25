## Gradle consuming sample

This is a simple project for consuming a package from GitHub Packages.

Added a `maven` configuration with a unique `name`.

```
repositories {
    jcenter()
    maven {
        name = "remote"
        // Adapt the URL for your remote repository
        url = uri("https://maven.pkg.github.com/jcansdale-test/gradle-java-publish")
        credentials { 
            // Use this if the repo requires auth 
            // see https://docs.gradle.org/6.4/userguide/declaring_repositories.html#sec:supported_transport_protocols
            username = System.getenv("USERNAME")
            password = System.getenv("TOKEN")
        }
    }
}
```

Added a dependency.

```
dependencies {
    my-dependency("org.test.plain:publish-java:1.0-SNAPSHOT")
}
```
