import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AppController {

  @FXML
  private TextField nameTextField;
  @FXML
  private TableView<Person> tableView;

  public TableView<Person> getTableView() {
    return tableView;
  }

  @FXML
  public void initialize() {
    System.out.println("AppController.initialize");
    this.tableView.getItems().add(new Person("Hello", "World"));
  }

  @FXML
  public void addPerson() {
    System.out.println("AppController.addPerson");
    tableView.getItems().add(new Person(nameTextField.getText(), "Doe"));
  }
}
