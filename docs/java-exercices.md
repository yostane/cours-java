# Exercices

!!! warning "Consignes"

    - Ne pas de faire aider par des IA ou genAI

## Exercice 1

- Créer une fonction qui prend un tableau d’entiers “int[] numbers” et affiche la plus grande valeur et la plus petite valeur (Il faut calculer vous-même le max et le min)
- Générer un tableau de 10 entier aléatoires et afficher le max et le min
- Générer un tableau de 10 entiers saisis au clavier et afficher le max et le min

- Supposons qu'on ait deux cercles : un cercle de centre A et de rayon Ra, et un cercle de centre B et de rayon Rb. Les coordonnées de A sont notées (xa, ya) et les coordonnées de B sont notées (xb, yb). On souhaite écrire un algorithme (très simple) permettant de dire si les deux cercles se rentrent dedans. La distance entre les deux centres A et B est: `sqrt((xb-xa)² + (yb-ya)²)`
    - Donner la condition qui permet de savoir s’il y a collision (ou pas) entre les cercles
    - Exprimer cette condition sans racine carrée
    - Ecrire une fonction `isCollision` qui prend les informations de deux cercles en arguments et renvoie “true” s’il y a collision entre les deux cercles, sinon false.
    - Faire cet exercice en définissant une classe Circle et `isCollision` comme une méthode de cette classe

??? "Random min and max"

    ```java
    --8<--
    exo/RandomMinMax.java
    --8<--
    ```

??? "CircleCollisionDetector"

    ```java
    --8<--
    exo/CircleCollisionDetector.java
    --8<--
    ```

## Exercice 2

- On souhaite modéliser une collection de consoles et jeux rétro. Les consoles (classe `VideoGameConsole`) et les jeux rétro (classe `VideoGame`) sont des appareils de divertissement ayant les propriétés: `name`, `releaseYear` en commun. Les consoles ont en plus la propriété: `companyName` (la société qui l'a créé). Les jeux vidéos ont comme propriété supplémentaire l'éditeur du jeu (celui qui le distribue) ainsi que son développeur. On aimerait aussi savoir s'il est indépendant ou pas.
- Définir les classes nécessaires.
- Chaque jeu vidéo tient une liste des consoles compatibles (pour les jeux cross-platform) via la propriété: `platforms`.
- `VideoGameConsole` contient en plus la propriété: `companyName` de type string.
- Compléter la définition des classes et instancier les jeux et consoles suivantes:

    - Console: `name: My first 16 bit Console`, `releaseYear: 1987`, `companyName: SEGA`
    - Console: `name: Another 16 bit console`, `releaseYear: 1991`, `companyName: Nintendo`
    - Console: `name: Awesome 3D console`, `releaseYear: 1996`, `companyName: Sony`
    - Console: `name: 3D console with weird joystick`, `releaseYear: 1997`, `companyName: Nintendo`
    - Jeu: `name: Alex Kidd`, `releaseYear: 1988`, `editor: SEGA`
    - Jeu: `name: Sonic`, `releaseYear: 1990`, `editor: SEGA`
    - Jeu: `name: Mario RPG`, `releaseYear: 1996`, `editor: Nintendo`
    - Jeu: `name: Final Fantasy 6`, `releaseYear: 1994`, `editor: Square`

- En utilisant les streams:
    - Afficher les jeux sortis à partir de l'année 1990 triés par ordre croissant de l'année.
    - Afficher le nom des consoles de la compagnie SEGA.
    - Afficher le nom des consoles dont le nom contient le mot 16 bits.
    - Le nom du premier jeu sorti
    - Trouver le nombre de jeux de chaque éditeur en calculant dictionnaire dont la clé est l'éditeur ou son nom et en valeur le nombre de jeux
    - Pour chaque éditeur, l'année de sortie du premier jeu en calculant dictionnaire dont la clé est l'éditeur ou son nom et en valeur une année

??? "Corrigé"

    ```java
    --8<--
    exo/RetroCollectionExercise.java
    --8<--
    ```

## Exercice 3

Pour cet exercice, créer le projet avec `gradle init` et utiliser les annotations liées à la null safety.

- Créer une classe Java `IntCalculator` qui permet de faire des opérations arithmétiques sur des entiers à partir d'une chaîne de caractères au format `opérande1 opération opérande2` et retourne le résultat de cette opération.
    - les opérandes sont des entiers
    - Opétation est soit +, -, / ou \*
    - Vous pouvez utiliser split pour séparer les différentes parties
    - Utilise les streams au maximum (utiliser les boucles au minimum)
- Votre calculatrice mémorise toutes les opérations et leurs résultats.
- Ecrire un programme Java qui permet de soit saisir un opération soit afficher l'historique des opérations selon les commandes de l'utilisateur.
    - Si l'utilisateur saisit une opération du type `opérande1 opération opérande2`, afficher le résultat et l'ajouter à l'historique.
    - Si l'utilisateur saisit `h`, afficher l'historique des opérations.
    - Si l'utilisateur saisit `+`, `-`, , afficher l'historique des opérations pour cette opérande.
    - Si l'utilisateur saisit `exit`, le programme s'arrête.

- Astuces: utiliser `STR.""` pour formater vos Chaînes de caractères.

```sh title="exemple d'exécution"
#  '>' signifie que c'est une entrée de l'utilisateur. Ce n'est pas un symble à inclure dans votre saisie
> 2 + 5
7
> 100 - 2000
-1900
> h
2 + 5 = 7
100 - 2000 = -1900
> +
2 + 5 = 7
```

## Exercice 4

[Kotlin Heroes 2024, Problem A: 1-3-5](https://codeforces.com/contest/1958/problem/A).

In Berland, coins of worth 1, 3 and 5 burles are commonly used (burles are local currency).

Eva has to pay exactly 𝑛 burles in a shop. She has an infinite amount of coins of all three types. However, she doesn't like to pay using coins worth 1 burle — she thinks they are the most convenient to use.

Help Eva to calculate the minimum number of coins worth 1 burle she has to use, if she has to pay exactly 𝑛 burles. Note that she can spend any number of coins worth 3 and/or 5 burles.

- Input
    - The first line contains one integer 𝑡 (1≤𝑡≤100 ) — the number of test cases.
    - Each test case consists of one line, containing one integer 𝑛(1≤𝑛≤100).
- Output
    - For each test case, print one integer — the minimum number of 1-burle coins Eva has to use.

```sh title="input"
5
7
8
42
2
11
```

```sh title="output"
1
0
0
2
0
```

## Exercice 5

Pour cet exercice, créer le projet avec `gradle init` et utiliser les annotations liées à la null safety.
