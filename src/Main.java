import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in); BufferedReader reader = new BufferedReader(new FileReader("src/WordList.txt"))) {
            List<String> words = new ArrayList<>();
            String line;
            String word = "";
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
            if(!words.isEmpty()) {
                int chosen = (int) (Math.random() * words.size());
                word = words.get(chosen).toUpperCase();
//                System.out.println(words.get(chosen));
            }
            else {
                System.out.println("Word list is empty.");
            }

            // Hide the word

            //Create a list of 26 letters
            String[] alphabet =  {""};

            //Counting how many tries left

            // Player enter a character > removes from list > compare with letters in word chosen >
            // replace visually with letter entered > show how many play left
            // Game win iff all letters found, or tries == 7

//            String word = "HANGMAN";
//            String updatedWord = "-------";
//            String word = "HANGMAN";
            String updatedWord = "-".repeat(word.length());
            int chancesLeft = 7;

            while (true) {

                if (chancesLeft == 0) {
                    System.out.println("You lost!");
                    System.out.printf("The word was %s!", word);
                    break;
                } else if (updatedWord.equals(word)) {
                    System.out.println(word);
                    System.out.println("You Win!");
                    break;
                }
                System.out.println(updatedWord);
                System.out.println("Pick a letter: ");
                char guess = scanner.next().toUpperCase().charAt(0);

                if (update(word, guess, updatedWord).equals("No")) {
                    chancesLeft -= 1;
                } else {
                    updatedWord = update(word, guess, updatedWord);
                }

                System.out.printf("%d Tries left.\n", chancesLeft);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String update(String word, char guess, String updatedWord ) {

        char[] chars = updatedWord.toCharArray();
        boolean change = false;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                chars[i] = guess;
                change = true;
            }
        } if (!change) {
            System.out.println("No change with letter "+ guess);
            return "No";
        }
        else {
            updatedWord = new String(chars);
            return updatedWord;
        }
    }


}

// restart program
// limit to one character
// show letters left available
// count how many time you win.
// add a menu, where you can add words