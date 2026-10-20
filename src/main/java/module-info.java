module com.mycompany.conteo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.conteo to javafx.fxml;
    exports com.mycompany.conteo;
}
