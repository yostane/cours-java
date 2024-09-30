# Jbang @ DeovvMa 2024

Author: Yassine Benabbas

- Short link: [wrl.li/jbang-devoxxma24](https://wrl.li/jbang-devoxxma24)

![qrcode](./qrcode.png)

## Easy Setup

- Windows via scoop: `scoop install jbang`
- Linux and macOS via SDKMAN: `sdk install jbang`
- Other [setup methods](https://www.jbang.dev/download/)

## Getting started

- Create a script 📜: `jbang init helloworld.java`
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
- Quarkus single file REST API: `jbang init -t qrest helloqrest.java`
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
- Run in dev mode `jbang --fresh -Dquarkus.dev helloqrest.java`, or in pwsh ```jbang --fresh `-Dquarkus.dev helloqrest.java``` (💡 use `--fresh` when switching from dev and prod mode)
- Test the service: `jbang init -t junit@jbangdev file_to_test.java`

> 💡 Jbang supports external sources and files with `//SOURCES` and `//FILES` directives

## Catalog

- Create 📚 catalog: `jbang init -t jbang-catalog catalog`
- Copy the `.github` folder to the root folder of your repository
- Copy `jb-catalog.json` to the root folder of your repository
    ```json
    {
        "catalogs": {},
        "aliases": {
        "palcli": {
            "script-ref": "tutorials/devoxxma2024-jbang/paltools/palcli.java",
            "description": "Palindrome tester CLI"
        },
        "palqrest": {
            "script-ref": "tutorials/devoxxma2024-jbang/paltools/palqrest.java",
            "description": "Palindrome tester Quarkus Rest API"
        }
        }
    }
    ```
- Test the catalog: `jbang palcli@yostane/cours-java madam` and `jbang palqrest@yostane/cours-java`

## App Store

- [HanSolo/jbang-catalog](https://github.com/HanSolo/jbang-catalog/blob/390effcbf265f240bfdc229b75b57617193da067/jbang-catalog.json) (some scripts did not work)
  - `jbang discocli@HanSolo/jbang-catalog`
- Cowsay
  - `jbang cowsay@ricksbrown/cowsay MOO!`
  - `jbang cowsay@ricksbrown/cowsay --cowthink Moo`
  - `jbang cowsay@ricksbrown/cowsay -f dragon 🔥`
  - `jbang cowsay@ricksbrown/cowsay -f vader-koala "I am your father"`

## JavaFX (openjfx)

- UI Toolkit [openjfx.io](https://openjfx.io/)
- 
- [More beautiful example](https://gist.github.com/FDelporte/c69a02c57acc892b4c996a9779d4f830) `jbang https://gist.github.com/FDelporte/c69a02c57acc892b4c996a9779d4f830`


## Other and experimental features

- [File configuration](https://www.jbang.dev/documentation/guide/latest/config.html)
- [Caching](https://www.jbang.dev/documentation/guide/latest/caching.html)
- [JBang wrapper](https://www.jbang.dev/documentation/guide/latest/cli/jbang-wrapper.html)
- 🧪 Generate script with OpenAI (experimental) and requires OpenAI API key
  - `jbang --preview --verbose init ImageProcessor.java "Write a Java program that counts the number of people in an image with OpenCV`
  - If you use other providers,[mods](https://github.com/charmbracelet/mods) can be used instead

## Other languages

- Kotlin support `jbang init -t hello.kt filename.kt`
  - More features compared to Kotlin script `kts` (deps, etc.)
- Groovy support `jbang init -t hello.groovy filename.groovy`
  - Set Groovy version `//GROOVY 3.0.19`

## Additional info

- [JBang](https://www.jbang.dev/documentation/guide/latest/faq.html) name comes from the Java Shebang feature
- [JBang](https://www.jbang.dev/documentation/guide/latest/faq.html) came from the idea of porting kscript to Java

## Conclusion (as of Devoxx MA 2024)

- Very powerful tool for scripting and single-file projects on the Java ecosystem
- Still young but very promising and can be used for many use cases
- Templating, AppStore and Catalogs add a layer of sharing and contribution
- Java can also Do single file APIs, CLIs, and more 🎉 

## Credits and resources

- [jbang](https://jbang.dev)
- [jfiglet](https://github.com/lalyos/jfiglet)
- [fusesource/jansi](https://github.com/fusesource/jansi)
- [Java 23 Implicitly Declared Classes and Instance Main Methods](https://docs.oracle.com/en/java/javase/23/language/implicitly-declared-classes-and-instance-main-methods.html)
- [baeldung.com/jbang](https://www.baeldung.com/jbang-guide)
- [JBang OpenAI example](https://www.infoq.com/news/2023/06/jbang-107/)