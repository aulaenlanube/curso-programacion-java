package com.aula.agenda.controlador;

import com.aula.agenda.modelo.Contacto;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class NuevoContactoController {

    @FXML
    private TextField campoNombre;
    @FXML
    private TextField campoTelefono;
    @FXML
    private TextField campoCorreo;
    @FXML
    private TextField campoWebPersonal;
    @FXML
    private Label nombreImagen;
    @FXML
    private ImageView previsualizacionImagen;

    private File archivoImagen;
    private VentanaPrincipalController controladorPrincipal;

    // método para enlazar con el controlador principal
    public void setControladorPrincipal(VentanaPrincipalController controladorPrincipal) {
        this.controladorPrincipal = controladorPrincipal;
    }

    @FXML
    public void initialize() {
        // código de inicialización si es necesario
    }

    @FXML
    private void cargarImagen() {
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar Imagen de Perfil");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imágenes", "*.jpg", "*.png", "*.jpeg"));

        archivoImagen = fileChooser.showOpenDialog(null);

        if (archivoImagen != null) {

            // si queremos ver vista previa de la imagen
            // Image imagen = new Image(archivoImagen.toURI().toString());
            // previsualizacionImagen.setImage(imagen);

            // mostramos nombre de la imagen
            nombreImagen.setText(Paths.get(archivoImagen.getAbsolutePath()).getFileName().toString());
        }
    }

    @FXML
    private void guardarContacto() {

        String nombre = campoNombre.getText();
        String telefono = campoTelefono.getText();
        String correo = campoCorreo.getText();
        String webPersonal = campoWebPersonal.getText();
        String imagen = (archivoImagen != null) ? guardarImagen() : "default.jpg";

        Contacto nuevoContacto = new Contacto(nombre, correo, imagen, webPersonal, telefono);

        // agregamos el nuevo contacto a la lista del ControladorPrincipal
        controladorPrincipal.agregarContacto(nuevoContacto);

        // cerramos ventana
        cancelar();
    }

    @FXML
    private void cancelar() {

        // obtenemos la instancia de la ventana actual
        Stage ventanaActual = (Stage) campoNombre.getScene().getWindow();

        // cerramos la ventana
        ventanaActual.close();
    }

    private String guardarImagen() {

        try {
            // definimos carpeta para guardar la imagen
            Path carpetaDestino = Paths.get("src/main/resources/com/aula/agenda/imgs");

            //obtenemos nombre de la imagen del path de origen
            Path imagenOrigen = Paths.get(archivoImagen.getAbsolutePath());
            Path imagenDestino = carpetaDestino.resolve(imagenOrigen.getFileName());

            // hacemos una copia de la imagen
            Files.copy(imagenOrigen, imagenDestino, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // devolvemos el nombre del fichero
        return nombreImagen.getText();
    }
}
