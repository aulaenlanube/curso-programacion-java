package com.aula.saludo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage ventanaPrincipal) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("vista.fxml"));
        Scene scene = new Scene(root, 300, 150);
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.setTitle("Ejemplo con FXML");        
        ventanaPrincipal.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}