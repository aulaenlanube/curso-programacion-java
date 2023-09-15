package com.aula.css;

import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {



    @Override
    public void start(Stage stage) throws IOException {

        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        Button boton = new Button("Haz clic en mí");
        boton.getStyleClass().add("boton-personalizado");

        Text texto = new Text("Texto destacado");
        texto.getStyleClass().add("texto-destacado");

        root.getChildren().addAll(boton,texto);

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