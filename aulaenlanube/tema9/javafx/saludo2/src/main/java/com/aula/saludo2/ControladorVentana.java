package com.aula.saludo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ControladorVentana {

    @FXML
    private TextField texto;
    
    @FXML
    private Button boton;

    @FXML
    public void initialize() {
        boton.setOnAction(e -> saludar(e));
    }

    @FXML
    public void saludar(ActionEvent e) {
        
        Button botonPulsado = (Button)e.getSource();
        botonPulsado.setStyle("-fx-background-color: #ffff00");
        

        String nombre = texto.getText();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Saludo Personalizado");
        alert.setHeaderText(null);
        alert.setContentText("Hola mundo " + nombre);
        alert.show();
    }
}
