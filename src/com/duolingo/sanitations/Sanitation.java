package com.duolingo.sanitations;

public class Sanitation {

    private static String[] noAllowCharacters = {"0","1","2","3","4","5","6","7","8","9",".",",",";",":","¿","?","¡","!","'","\"","(",")","[","]","{","}","-","_","+","=","*","\\","/","!","#","%","&","@","$","´","~","^","`","<",">"}; 

    public static String fomarWord(String word){
        String newWord = word.substring(0,1).toUpperCase()+ word.substring(1).toLowerCase();
        return newWord;
    }

    public static String extractCapitalLetter(String word){
        String newWord = word.substring(0, 1).toUpperCase();
        return newWord;
    }

    public static Boolean inputChecker(String word){
        String[] splittedWord = word.split( "");
        boolean result = false;

        for (int i = 0; i < splittedWord.length; i++) {// mirar con expresiones regular
            for (String string : noAllowCharacters) {
                if (splittedWord[i].equals(string)) {
                    System.out.println("ERROR: the character '"+splittedWord[i]+"' valid inputs, repeat de operation please.");
                    continue;
                } else {
                    result = true;
                }
            }
        }
        return result;
    }
}
