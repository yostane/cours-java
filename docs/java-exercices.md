# Exercices

!!! warning "Consignes"

    - Ne pas de faire aider par des IA ou genAI

## Série 1

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

## Série 2

## Source
