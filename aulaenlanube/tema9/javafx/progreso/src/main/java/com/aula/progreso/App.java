package com.aula.progreso;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    public void start(Stage ventanaPrincipal) throws Exception {

        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        ProgressBar progressBar = new ProgressBar(0);
        Label label = new Label("Procesando...");

        DoubleProperty progressValue = new SimpleDoubleProperty(0);

        // Vinculamos la propiedad del progreso al contador
        progressBar.progressProperty().bind(progressValue);

        root.getChildren().addAll(progressBar, label);

        Scene scene = new Scene(root, 400, 300);

        ventanaPrincipal.setTitle("Barra de Progreso con Thread");
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.show();

        // Aumentar el contador con un hilo (simulando una tarea en segundo plano)
        new Thread(() -> {
            for (int i = 0; i <= 100; i++) {

                final int FINAL_I = i;
                
                Platform.runLater(() -> {
                    progressValue.set(FINAL_I / 100.0);

                    if (FINAL_I == 100) {
                        label.setText("Completado!!");
                        progressBar.setStyle("-fx-accent: green");
                    }
                });

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        launch();
    }

}