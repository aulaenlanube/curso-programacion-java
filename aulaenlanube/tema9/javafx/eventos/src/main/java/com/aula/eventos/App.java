package com.aula.eventos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();

        // ContextMenu para el botón derecho del ratón
        ContextMenu contextMenu = new ContextMenu();
        MenuItem menuItem1 = new MenuItem("Opción 1");
        MenuItem menuItem2 = new MenuItem("Opción 2");
        contextMenu.getItems().addAll(menuItem1, menuItem2);

        // Manejando clics del botón derecho del ratón
        root.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                contextMenu.show(root, e.getScreenX(), e.getScreenY());
            }
        });

        // Manejando pulsaciones de teclas
        root.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.A) {
                System.out.println("Tecla 'A' presionada");
            } else if (e.getCode() == KeyCode.ENTER) {
                System.out.println("Tecla 'Enter' presionada");
            }
        });

        // Configurar escena y escenario
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Ejemplo de Manejo de Eventos de Teclado y Ratón");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}