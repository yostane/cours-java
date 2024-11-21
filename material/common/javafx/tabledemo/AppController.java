import java.util.Arrays;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * Cette classe fait office d'un controlleur dans le modèle MVC
 * Son rôle est de gérer les evenements et d'evoyer les données à la vue (le
 * fxml)
 */
public class AppController {

  /**
   * @FXML fait un équivalent de getElementById en JS: i.e. qu'il
   *       récupère le contrôle UI qui a le même id que le nom de la variable
   */
  @FXML
  private TextField nameTextField;
  @FXML
  private TextField missionsTextField;
  @FXML
  private TableView<Person> tableView;

  public TableView<Person> getTableView() {
    return tableView;
  }

  private List<String> parseMissions() {
    return Arrays.asList(missionsTextField.getText().split(","));
  }

  /**
   * initialize c'est un évènement prédéfini qui est appelé au moment où le
   * controleur est chargé par le fxml
   */
  @FXML
  public void initialize() {
    System.out.println("AppController.initialize");
    this.tableView.getItems().add(new Person("Hello", "World", HealthStatus.healthy, parseMissions()));
  }

  /** Va lier un évènement (#addPerson) dans le fxml à une fonction */
  @FXML
  public void addPerson() {
    System.out.println("AppController.addPerson");
    tableView.getItems().add(new Person(nameTextField.getText(), "Doe", HealthStatus.sick, parseMissions()));
  }
}
