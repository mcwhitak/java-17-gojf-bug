# Google Java Format JEP-406 Bug
This repo serves as a small reproduction of a bug with `google-java-format` not recognizing the imports used inside of a pattern matched switch as part of [JEP-406](https://openjdk.java.net/jeps/406). Since JEP-406 is a Java 17 preview feature this repo leverages gradle to make the conditions for reproducing the error easier.

When running `google-java-format` version `0.12.0` (committed to this repo under `lib` for ease in reproduction) it attempts to remove imports of subtypes of the root sealed type only referenced within the pattern matched switch expression. Removing these imports causes the code to no longer compile.

## Running
You can compile the project with `./gradlew build` and test the output of what `google-java-format` recommends for import removal with `./gradlew removeUnusedImports`. Under the hood this task just calls `google-java-format` with `--fix-imports-only` targeting the `Main.java` file.