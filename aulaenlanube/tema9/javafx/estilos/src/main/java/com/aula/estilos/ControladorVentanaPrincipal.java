package com.aula.estilos;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class ControladorVentanaPrincipal {

    private int estiloBoton = 0;

    @FXML
    private Button botonPrincipal;

    @FXML
    private Button botonSecundario;

    @FXML
    public void saludo() {
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Saludo");
        alerta.setHeaderText(null);
        alerta.setContentText("Hola mundo desde JAVA FX!");
        alerta.show();
    }

    @FXML
    public void modificarEstilo() {

        if (estiloBoton % 2 == 0) {
            botonSecundario.getScene().getStylesheets().clear();
            botonSecundario.getScene().getStylesheets().add(getClass().getResource("/css/estilosVentanaPrincipal2.css").toExternalForm());                 
        } else {
            botonSecundario.getScene().getStylesheets().clear();
            botonSecundario.getScene().getStylesheets().add(getClass().getResource("/css/estilosVentanaPrincipal1.css").toExternalForm());  
        }
        estiloBoton++;
    }
}
