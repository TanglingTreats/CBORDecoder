package com.tanglingtreats;

import com.tanglingtreats.templates.Template;
import com.tanglingtreats.templates.TemplateFactory;
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

        if (!isHexadecimal(input)) {
            setToOutput(Template.ERR_INVALID_INPUT);
        }

        Template template = TemplateFactory.getTemplate(selectedFormat);

        setToOutput(Decoder.decode(input, template));
    }

    private void setToInput(String input) {
        inputBox.setText(input);
    }

    private void setToOutput(String input) {
        outputBox.setText(input);
    }

    private boolean isHexadecimal(String input) throws NumberFormatException {
        try {
            Long.parseLong(input, 16);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
