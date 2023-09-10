package com.aula.node;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage ventanaPrincipal) {

        Button boton1 = new Button("Botón 1");
        Button boton2 = new Button("Botón 2");

        boton1.setTranslateX(50);
        boton1.setTranslateY(50);

        boton2.setTranslateX(10);
        boton2.setTranslateY(50);

        VBox vbox = new VBox(); // VBox es una subclase de Parent
        vbox.getChildren().addAll(boton1, boton2);
        boton1.setRotate(45); // aplicamos una rotación de 45 al boton1
        vbox.setRotate(45); // aplicamos una rotación de 45 grados al vbox
        vbox.setTranslateY(100);

        Scene scene = new Scene(vbox, 500, 500); // La raíz de la escena es un Parent
        ventanaPrincipal.setTitle("Ejemplos Node");
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.show();
    }

    public static void main(String[] args) {
        launch();
    }

}