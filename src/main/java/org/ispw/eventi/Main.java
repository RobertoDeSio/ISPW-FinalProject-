package org.ispw.eventi;

import org.ispw.eventi.controller.viewcontroller.HomeController;
import org.ispw.eventi.navigation.NavigationService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // 1. NavigationService creato una volta sola con lo stage
        NavigationService nav = new NavigationService(stage);

        // 2. Carica home.fxml (rinominato da registrazione.fxml)
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/org/ispw/eventi/fxml/home.fxml")
        );

        // 3. Inietta il controller PRIMA di load()
        //    NON mettere fx:controller nell'FXML — lo gestiamo qui
        loader.setController(new HomeController(nav));

        Parent root = loader.load();

        stage.setTitle("Weekender");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}