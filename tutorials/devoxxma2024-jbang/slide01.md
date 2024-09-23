# Jbang @ DeovvMa 2024

## My recommended Setup

- Windows via scoop: `scoop install jbang`
- Linux and macOS via SDKMAN: `sdk install jbang`

## Getting started

- Create a script: `jbang init helloworld.java`
- macOS and Linux: make the script executable `chmod +x helloworld.java`
- Run: `./helloworld.java` or on Windows `jbang helloworld.java`
    - Native Image: `jbang --native helloworld.java`
- Export
    - jar `jbang export portable helloworld.java`
    - fatjar `jbang export fatjar helloworld.java`
    - Native imgae (GraalVM required): `jbang export native helloworld.java`

## Features

- Dependencies
    - `//DEPS com.github.lalyos:jfiglet:0.0.8` (Gradle style).
    - Many [other possibilities](https://www.jbang.dev/documentation/guide/latest/dependencies.html) (fatjar, GitHub,
      `@Grab`)
- Kotlin support `jbang init -t hello.kt filename.kt`
    - More features compared to Kotlin script `kts` (deps, etc.)
- Groovy support `jbang init -t hello.groovy filename.groovy`
    - Set Groovy version `//GROOVY 3.0.19`
- Run Java and JShell codeblocks in markdown `jband my_markdown.md`
- Can manage JDKs

## App Store

- [HanSolo/jbang-catalog](https://github.com/HanSolo/jbang-catalog/blob/390effcbf265f240bfdc229b75b57617193da067/jbang-catalog.json)
  does not work when I tested
- Cowsay
    - `jbang cowsay@ricksbrown/cowsay MOO!`
    - `jbang cowsay@ricksbrown/cowsay --cowthink Moo`
    - `jbang cowsay@ricksbrown/cowsay -f dragon 🔥`
    - `jbang cowsay@ricksbrown/cowsay -f vader-koala "I am your father"`

## Additional info

- [JBang](https://www.jbang.dev/documentation/guide/latest/faq.html) name comes from the Java Shebang feature
- [JBang](https://www.jbang.dev/documentation/guide/latest/faq.html) came from the idea of porting kscript to Java

## Credits and resources

- [jbang](https://jbang.dev)
- [figlet]()
- [fusesource/jansi](https://github.com/fusesource/jansi)
- [Java 23 Implicitly Declared Classes and Instance Main Methods](https://docs.oracle.com/en/java/javase/23/language/implicitly-declared-classes-and-instance-main-methods.html)