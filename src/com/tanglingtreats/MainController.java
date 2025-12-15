package com.tanglingtreats;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    TextArea outputBox;

    @FXML
    TextArea inputBox;

    @FXML
    ChoiceBox<String> formatChoices;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> formats = FXCollections.observableArrayList(
          "None"
        );

        formatChoices.setItems(formats);
        formatChoices.getSelectionModel().selectFirst();
    }

    @FXML
    private void handleFormatAction() {
        String selectedFormat = formatChoices.getSelectionModel().getSelectedItem();

        System.out.println("Selected format: " + selectedFormat);
    }
}
