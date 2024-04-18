# Tour du langage Java

Nous allons faire un tour du langage Java sans forcément tout couvrir car il est très riche en fonctionnalités.

!!! warning

    Comme le langage Java évolue apporte fréquemment des amélioration et simplifications, il se peut que les exemples de code vues ici soient différents de ce que vous trouvez dans la littérature.

## Premiers pas

```java
--8<--
tour/hello.java
--8<--
```

## Classes, héritage et interfaces

```java
--8<--
tour/ClasseInterface.java
--8<--
```

## Types génériques

```java
--8<--
tour/GenericsDemo.java
--8<--
```

## Collections

```java
--8<--
tour/CollectionDemo.java
--8<--
```

## Streams

```java
--8<--
tour/StreamDemo.java
--8<--
```

## Interfaces fonctionnelles

```java
--8<--
tour/FunctionalInterfaceDemo.java
--8<--
```

Equivalent en Kotlin:

```kt
--8<--
tour/FirstClassFunctions.kt
--8<--
```

Liste des [interfaces fonctionnelles prédéfinies](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html) qui sont séparées en [4 catégories](https://www.ggorantala.dev/what-are-java-built-in-functional-interfaces/):

- **Consumer** : Fonction qui prend des arguments génériques et ne renvoie rien (type de retour void)
- **Supplier** : Fonction qui ne prend aucun argument et renvoie un valeur dont le type est générique
- **Function** : Fonction qui peut prendre des arguments génériques et retourne une valeur générique.
- **Predicate** : Fonction qui peut prendre des arguments génériques et retour un booléen. Un predicate peut être considéré comme un cas particulier d'une **Function** dont le type de retour est un booléen.

La convention est de rajouter le terme bi pour les fonctions avec deux arguments (comme `BiPredicate`). Voici des exemples de définition de quelques interfaces fonctionnelles:

```java
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}

@FunctionalInterface
public interface Supplier<T> {
    T get();
}

package java.util.function;
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}

@FunctionalInterface
public interface BiFunction<T, U, R> {
    R apply(T t, U u);
}

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
```
