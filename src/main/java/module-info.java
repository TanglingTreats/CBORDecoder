module com.tanglingtreats {

    requires javafx.controls;
    requires javafx.fxml;

    opens com.tanglingtreats to javafx.fxml;
    exports com.tanglingtreats;
}