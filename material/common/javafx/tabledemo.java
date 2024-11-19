///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS org.openjfx:javafx-controls:23
//DEPS org.openjfx:javafx-graphics:23:${os.detected.jfxname}
//DEPS org.openjfx:javafx-fxml:23

//SOURCES Person.java

//FILES tabledemo.fxml

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

class AppController {

  @FXML
  private TableView<Person> tableView;

  public TableView<Person> getTableView() {
    return tableView;
  }
}

// Inspired from
// https://gist.github.com/FDelporte/c69a02c57acc892b4c996a9779d4f830
public class tabledemo extends Application {
  private Scene scene;

  @Override
  public void start(Stage stage) throws IOException {
    AppController controller = null;
    try {
      final URL url = getClass().getResource("tabledemo.fxml");
      final FXMLLoader fxmlLoader = new FXMLLoader(url);
      final AnchorPane root = (AnchorPane) fxmlLoader.load();
      controller = (AppController) fxmlLoader.getController();
      scene = new Scene(root, 300, 250);
      stage.setScene(scene);
    } catch (IOException ex) {
      System.err.println("Erreur au chargement: " + ex);
      System.exit(1);
    }
    if (controller == null) {
      System.exit(1);
    }
    controller.getTableView().getItems().add(new Person("Hello", "World"));
    stage.setTitle("Test FXML");
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
