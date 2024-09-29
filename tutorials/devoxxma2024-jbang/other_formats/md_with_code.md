# jbang runs markdown

Jbang can execute code blocks.

```java
class Demo {
    void test() {
        System.out.println("I am a print in a markdown!");
    }
}
```

```jshelllanguage
new Demo().test();
```

```jsh
//DEPS com.github.lalyos:jfiglet:0.0.9
import com.github.lalyos.jfiglet.FigletFont;

System.out.println(FigletFont.convertOneLine(
			"Hello " + ((args.length>0)?args[0]:"jbang")));
```

```java
if(args.length==0){
    System.out.

println("You have no arguments!");
}else{
    System.out.

printf("You have %s arguments! First is %s",args.length, args[0]);
}
```

```kt
fun main() {
    print("We love Kotlin")
}
```

```kotlin
println("We love Kotlin")
```

```groovy
println("We love Kotlin")
```