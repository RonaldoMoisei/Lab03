package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClearText;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private ComboBox<String> cbmLanguage;

    @FXML
    private Label txtNErrors;

    @FXML
    private TextArea txtOutput;

    @FXML
    private Label txtTimeProcess;

    @FXML
    private TextArea txtinput;

    @FXML
    void doClear(ActionEvent event) {

    }

    @FXML
    void doSpell(ActionEvent event) {

    }

    @FXML
    void selectLanguage(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cbmLanguage != null : "fx:id=\"cbmLanguage\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNErrors != null : "fx:id=\"txtNErrors\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTimeProcess != null : "fx:id=\"txtTimeProcess\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtinput != null : "fx:id=\"txtinput\" was not injected: check your FXML file 'Scene.fxml'.";

        cbmLanguage.getItems().add("English");
        cbmLanguage.getItems().add("Italiano");
    }

}



