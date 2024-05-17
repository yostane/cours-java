/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

// Les annotations de nullabilité sont traitées par certains IDE et outils pour s'assurer avant la compilation qu'il n'y aura pas de NPE
// Les IDE génèrent généralement un avertissement et non une erreur
// Ces annotations sont ignorées par le compilateur Java (au moins jusqu'à la version 21)
// Il y a aussi une multitude d'annotations fournies par différentes librairies qui peuvent créer de la confusion

public class App {

  @Nonnull
  private List<String> items;

  @Nonnull
  List<String> getItems() {
    return this.items;
  }

  public App() {
    this.items = new ArrayList<>();
  }

  @Nonnull
  public String getGreeting() {
    return "dsfsdfd";
  }

  @Nonnull
  public String getValue(@Nullable String value) {
    if (value != null) {
      return value.toUpperCase();
    }
    return "";
  }

  public static void main(String[] args) {
    @Nonnull
    App app = new App();

    app.getValue(null);

    System.out.println(app.getItems().size());
    app.getItems().add(null);
    app.getItems().add("toto");
    System.out.println(app.getItems().size());
  }
}
