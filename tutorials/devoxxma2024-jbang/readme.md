# Jbang @ DeovvMa 2024

## Easy Setup

- Windows via scoop: `scoop install jbang`
- Linux and macOS via SDKMAN: `sdk install jbang`
- Other [setup methods](https://www.jbang.dev/download/)

## Getting started

- Create a script: `jbang init helloworld.java`
- Make the script executable on macOS and Linux: `chmod +x helloworld.java`
- Run: `./helloworld.java` or on Windows `jbang helloworld.java`
  - Native Image: `jbang --native helloworld.java`
- Export
  - jar `jbang export portable helloworld.java`
  - fatjar (all deps) `jbang export fatjar helloworld.java`
  - jlink (minimized JDK) `jbang export jlink helloworld.java`
  - Native imgae (GraalVM required): `jbang export native helloworld.java`
  - mavenrepo: `jbang export mavenrepo helloworld.java`

## Features

- Basic JDK management `jbang jdk list`, `jbang jdk install 23`, `jbang jdk use 23`
- Dependencies
  - `//DEPS com.github.lalyos:jfiglet:0.0.8` (Gradle style).
  - Many [other possibilities](https://www.jbang.dev/documentation/guide/latest/dependencies.html) (fatjar, GitHub,
      `@Grab`)
- JShell support (.jsh or .jshell extension)
  - Inline scripts `jbang -c 'System.out.println("Inline Java ☕ yay!")'`
- Run Java and JShell codeblocks in markdown `jband my_markdown.md`

## Templates

- List templates: `jbang template list`
- picocli script: `jbang init -t cli hellocli.java`
- Quarkus single file API: `jbang init -t qrest helloqrest.java`
    - Add json parsing: `//DEPS io.quarkus:quarkus-resteasy-jsonb`
    - Add imports `import javax.ws.rs.GET; import javax.ws.rs.Path; import javax.ws.rs.Produces; import javax.ws.rs.core.MediaType;`
    - Add implementation
    ```java
    @Path("/palindrome")
    @ApplicationScoped
    public class palqrest {
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public Map<String, String> isPalidrome(@QueryParam("input") String input) {
            return Map.of("result",
                    PalindromeService.isPalindrome(input) ? "Palindrome" : "Not Palindrome");
        }
    }
    ```
- Test the service: `jbang init -t junit@jbangdev file_to_test.java`

## Catalog

- Create catalog: `jbang init -t jbang-catalog catalog`
- Copy `jb-catalog.json` to the root folder of your repository.
- Copy the `.github` folder to the root folder of your repository.

> 💡 Jbang supports external sources and files with `//SOURCES` and `//FILES` directives

## App Store

- [HanSolo/jbang-catalog](https://github.com/HanSolo/jbang-catalog/blob/390effcbf265f240bfdc229b75b57617193da067/jbang-catalog.json)
  does not work when I tested
- Cowsay
  - `jbang cowsay@ricksbrown/cowsay MOO!`
  - `jbang cowsay@ricksbrown/cowsay --cowthink Moo`
  - `jbang cowsay@ricksbrown/cowsay -f dragon 🔥`
  - `jbang cowsay@ricksbrown/cowsay -f vader-koala "I am your father"`

## Other features

- Generate script with OpenAI (experimental) and requires OpenAI API key
  - `jbang --preview --verbose init ImageProcessor.java "Write a Java program that counts the number of people in an image with OpenCV`
  - If you use other providers,`mods` can be used instead : ``

## Other languages

- Kotlin support `jbang init -t hello.kt filename.kt`
  - More features compared to Kotlin script `kts` (deps, etc.)
- Groovy support `jbang init -t hello.groovy filename.groovy`
  - Set Groovy version `//GROOVY 3.0.19`

## Additional info

- [JBang](https://www.jbang.dev/documentation/guide/latest/faq.html) name comes from the Java Shebang feature
- [JBang](https://www.jbang.dev/documentation/guide/latest/faq.html) came from the idea of porting kscript to Java

## Credits and resources

- [jbang](https://jbang.dev)
- [jfiglet](https://github.com/lalyos/jfiglet)
- [fusesource/jansi](https://github.com/fusesource/jansi)
- [Java 23 Implicitly Declared Classes and Instance Main Methods](https://docs.oracle.com/en/java/javase/23/language/implicitly-declared-classes-and-instance-main-methods.html)
