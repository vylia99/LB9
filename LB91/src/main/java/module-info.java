module com.example.lb91 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.lb91 to javafx.fxml;
    exports com.example.lb91;
}