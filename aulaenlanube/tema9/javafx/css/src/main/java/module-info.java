module com.aula.css {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens com.aula.css to javafx.fxml;
    exports com.aula.css;
}
