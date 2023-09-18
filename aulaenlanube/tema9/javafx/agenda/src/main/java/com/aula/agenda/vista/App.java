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

    private Stage ventanaPrincipal;
    private HBox layoutPrincipal;

    @Override
    public void start(Stage ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.ventanaPrincipal.setTitle("Agenda de Contactos");
        mostrarVistaPrincipal();
    }

    public void mostrarVistaPrincipal() {

        try {
            // Carga la vista principal desde el archivo fxml            
            layoutPrincipal = FXMLLoader.load(getClass().getResource("/com/aula/agenda/vista/ventanaPrincipal.fxml"));

            // Muestra la escena que contiene el layout principal
            Scene escena = new Scene(layoutPrincipal, 800, 500);

            //establecemos CSS
            escena.getStylesheets().add(getClass().getResource("/com/aula/agenda/estilos/estilos.css").toExternalForm());

            // establecemos la escena y la mostramos
            ventanaPrincipal.setScene(escena);
            ventanaPrincipal.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }   

    public static void main(String[] args) {
        launch(args);
    }
}