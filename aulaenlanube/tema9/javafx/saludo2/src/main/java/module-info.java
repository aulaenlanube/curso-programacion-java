module com.aula.saludo2 {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens com.aula.saludo2 to javafx.fxml;
    exports com.aula.saludo2;
}
