package com.aula.agenda.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage ventanaPrincipal) throws Exception {
       
        // carga la vista principal desde el archivo fxml en un HBox
        HBox layoutPrincipal = FXMLLoader.load(getClass().getResource("/com/aula/agenda/vista/ventanaPrincipal.fxml"));

        // creamos la escena que contiene el layout principal
        Scene escena = new Scene(layoutPrincipal, 800, 500);

        // establecemos CSS
        escena.getStylesheets().add(getClass().getResource("/com/aula/agenda/estilos/estilos.css").toExternalForm());

        // establecemos la escena, título y la mostramos
        ventanaPrincipal.setScene(escena);
        ventanaPrincipal.setTitle("Agenda de Contactos");
        ventanaPrincipal.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}