package com.duolingo.dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.duolingo.sanitations.Sanitation;

public class Dictionary {

    private Map<String, Set<String>> dictionaryContent = new HashMap<>();

    public Dictionary (){
    }

    public void addWord(String word){
        if (word.length() > 1) {
            String newWord = word.trim();
    
            newWord = Sanitation.fomarWord(word);
    
            String captialLetter = Sanitation.extractCapitalLetter(word);
    
            if (dictionaryContent.containsKey(captialLetter)) {
                Set<String> wordsList = dictionaryContent.get(captialLetter);
                wordsList.add(newWord);
                dictionaryContent.put(captialLetter, wordsList);
            } else {
                Set<String> wordsList = new HashSet<>();
                wordsList.add(newWord);
                dictionaryContent.put(captialLetter, wordsList);
            }
    
            System.out.println("'"+newWord+"' has been added to the dictionary.");
        } else {
            System.out.println("ERROR: Invalid input. Enter word of more than one character.");
        }
    }

    public void deleteWord(String word){
        String newWord = word.trim();
        newWord = Sanitation.fomarWord(word);
        String captialLetter = Sanitation.extractCapitalLetter(word);

        if (dictionaryContent.containsKey(captialLetter)) {
            Set<String> wordsList = dictionaryContent.get(captialLetter);
            wordsList.remove(newWord);
            dictionaryContent.put(captialLetter, wordsList);
            System.out.println("'"+newWord+"' has been deleted from the dictionary.");
        } else {
            System.out.println("The word doesn't exist.");
        }
    }

    public void findWord(String word){
        String newWord = word.trim();
        newWord = Sanitation.fomarWord(word);
        String captialLetter = Sanitation.extractCapitalLetter(word);
        String errorMessage = "ERROR: The word doesn't exist.";
        if (dictionaryContent.containsKey(captialLetter) ) {
            Set<String> wordsList = dictionaryContent.get(captialLetter);
            if (wordsList.contains(newWord)) {
                System.out.println("'"+newWord+"' has been found in the dictionary.");
            } else{
                System.out.println(errorMessage);
            }
        } else {
            System.out.println(errorMessage);
        }
    }

    public void showSafedsInitials(){
        System.out.println(dictionaryContent.keySet());
    }

    public void searchByInitial(String initial){
        String newInitial = initial.toUpperCase();

        if (newInitial.length() == 1) {
            if (dictionaryContent.containsKey(newInitial) ) {
                System.out.println("This are the words which start with '"+newInitial+"':");
                System.out.println(dictionaryContent.get(newInitial));
            } else {
                System.out.println("ERROR: No words founded by that initial.");
            }
        } else {
            System.out.println("ERROR: you enter a wrong input.");
        }
    }
}