package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the entry point of a JAVA FX program (a class that extends Application)
 *
 * The main screen is loaded here (agenda.fxml)
 * Everything that happens afterwards is handled in the controller for that screen
 * (i.e. AgendaController.java - defined as the controller for agenda.fxml on line 14
 * of the fxml file)
 */
public class JavaFxDemoMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("fxml/agenda.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("JavaFX Demo");
        primaryStage.setScene(new Scene(root, 600, 350));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
