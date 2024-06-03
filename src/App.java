import java.util.Scanner;

import com.duolingo.dictionary.Dictionary;
import com.duolingo.sanitations.Sanitation;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        Dictionary dictionary = new Dictionary();

        String inputWord ="";
        
        String option = "-1";

        String menuMessage = """
            =====================
            English Dictionary!
            =====================
            1. Add a word
            2. Delete a word
            3. Check existing word
            4. Check the initials  of the dictionary
            5. Search words by their initial.
            6. Close the program.
            =====================

            Please choose one of
            the options above:
                """;

        while (option != "6") {
            System.out.println("\n"+menuMessage+"\n");
            option = scanner.nextLine();
            
            switch (option) {
                case "1":
                    System.out.println("Write a word to add it to the dictionary: ");
                    inputWord = scanner.nextLine();
                    if (!Sanitation.inputChecker(inputWord)) {
                        dictionary.addWord(inputWord);
                    }
                    break;
                case "2":
                    System.out.println("Write the word you want to delete: ");
                    inputWord = scanner.nextLine();
                    if (!Sanitation.inputChecker(inputWord)) {
                        dictionary.deleteWord(inputWord);
                    }
                    break;
                case "3":
                    System.out.println("Write the word you want to find: ");
                    inputWord = scanner.nextLine();
                    if (!Sanitation.inputChecker(inputWord)) {
                        dictionary.findWord(inputWord);
                    }
                    break;
                case "4":
                    System.out.println("This are the initials that had been safed: ");
                    dictionary.showSafedsInitials();    
                    break;
                case "5":
                    System.out.println("Write the word initial: ");
                    inputWord = scanner.nextLine();
                    if (!Sanitation.inputChecker(inputWord)) {
                        dictionary.searchByInitial(inputWord);
                    }
                    break;
                case "6":
                    System.out.println("See you next time.");
                    option = "6";
                    break;
                default:
                    System.out.println("Choose an option of the screen please.");
                    break;
            }
        }
        scanner.close();
    }
}
