module com.aula.estilos {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens com.aula.estilos to javafx.fxml;
    exports com.aula.estilos;
}
