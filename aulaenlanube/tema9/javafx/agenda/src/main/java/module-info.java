module com.aula.agenda {

    requires transitive javafx.controls;
    requires javafx.fxml;

    opens com.aula.agenda.vista to javafx.fxml;
    exports com.aula.agenda.vista;

    opens com.aula.agenda.controlador to javafx.fxml;
    exports com.aula.agenda.controlador;

        opens com.aula.agenda.modelo to javafx.fxml;
    exports com.aula.agenda.modelo;
}
