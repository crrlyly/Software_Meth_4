module com.example.software_meth_4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.software_meth_4 to javafx.fxml;
    exports com.example.software_meth_4;
    exports com.example.software_meth_4.controllers;
    opens com.example.software_meth_4.controllers to javafx.fxml;
}