package com.aula.estilos;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladorVentanaSecundaria {

    @FXML
    private Button botonCerrar;

    @FXML
    public void cerrarVentana() {
        Stage ventanaActual = (Stage)botonCerrar.getScene().getWindow();
        ventanaActual.close(); 
    }    
}
