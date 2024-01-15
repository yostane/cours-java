# Boost your Java productivity on the command-line: Installing and creating projects

Java Developers are blessed with many tools and libraries that make their DX easier and more fun.

As a terminal lover myself, let me share with you some CLI tools that'll make java development a breeze.
We'll focus on installing the JDK and some tools as well bootstraping projects.
You can even complentent your existing tooling with the ones that we'll see here.

## JDK version management

With Java releasing a new version each 6 months and with all the available JDK distributions, having a proper JDK version management is a must.
Thus, I strongly discourage to install a JDK using an installer but rather use a an intermediary tools that will allow to list all available JDKs and install the ones that we want.
I recommend these two tools depending on your OS.

- On Windows: [scoop](https://scoop.sh/) with the setup inscrution in its [Java wiki](https://github.com/ScoopInstaller/Scoop/wiki/Java)
- On Linux and macOS: [SDKMAN!](https://sdkman.io/)

In addition to listing and installing JDKs with different version and providers, these tools can change the current active JDK in a single command (by updating JAVA_HOME and PATH environment variables).
In the same vein, we can install in a single command other Java related tools such as maven, gradle, Kotlin, etc.

For example, to list the available JDKs using scoop, we run `scoop search jdk` to get an output similar the following one:

```sh
...
temurin17-nightly-jdk     17.0.10-6.0.202312241232  java
temurin18-jdk             18.0.2-101                java
temurin18-nightly-jdk     18.0.2-101.0.202210032342 java
temurin19-jdk             19.0.2-7                  java
temurin19-nightly-jdk     19.0.2-7.0.202302250348   java
temurin20-jdk             20.0.2-9                  java
temurin21-jdk             21.0.1-12.1               java
temurin8-jdk              8.0.392-8                 java
temurin8-nightly-jdk      8.0.402-5.0.202312251854  java
zulu-jdk                  21.30.15                  java
zulu10-jdk                10.3.5                    java
zulu11-jdk                11.68.17                  java
zulu12-jdk                12.3.11                   java
zulu13-jdk                13.54.17                  java
zulu14-jdk                14.29.23                  java
...
```

Regarding which JDK to install, there are plenty of choices.
The general and logical recommendation for me is to use the latest LTS release and a distribution which provides the best balance of features (license, community, performance, security updates, etc.).
In this regard, I sometimes use Zulu JDK or Temurin JDK.
This seems to be in-line with
[whichjdk.com](https://whichjdk.com/) which recommends to use [Adoptium Eclipse Temurin 21](https://whichjdk.com/#adoptium-eclipse-temurin) (which superseeds adoptopenjdk) at the time of writing where Java 21 is the current LTS.

So let's install Temurin with scoop `scoop install temurin21-jdk` or with SDKMAN! `sdk install java 21.0.1-tem`.

## Projects managers

In this section, I recommend two tools to create and manage Java projects from the command line.

### JBang

[JBang](https://www.jbang.dev/) is one of the simplest and easiet ones to get started with Java.
It allows to create self-contained source-only projects.
It also provides [an AppStore](https://www.jbang.dev/appstore/) feature which allows to run java projects shared by the community very easily.
⚠ Of course, every script must be verified before runnning it on your machine.

To summarize, JBang is particularly adapted for education, for small projects or try available java tools throug its AppStore (as long as we make sure they are safe beforehand).

JBang can be installed on Windows with [scoop](https://scoop.sh/): `scoop install jbang`, or on macOS and Linux with [SDKMAN](https://sdkman.io/) `sdk install jbang`.

After that, we can create a basic project with `jbang init hello.java`. We can run it with `jbang run hello.java` (On Linux and macOS, we first need to run `chmod +x hello.java`)

JBang provides many other templates that we can list with `jbang template list`.
Here is the output of this command at the the time of writing this post.

```sh
agent = Agent template
cli = CLI template
githubbot@quarkusio = Example of making a github app
gpt = Template using ChatGPT (requires --preview and OPENAI_API_KEY)
gpt.groovy = Template using ChatGPT for groovy (requires --preview and OPENAI_API_KEY)
gpt.kt = Template using ChatGPT for kotlin (requires --preview and OPENAI_API_KEY)
hello = Basic Hello World template
hello.groovy = Basic groovy Hello World template
hello.kt = Basic kotlin Hello World template
qcli = Quarkus CLI template
qmetrics = Quarkus Metrics template
qrest = Quarkus REST template
readme.md = Basic markdown readme template
```

The `cli` template create a starter project with `picocli` which is a great library for creating console apps that rely on command-line arguments.

I personally used JBang to create Java proects to solve some advent of codoe challenges and I it was really useful for this use case.

JBang also allows to create AI powered projects.

### Gradle

Gradle is project mamangement tools used by Android developers and by Java developers as an alternative to maven.
Even though it is used by Kotlin or Java devs, gradle is language agnostic.

In addition to this, gradle provides a `gradle init` command which allows to bootstrap a blank or a hello world project. Let's create a Java proect:

```sh
➜ gradle init

Select type of project to generate:
  1: basic
  2: application
  3: library
  4: Gradle plugin
Enter selection (default: basic) [1..4] 2 # Choose 2 for a 'Hello world' project

Select implementation language:
  1: C++
  2: Groovy
  3: Java
  4: Kotlin
  5: Scala
  6: Swift
Enter selection (default: Java) [1..6] 3 # Choose 3 for Java

Generate multiple subprojects for application? (default: no) [yes, no]

Select build script DSL:
  1: Kotlin
  2: Groovy
Enter selection (default: Kotlin) [1..2] # Leave default to use Kotlin script for the build file

Select test framework:
  1: JUnit 4
  2: TestNG
  3: Spock
  4: JUnit Jupiter
Enter selection (default: JUnit Jupiter) [1..4] # Leave default to use JUnit Jupiter

Project name (default: gradle-java): # Leave default to use the folder name as the project name

Source package (default: gradle.java): # Leave default to use the suggested package name

Enter target version of Java (min. 7) (default: 17): # Leave default to use your current Java version

Generate build using new APIs and behavior (some features may change in the next minor release)? (default: no) [yes, no]


> Task :init
To learn more about Gradle by exploring our Samples at https://docs.gradle.org/8.5/samples/sample_building_java_applications.html

BUILD SUCCESSFUL in 31s
2 actionable tasks: 2 executed
```

The direcrtory structure is simialr to what we we find is typical gradle and maven projects.

```sh
│   .gitattributes
│   .gitignore
│   gradlew
│   gradlew.bat
│   settings.gradle.kts
│
├───app
│   │   build.gradle.kts
│   │
│   └───src
│       ├───main
│       │   ├───java
│       │   │   └───gradle
│       │   │       └───java
│       │   │               App.java
│       │   │
│       │   └───resources
│       └───test
│           ├───java
│           │   └───gradle
│           │       └───java
│           │               AppTest.java
│           │
│           └───resources
└───gradle
    │   libs.versions.toml
    │
    └───wrapper
            gradle-wrapper.jar
            gradle-wrapper.properties
```

We note that even a test case is provided out of the box.
Once the project is created, we can run it using `gradle run` and launch the tests using `gradle test`.

### Maven arcehtype:generate

It allows to generate various types of Java projects from a template as long as we provide the correct project template name.
Templates can be listed with the command `mvn archetype:generate` or by looking for them on the internet.
Calling `mvn archetype:generate` listed more than **3000** projects, which can be a bit overwhelming for starters.
We can also create a project from a single command by specifying it `archetypeGroupId`, `archetypeArtifactId` and `archetypeVersion`.
For example, to create a simple Java project, we run this command that we find in the official [maven website](https://maven.apache.org/archetypes/maven-archetype-quickstart/):

```sh
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4
# in powershell, prefix the - with a `
mvn archetype:generate `-DarchetypeGroupId=org.apache.maven.archetypes `-DarchetypeArtifactId=maven-archetype-quickstart `-DarchetypeVersion=1.4
```

When we open the created project, we find that it's using Java 7 while the current LTS version of Java at the time of writing is Java 21.

```xml
<properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.7</maven.compiler.source>
    <maven.compiler.target>1.7</maven.compiler.target>
</properties>
```  

I have also encountered this issue with other archetypes but it is surprising that the one provided by the official website is so much outdated.

### JBang vs Gradle vs maven

As you may have guessed by reading the previous section, my least favorite way of creating a Java project in the command line is maven's `archetype:generate` for these reasons:

- Long commands
- We need to look for them in the internet or in a long list of templates
- We may find outdated templated, even from the official website

Maven being out of the way, let's continue comparing `gradle init` and JBang.
They both support languagues other than Java, namely Groovy and Kotlin, but JBnag's support is still experimenal and `gradle init` supports more languages (such as C++ and swift).
JBang is adapted for small Java projects or when it provides an exclusive template.
For example, and as far as I know, only JBang provides a `picocli` starter.

For larger projects that want to start from scratch and follow a state of the art structure `gradle init` is a better choice.

For large or complex projects using a server side framework, it is better to create a proiect:

- Spring boot: [spring initializr](https://start.spring.io/) or [Spring Boot CLI](https://docs.spring.io/spring-boot/docs/current/reference/html/cli.html)
- Quarkus: [code.quarkus.io](https://code.quarkus.io/) or [Quarkus cli](https://quarkus.io/guides/cli-tooling)
- JEE: Here is a selection of starters. [Open Liberty starter](https://openliberty.io/start/), [Eclipse starter for Jakarta EE](https://start.jakarta.ee/), [Wildlfy quickstart projects on GitHub](https://github.com/wildfly/quickstart)

Compared to JBang, `gradle init` is more complex but inline with usual Java projects.
For

### Spring Boot CLI and Quarkus CLI

[Spring Boot CLI](https://docs.spring.io/spring-boot/docs/current/reference/html/cli.html) allows to generate a new Spring boot project and to encode passwords (for use with Spring Security).
The project generation feature is the CLI couterpart of [start.spring.io](https://start.spring.io/).
Below are some examples uses of the Spring Boot CLI:

```sh
# Generate a zip file that contains Kotlin project that uses Gradle Kotlin build file and inclids the web-services and postgresql dependencies
spring init --build gradle -l kotlin -t gradle-project-kotlin -d web-services,postgresql
# Generate a Java 21 project that uses maven and includes the web-services and postgresql dependencies
spring init -x --build maven -j 21 -a sb-cli-demo -g org.sb.test -d web-services,postgresql --description "project created with Spring Boot CLI"
# List all possible options to initialize a project
spring help init
```



## Project scaffolders

We have seen earlier that JBang, Gradle and Maven are able to generate projects from scratch.
Scaffolding goes a bit further by also generating other layers of the app (database, front-end, etc.).

### Yeoman

Yeoman is a general purpose project scaffolder which is framework and language agnostic.
Even though the tool itself relies on npm, it can generate any type of project as long as the corresponding project generator is available and is installed.
A project generator defines how to scaffold a set of projects.
For example, we can find a verity of generators in the [discover page](https://yeoman.io/generators/): VSCode extensions, Office extensions, webaaps, or even servers.

Anyone can create a [project generator](https://yeoman.io/authoring/) and publish it to npm so that it is available in the [yeoman search engine](https://yeoman.io/generators/).

Once yeoman is installed with `npm i -g yo`, we can install a project generator.
Let's install [generator-jvm](https://github.com/daggerok/generator-jvm) with a `npm install -g generator-jvm` to get access to some JVM project generators.

`yo jvm`

For Java developers, there is a more tailored scaffolder based on Yeoman which is called JHispter.

### JHipster and JHipsterLite

### Advantages and drawbacks

Project scaffolders allow to get a project running really fast.
A lot of boilerplate code is already written for us.
Thus the gain in terms of effort and time is considerable.

However, the generated code may not coincide with the developer's way of coding.
Also, some choices are very opinionated, such as the exclusive use of Spring on JHipster.
There's also the issue of vendor-locking where we must update our project using tools provided by the scaffolder if we don't want to take the risk of breaking the dependencies.
In addition to that, since we are dealing with a community project, we face the usual issues of trust and updates.
For example, when I installed Yeoman (on January 2024), npm detected 7 high vulnerabilities.

```sh
➜ npm install -g yo

added 801 packages, and audited 802 packages in 1m

122 packages are looking for funding
  run `npm fund` for details

13 vulnerabilities (6 moderate, 7 high)
```

So, in my opinion, scaffolders are quite relevant for short-term projects such as PoCs or when we have tight deadlines.
For long term projects, I would avoid to use a scaffolder so that I keep more control over my code.
Instead, I'd rather use official tools to generate the projects.
For exmaple, for a Quarkus + Vue proejct, I'll use [Quarkus CLI](https://quarkus.io/guides/getting-started) or [code.quarkus.io](https://code.quarkus.io/) to create the Quarkus project and [vue create]() to create the Vue project.
Of course, this is my current personal opinion which may change in the future.

## Conclusion

## Links

- [Which Java JDK Should You Use?](https://incusdata.com/blog/which-java-jdk-should-you-use)
