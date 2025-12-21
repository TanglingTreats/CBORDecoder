module com.tanglingtreats {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.tanglingtreats to javafx.fxml;
    exports com.tanglingtreats;
}