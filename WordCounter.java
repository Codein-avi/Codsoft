import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Word Counter");
        System.out.println("Enter: '1' to input text or '2' to provide a file: ");
        int option = sc.nextInt();   // User Input of the option
        sc.nextLine();

        String inputText = "";    // To store the user input by the user

        switch (option) {   // Switch is used to perform respective operation based on user input
            case 1:
                System.out.println("Enter your text:");
                inputText = sc.nextLine();
                break;
            case 2:
                System.out.println("Enter the path of the file:");
                String filePath = sc.nextLine();   // Path of file is stored to access the file
                try {
                    inputText = readFileContent(filePath);  // Content of file is read
                } catch (FileNotFoundException e) {         // Executed if specified file is not found
                    System.out.println("Error: File not found.");
                    sc.close();
                    return;
                }
                break;
            default:                              // Executed when wrong choice is provided by the user
                System.out.println("Invalid option. Exiting.");
                sc.close();
                return;
        }

        int totalwords = countWords(inputText);  // Total no. of words are counted
        System.out.println("Total word count: " + totalwords);

        //Unique words are counted and their frequency is displayed
        Set<String> uniqueWords = getUniqueWords(inputText);
        System.out.println("Total unique words: " + uniqueWords.size());
        System.out.println("Word frequency:");
        for (String word : uniqueWords) {
            int frequency = countWordFrequency(inputText, word);
            System.out.println(word + ": " + frequency);
        }

        sc.close();
    }

    private static String readFileContent(String filePath) throws FileNotFoundException {
        File file = new File(filePath); // File object is created by passing path of file to it
        StringBuilder content = new StringBuilder();
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            content.append(fileScanner.nextLine()).append("\n");
        }
        fileScanner.close();
        return content.toString();
    }

    private static int countWords(String text) {  // Function for counting number of Words in a file
        if (text.isEmpty()) {
            return 0;
        }
        String[] words = text.split("[\\s\\p{Punct}]+");
        return words.length;
    }

    private static Set<String> getUniqueWords(String text) { // Function for getting unique words
        String[] words = text.split("[\\s\\p{Punct}]+");
        HashSet<String> uniqueWords = new HashSet<String>();
        for (String word : words) {
            uniqueWords.add(word.toLowerCase()); // Ignore case to treat words in a case-insensitive manner
        }
        return uniqueWords;
    }

    // Finding the frequency of each unique word
    private static int countWordFrequency(String text, String word) {
        String[] words = text.split("[\\s\\p{Punct}]+");
        int frequency = 0;
        for (String w : words) {
            if (w.equalsIgnoreCase(word)) {
                frequency++;
            }
        }
        return frequency;
    }
}

