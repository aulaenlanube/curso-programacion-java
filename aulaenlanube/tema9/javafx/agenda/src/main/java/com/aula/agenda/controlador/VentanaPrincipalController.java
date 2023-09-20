package com.aula.agenda.controlador;

import com.aula.agenda.modelo.Contacto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaPrincipalController {

    @FXML
    private TableView<Contacto> tablaContactos;
    @FXML
    private TableColumn<Contacto, String> columnaNombre;
    @FXML
    private TableColumn<Contacto, String> columnaTelefono;
    @FXML
    private TableColumn<Contacto, String> columnaCorreo;
    @FXML
    private Label labelNombre;
    @FXML
    private Label labelTelefono;
    @FXML
    private Label labelCorreo;
    @FXML
    private Label labelWebPersonal;
    @FXML
    private ImageView imagenPerfil;

    private ObservableList<Contacto> listaContactos;

    @FXML
    public void initialize() {

        // crear borde para el ImageView
        DropShadow borde = new DropShadow();
        borde.setRadius(10.0);
        borde.setOffsetX(0);
        borde.setOffsetY(0);
        borde.setColor(Color.BLACK);
        imagenPerfil.setEffect(borde);

        // crea un ObservableArrayList para los contactos
        listaContactos = FXCollections.observableArrayList();

        // agregamos algunos contactos de muestra
        listaContactos.add(new Contacto("Pep", "pep@pep.com", "img (1).jpg", "https://aulaenlanube.com", "11111111"));
        listaContactos.add(new Contacto("Tom", "tom@tom.com", "img (2).jpg", "https://aulaenlanube.com", "22222222"));
        listaContactos.add(new Contacto("Jon", "jon@jon.com", "img (3).jpg", "https://aulaenlanube.com", "33333333"));
        listaContactos.add(new Contacto("Sam", "sam@sam.com", "img (4).jpg", "https://aulaenlanube.com", "44444444"));

        // almacenamos los contactos de la lista en la tabla
        tablaContactos.setItems(listaContactos);

        // configuramos las columnas nombre, telefóno y correo
        columnaNombre.setCellValueFactory(cellData -> cellData.getValue().getNombre());
        columnaTelefono.setCellValueFactory(cellData -> cellData.getValue().getTelefono());
        columnaCorreo.setCellValueFactory(cellData -> cellData.getValue().getCorreo());

        // evento para actualizar la información del contacto seleccionado en la tabla
        tablaContactos.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> mostrarDetallesContacto(newValue));

    }

    // mostramos los detalles de un contacto en la parte derecha de la ventana
    private void mostrarDetallesContacto(Contacto contacto) {

        // comrpobamos si tenemos un Contacto
        if (contacto != null) {
            labelNombre.setText("Nombre: " + contacto.getNombre().getValue());
            labelTelefono.setText("Teléfono: " + contacto.getTelefono().getValue());
            labelCorreo.setText("Correo: " + contacto.getCorreo().getValue());
            labelWebPersonal.setText("Web personal: " + contacto.getWebPersonal().getValue());

            // si tenemos imagen de perfil
            if (contacto.getImagenPerfil().getValue() != null && !contacto.getImagenPerfil().getValue().isEmpty()) {
                imagenPerfil.setImage(new Image(getClass().getResourceAsStream(contacto.getRutaImagenPerfil())));
            } else {
                imagenPerfil.setImage(null);
            }
        } else {
            labelNombre.setText("Elige un contacto para visualizar sus datos");
            imagenPerfil.setImage(null);
        }
    }

    @FXML
    private NuevoContactoController crearVentanaContacto() throws Exception {

        // cargamos el archivo FXML del formulario
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/aula/agenda/vista/nuevoContacto.fxml"));
        Parent root = loader.load();

        // enlazamos el controlador del formulario con el controlador principal
        NuevoContactoController controladorSecundario = loader.getController();
        controladorSecundario.setControladorPrincipal(this);

        // crear un nuevo Stage (ventana)
        Stage ventanaFormulario = new Stage();
        ventanaFormulario.setTitle("Añadir nuevo contacto");
        ventanaFormulario.initModality(Modality.WINDOW_MODAL); // modal
        ventanaFormulario.initOwner(tablaContactos.getScene().getWindow()); // asigna la ventana principal como
                                                                            // propietaria

        // establecer la escena y mostrar la ventana
        Scene escena = new Scene(root);

        // establecemos CSS
        escena.getStylesheets()
                .add(getClass().getResource("/com/aula/agenda/estilos/estilos.css").toExternalForm());

        // mostramos ventana
        ventanaFormulario.setScene(escena);
        ventanaFormulario.show();

        // devolvemos el controlador de la ventana
        return controladorSecundario;
    }

    @FXML
    private void mostrarFormulario() throws Exception {
        crearVentanaContacto();
    }

    public void agregarContacto(Contacto c) {
        // la tabla está enlazada con listaContactos, se actualizará automáticamente
        listaContactos.add(c);
    }

    @FXML
    private void editarContacto() throws Exception {

        Contacto contactoSeleccionado = tablaContactos.getSelectionModel().getSelectedItem();

        if (contactoSeleccionado != null) {      
            NuevoContactoController controladorSecundario = crearVentanaContacto();            
            controladorSecundario.setContactoActual(contactoSeleccionado);

        } else {

            // informa al usuario que debe seleccionar un contacto para editarlo
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("ERROR");
            alerta.setHeaderText(null);
            alerta.setContentText(
                    "ERROR al editar contacto. Debes seleccionar un contacto de la tabla para poder editarlo.");
            alerta.showAndWait();
        }
    }

    @FXML
    private void eliminarContacto() {

        int indiceSeleccionado = tablaContactos.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado >= 0) {
            // Borrar el contacto de la lista de contactos
            tablaContactos.getItems().remove(indiceSeleccionado);

            // mostramos alerta
            Alert alerta = new Alert(AlertType.INFORMATION);
            alerta.setTitle("Contacto Borrado");
            alerta.setHeaderText(null);
            alerta.setContentText("El contacto ha sido borrado de forma correcta.");
            alerta.showAndWait();

        } else {

            // Informa al usuario que debe seleccionar un contacto para borrarlo
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("ERROR");
            alerta.setHeaderText(null);
            alerta.setContentText(
                    "ERROR al borrar contacto. Debes seleccionar un contacto de la tabla para poder borrarlo.");
            alerta.showAndWait();

        }
    }

}
