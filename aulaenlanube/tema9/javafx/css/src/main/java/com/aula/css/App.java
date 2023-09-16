package com.aula.css;

import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        Button b1 = new Button("Pulsa1");
        Button b2 = new Button("Pulsa2");
        Button b3 = new Button("Pulsa3");
        Button b4 = new Button("Pulsa4");
        b1.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        b2.getStyleClass().add("boton-especial");
        b2.setStyle("-fx-background-color: blue;");
        b3.setStyle("-fx-background-color: blue;");
        b3.getStyleClass().add("boton-especial");

        root.getChildren().addAll(b1, b2, b3, b4);

        Scene escena = new Scene(root, 400, 300);
        escena.getStylesheets().add("fichero.css");

        stage.setTitle("Pruebas CSS");
        stage.setScene(escena);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}