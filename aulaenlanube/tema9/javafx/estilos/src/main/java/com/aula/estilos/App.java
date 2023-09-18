package com.aula.estilos;

import javafx.application.Application;
import javafx.application.Platform;
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

        // cargamos el FXML desde la carpeta resources
        Parent root = FXMLLoader.load(getClass().getResource("/com/aula/estilos/ventanaPrincipal.fxml"));
        Scene scene = new Scene(root, 500, 400);
        scene.getStylesheets().add(getClass().getResource("/css/estilosVentanaPrincipal1.css").toExternalForm());

        // configuramos ventana principal
        ventanaPrincipal.setTitle("Ventana Principal");
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.show();

        // método para mostrar una segunda ventana
        abrirVentanaSecundaria();

        // evento para cerrar la App al cerrar la ventana principal
        ventanaPrincipal.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
    }

    private void abrirVentanaSecundaria() throws Exception {

        // creamos un nuevo Stage (ventana)
        Stage ventanaSecundaria = new Stage();

        // cargamos el FXML desde la carpeta resources
        Parent root = FXMLLoader.load(getClass().getResource("ventanaSecundaria.fxml"));
        Scene scene = new Scene(root, 300, 200);
        scene.getStylesheets().add(getClass().getResource("/css/estilosVentanaSecundaria.css").toExternalForm());

        // configuramos ventana secundaria
        ventanaSecundaria.setTitle("Ventana Secundaria");
        ventanaSecundaria.setScene(scene);
        ventanaSecundaria.show();
    }

    public static void main(String[] args) {
        launch();
    }
}