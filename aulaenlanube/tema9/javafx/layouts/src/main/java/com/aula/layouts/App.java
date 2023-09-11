package com.aula.layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage ventanaPrincipal) {

        //botones
        Button btn1 = new Button("Insertar");
        Button btn2 = new Button("Modificar");
        Button btn3 = new Button("Listar");
        Button btn4 = new Button("Borrar");
        Button btn5 = new Button("Reiniciar");

        //hbox para la parte superior
        HBox hbox1 = new HBox(10);
        hbox1.getChildren().addAll(btn1, btn2, btn3);
        hbox1.setAlignment(Pos.CENTER);

        //vbox con etiqueta e imagen para la parte central
        Label etiqueta = new Label("Esto es una etiqueta dentro de un Vbox");
        ImageView imagen = new ImageView(new Image(getClass().getResourceAsStream("/JavaFXLogo.png")));
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(etiqueta, imagen);
        vbox.setAlignment(Pos.CENTER);
        
        //hbox para la parte inferior
        HBox hbox2 = new HBox(10);
        hbox2.getChildren().addAll(btn4, btn5);
        hbox2.setAlignment(Pos.CENTER);
        
        //BorderPane con los 3 contenedores
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hbox1);
        borderPane.setCenter(vbox);
        borderPane.setBottom(hbox2);
        borderPane.setPadding(new Insets(20, 20, 20, 20));

        //creamos la escena y mostramos
        Scene scene = new Scene(borderPane, 600, 400);
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.setTitle("Ejemplos Layouts");
        ventanaPrincipal.show();
    }

    public static void main(String[] args) {
        launch();
    }
}