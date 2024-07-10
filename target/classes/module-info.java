module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.compiler;

    opens org.example to javafx.fxml;
    exports org.example;
}
