package com.tanglingtreats;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class CBORDecoder extends Application {
    private static Scene scene;
    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFXML("main"));

        stage.setTitle("CBOR Decoder");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    private static Parent loadFXML(String fileName) throws IOException {
        FXMLLoader loader = new FXMLLoader(CBORDecoder.class.getClassLoader().getResource(fileName + ".fxml"));
         return loader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
