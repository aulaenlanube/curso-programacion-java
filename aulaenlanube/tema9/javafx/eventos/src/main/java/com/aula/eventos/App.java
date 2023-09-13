package com.aula.eventos;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        // creamos contenedor con un botón dentro
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        Button boton = new Button("Pulsa");
        root.getChildren().addAll(boton);
        Scene scene = new Scene(root, 400, 400);

        // ContextMenu para el botón derecho del ratón
        ContextMenu contextMenu = new ContextMenu();
        MenuItem menuItem1 = new MenuItem("Botón Verde");
        MenuItem menuItem2 = new MenuItem("Botón Azul");
        contextMenu.getItems().addAll(menuItem1, menuItem2);

        // evento clic derecho del ratón
        root.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                contextMenu.show(root, e.getScreenX(), e.getScreenY());                
            }
        });

        menuItem1.setOnAction(e  -> boton.setBackground(new Background(new BackgroundFill(Color.PALEGREEN, null, null))));
        menuItem2.setOnAction(e  -> boton.setStyle("-fx-background-color: dodgerblue"));

        // evento de pulsaciones de teclas
        root.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.A) {
                System.out.println("Tecla 'A' presionada");
            } else if (e.getCode() == KeyCode.ENTER) {
                System.out.println("Tecla 'Enter' presionada");
            }
        });

        // configurar escena y ventana        
        primaryStage.setTitle("Ejemplo de Manejo de Eventos de Teclado y Ratón");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}