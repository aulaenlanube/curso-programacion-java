package com.aula.saludo1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    public void start(Stage ventanaPrincipal) {
        TextField texto = new TextField();
        Button boton = new Button("Saludar");

        boton.setOnAction(e -> {
            String nombre = texto.getText();
            Alert alerta = new Alert(AlertType.WARNING);
            alerta.setTitle("Saludo Personalizado");    
            alerta.setHeaderText(null);        
            alerta.setContentText("Hola mundo " + nombre);
            alerta.show();
        });

        VBox vbox = new VBox(10);     
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20, 20, 20, 20));  
        vbox.getChildren().addAll(texto, boton);
        
        Scene scene = new Scene(vbox, 300, 150);
        ventanaPrincipal.setTitle("Ejemplo sin FXML");
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.show();
    } 


    public static void main(String[] args) {
        launch();
    }

}