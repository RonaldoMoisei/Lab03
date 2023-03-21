package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dictionary {

    private Set<String> dictionary;

    public void loadDictionary(String language) {
        dictionary = new HashSet<>();
        try { 
            FileReader fr = new FileReader(language); 
            BufferedReader br = new BufferedReader(fr); 
            String word; 
            while ((word = br.readLine()) != null) { 
                dictionary.add(word.toLowerCase()); 
            } 
            br.close(); 
        } catch (IOException e){ 
            System.out.println("Errore nella lettura del file"); 
        }
    }

    public List<RichWord> spellCheckText(List<String> inputTextList) {
        List<RichWord> result = new ArrayList<>();
        
        for (String word : inputTextList) {
            boolean isCorrect = dictionary.contains(word.toLowerCase());
            RichWord richWord = new RichWord(word, isCorrect);
            result.add(richWord);
        }
        
        return result;
    }

	public Set<String> getDictionary() {
		return dictionary;
	}

	public void setDictionary(Set<String> dictionary) {
		this.dictionary = dictionary;
	}
    
    

}
