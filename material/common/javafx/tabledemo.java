///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS org.openjfx:javafx-controls:23
//DEPS org.openjfx:javafx-graphics:23:${os.detected.jfxname}
//DEPS org.openjfx:javafx-fxml:23

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

// Inspired from https://gist.github.com/FDelporte/c69a02c57acc892b4c996a9779d4f830
public class tabledemo extends Application {
  private Scene scene;

  @Override
  public void start(Stage stage) throws IOException {
    try {
      final URL url = getClass().getResource("test.fxml");
      final FXMLLoader fxmlLoader = new FXMLLoader(url);
      final AnchorPane root = (AnchorPane) fxmlLoader.load();
      scene = new Scene(root, 300, 250);
      stage.setScene(scene);
    } catch (IOException ex) {
      System.err.println("Erreur au chargement: " + ex);
    }
    stage.setTitle("Test FXML");
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
