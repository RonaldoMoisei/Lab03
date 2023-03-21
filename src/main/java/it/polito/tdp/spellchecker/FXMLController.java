package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	private Dictionary dic;

	public void setModel(Dictionary dictionary) {
		this.dic = dictionary;
	}

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
        txtinput.setText("");
        txtOutput.setText("");
        txtNErrors.setText("");
        txtTimeProcess.setText("");
    }
    
    Long calcolaTime() {
		return  System.nanoTime();
    	
    }

    @FXML
    void doSpell(ActionEvent event) {
        if (cbmLanguage.getValue().equals("Italiano")) {
            dic.loadDictionary("Italian.txt");
        } else if (cbmLanguage.getValue().equals("English")) {
            dic.loadDictionary("English.txt");
        }

        // Trasformo txtInput in una lista di parole
        String[] words = txtinput.getText().replaceAll("[.,\\/#!$%\\^&\\*;:?{}=\\-_`~()\\[\\]\"]", "").split("\\s+");
        List<String> inputTextList = Arrays.asList(words);

       

        // Controllo ortografico del testo
        List<RichWord> results = dic.spellCheckText(inputTextList);


        // Aggiorno la GUI con i risultati
        String wrongWords = "";
        int numErrors = 0;
        for (RichWord rw : results) {
            if (!rw.isCorretto()) {
                wrongWords += rw.getParole() + " ";
                numErrors++;
            }
        }
        txtOutput.setText(wrongWords);
        txtNErrors.setText("Numero di parole sbagliate:" + Integer.toString(numErrors));
        txtTimeProcess.setText("Time to process: " + Long.toString(calcolaTime()) + " ms");
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

        dic = new Dictionary();
        cbmLanguage.getItems().add("English");
        cbmLanguage.getItems().add("Italiano");
    }

}



