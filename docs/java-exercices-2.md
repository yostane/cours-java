# Exercices série 2

!!! warning "Consignes"

    - Ne pas de faire aider par des IA ou genAI

## Exercice 1

- Créer un programme Java qui génère un tableau aléatoire de 10 entiers compris entre -10 et 10 et affiche (Il faut calculer vous-même les valeurs avec une boulce for) :
  - La plus grande valeur
  - La plus petite valeur
  - La moyenne
  - L'écart type dont la formule est : `racine carrée (somme((x - moyenne)²) / n)`
  - Le nombre de valeurs positives et le nombre de valeurs négatives
  - Le nombre de valeurs paires et le nombre de valeurs impaires

??? "Série 2 exo 1"

    ```java
    --8<--
    exo/serie-2/Serie2Ex1.java
    --8<--
    ```

## Exercice 2

Créer une programme Java qui met dans un tableau les 10 premiers nombres premiers posifitfs.

Rappel : un nombre premier est un nombre qui qui est divisible par exactement deux entiers disctints (qui sont 1 et le nombre-même). 0 et 1 ne sont pas des nombres premiers par définition (1 n'est pas divisible par deux nombres distincts).

??? "10 premiers nombres premiers"

    ```java
    --8<--
    exo/serie-2/First10Prime.java
    --8<--
    ```

## Exercice 3

Créer un fonctione Java qui calcule le schtroumph de deux tableaux qui ne sont pas forcément de la même taille ([source](https://laure.gonnord.org/pro/teaching/AlgoProg1011_IMA/quick1_2010_corr.pdf)). Pour calculer le schtroumpf, il faut multiplier chaque élément du premier tableau par chaque élément du deuxième, et additionner le tout. Par exemple si l'on a :

- Tableau 1 : 4 8 7 12
- Tableau 2 : 3 6
- Le Schtroumpf sera : 3 ∗ 4 + 3 ∗ 8 + 3 ∗ 7 + 3 ∗ 12 + 6 ∗ 4 + 6 ∗ 8 + 6 ∗ 7 + 6 ∗ 12 = 279

Créer un programme Java qui génère deux tableaux aléatoires (de valeurs de entre -10 et 10 inclus) de taille aléatoire ( 2 <= nombre d'éléments < 5) et qui calcule leur schtroumpf.

??? "10 premiers nombres premiers"

    ```java
    --8<--
    exo/serie-2/Schtroumph2Arrays.java
    --8<--
    ```
