# Jbang @ DeoxxMa 2024

![jbang logo](./assets/jbang-logo.png)

Author: Yassine Benabbas - DevRel @ Worldline, Teacher and member of the LAUG

## Easy Setup

- [Setup methods](https://www.jbang.dev/download/)
    - Windows via scoop: `scoop install jbang`
    - Linux and macOS via SDKMAN: `sdk install jbang`
- [VSCode IDE extension](https://marketplace.visualstudio.com/items?itemName=jbangdev.jbang-vscode)
    - [Other IDEs](https://www.jbang.dev/documentation/guide/latest/editing.html#ide-support)

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
  - Other [types of DEPS](https://www.jbang.dev/documentation/guide/latest/dependencies.html)
- [Example](./basic/DependenciesDemo.java)

## Templates

- List templates: `jbang template list`
- picocli script: `jbang init -t cli hellocli.java`
- Quarkus single file REST API: `jbang init -t qrest helloqrest.java`
- Generate test file: `jbang init -t junit@jbangdev file_to_test.java`
- Example: [cli](./paltools/palcli.java), [service](./paltools/PalindromeService.java), [api](./paltools/palqrest.java), [test](./paltools/PalindromeServiceTest.java)

> 💡 Jbang supports external sources and files with `//SOURCES` and `//FILES` directives

## Catalog

- Create `jb-catalog.json` to the root folder of your repository
  - [Example](https://github.com/yostane/cours-java/blob/main/jbang-catalog.json)
- Run scripts from the catalog `jbang script@ghuser/repo`: 
    - `jbang palcli@yostane/cours-java madam`
    - `jbang palqrest@yostane/cours-java`
    - `jbang hellojfx@yostane/cours-java`

## App Store

- [App Store](https://www.jbang.dev/appstore/)
- Cowsay
  - `jbang cowsay@ricksbrown/cowsay MOO!`
  - `jbang cowsay@ricksbrown/cowsay -f dragon "I'm Veldora Tempest!"`

## JavaFX (openjfx)

- UI Toolkit [openjfx.io](https://openjfx.io/)
- [Basic window](./javafx/hellojfx.java)
- [More beautiful example](https://gist.github.com/FDelporte/c69a02c57acc892b4c996a9779d4f830) `jbang https://gist.github.com/FDelporte/c69a02c57acc892b4c996a9779d4f830`

## Other languages

- Kotlin support `jbang init -t hello.kt filename.kt`
  - More features compared to Kotlin script `kts` (deps, etc.)
  - [Example](./other_formats/hellokotlin02.kt)
- Groovy support `jbang init -t hello.groovy filename.groovy`
  - [Example](./other_formats/hello.groovy)
- JShell support (.jsh or .jshell extension) and inline scripts `jbang -c 'System.out.println("Inline Java ☕ yay!")'`
    - [Example](./other_formats/jshdemo.jsh)
- Run Java and JShell codeblocks in markdown `jband my_markdown.md`
    - [Example](./other_formats/md_with_code.md)

## Other and experimental features

- [File configuration](https://www.jbang.dev/documentation/guide/latest/config.html)
- [Caching](https://www.jbang.dev/documentation/guide/latest/caching.html)
- [JBang wrapper](https://www.jbang.dev/documentation/guide/latest/cli/jbang-wrapper.html)
- 🧪 Generate script with OpenAI (experimental) and requires OpenAI API key
  - `jbang --preview --verbose init ImageProcessor.java "Write a Java program that counts the number of people in an image with OpenCV`
  - If you use other providers,[mods](https://github.com/charmbracelet/mods) can be used instead

## Additional info

- [JBang](https://www.jbang.dev/documentation/guide/latest/faq.html) name comes from the Java Shebang feature
- [JBang](https://www.jbang.dev/documentation/guide/latest/faq.html) came from the idea of porting kscript to Java

## Conclusion (as of Devoxx MA 2024)

- Very powerful tool for scripting and single-file projects on the Java ecosystem
- Still young but very promising and can be used for many use cases
- Templating, AppStore and Catalogs add a layer of sharing and contribution
- Java can also Do single file APIs, CLIs, and more 🎉 

## Content

- Short link: [wrl.li/jbang-devoxxma24](https://wrl.li/jbang-devoxxma24)

![qrcode](./assets/qrcode.png)

## Credits and resources

- [jbang](https://jbang.dev)
- [jfiglet](https://github.com/lalyos/jfiglet)
- [fusesource/jansi](https://github.com/fusesource/jansi)
- [Java 23 Implicitly Declared Classes and Instance Main Methods](https://docs.oracle.com/en/java/javase/23/language/implicitly-declared-classes-and-instance-main-methods.html)
- [baeldung.com/jbang](https://www.baeldung.com/jbang-guide)
- [JBang OpenAI example](https://www.infoq.com/news/2023/06/jbang-107/)