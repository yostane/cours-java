import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
  /**
   * Wrapper (surcouche) de la classe String qui est compatible avec les
   * TableView. Cette propriété peut être associée à une colonne.
   * new SimpleStringProperty("") le "" veut dire que la propriété est initialisée
   * avec une chaîne vide.
   * Le StringProperty va de paire avec les balises cellValueFactory et
   * PropertyValueFactory
   */
  private final StringProperty name = new SimpleStringProperty("");
  /**
   * Dans le jargon POO name et job sont appelées des backing fields. i.e ce sont
   * les variables qui stockent ou permettent de gérer la valeur de la propriété
   */
  private final StringProperty job = new SimpleStringProperty("");

  public Person(String name, String job) {
    setName(name);
    setJob(job);
  }

  @Override
  public String toString() {
    return "Person [name=" + getName() + ", job=" + getJob() + "]";
  }

  public String getName() {
    return name.get();
  }

  public void setName(String name) {
    this.name.set(name);
    ;
  }

  public String getJob() {
    return job.get();
  }

  public void setJob(String job) {
    this.job.set(job);
  }
}
