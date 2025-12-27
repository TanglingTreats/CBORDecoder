package com.tanglingtreats;

import com.tanglingtreats.exception.InvalidCBORFormatException;
import com.tanglingtreats.template.Template;
import com.tanglingtreats.template.TemplateFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

    @FXML
    Button convertBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> formats = FXCollections.observableArrayList(
                Template.Type.STRINGS
        );

        formatChoices.setItems(formats);
        formatChoices.getSelectionModel().selectFirst();
    }

    @FXML
    private void handleFormatAction() {
        String selectedFormat = formatChoices.getSelectionModel().getSelectedItem();

        System.out.println("Selected format: " + selectedFormat);

        String input = inputBox.getText();

        if (!Util.isHexadecimal(input)) {
            setToOutput(Constants.ERR_INVALID_FORMAT);
        } else {
            Template template = TemplateFactory.getTemplate(selectedFormat);
            byte[] ba = Util.hexStringToByteArray(input);
            setToOutput(Decoder.decode(ba, template));
        }
    }

    private void setToInput(String input) {
        inputBox.setText(input);
    }

    private void setToOutput(String input) {
        outputBox.setText(input);
    }

}
