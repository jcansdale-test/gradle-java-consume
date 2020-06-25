## Gradle consuming sample

This is a simple project for doing publication to a Maven repository.
The default setup only has a local repository.
A template for a remote repository with authentication is included.

The project is setup to publish its main jar, javadoc jar and source jar.

### Publishing

Simply run `./gradlew publish`.

If you want to be more selective, look at the available tasks with `./gradlew tasks`.
