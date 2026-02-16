import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int winsCount = 0;
        int playCount = 0;

        System.out.println("************************");
        System.out.println("Welcome to Hangman Game!");
        System.out.println("************************\n");

        while (true) {
        // Read words from WordList.txt into a list
        try (BufferedReader reader = new BufferedReader(new FileReader("src/WordList.txt"))) {
            List<String> words = new ArrayList<>();
            String line;
            String word = "";
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
            // Pick a random word and convert to uppercase
            if (!words.isEmpty()) {
                int chosen = (int) (Math.random() * words.size());
                word = words.get(chosen).toUpperCase();
                playCount++;
            } else {
                System.out.println("Word list is empty.");
            }


            // Create masked word with dashes
            String updatedWord = "_".repeat(word.length());
            int chancesLeft = 7;
            List<Character> letters = new ArrayList<>();

            System.out.printf("The word has %d letter. Good Luck!\n\n", word.length());

            // Main game loop: show word, read guess,f update, print hangman
            while (true) {



                // Print hangman ASCII art depending on remaining chances
                System.out.println(printMan(chancesLeft));

                if (chancesLeft == 0) {
                    System.out.println("You lost!");
                    System.out.printf("The word was %s!\n", word);
                    break;
                }
                System.out.println(updatedWord);
                System.out.printf("Already tried: %s.\n", letters);
                System.out.printf("\nPick a letter: ");
                char guess = scanner.next().toUpperCase().charAt(0);
                letters.add(guess);

                // Update the word with guessed letter or return "No" if not found
                if (update(word, guess, updatedWord).equals("false")) {
                    chancesLeft -= 1;
                } else {
                    updatedWord = update(word, guess, updatedWord);
                }
                if (updatedWord.equals(word)) {
                    winsCount++;
                    System.out.println(word);
                    System.out.println("You Win!\n");
                    break;
                }
                if (chancesLeft == 1) {
                    System.out.println("Last Chance!");
                }
                else if (chancesLeft == 0) {
                    System.out.println("Game Over!\n");
                } else {
                    System.out.printf("%d Tries left.\n\n", chancesLeft);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
            System.out.printf("Total score of wins: %d/%d\n", winsCount, playCount);
            System.out.println("Continue? (Y/N)");
            char stop = scanner.next().toUpperCase().charAt(0);
            if (stop == 'N') {
                scanner.close();
                System.out.println("Bye!");
                break;
            }

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
            return "false";
        }
        else {
            updatedWord = new String(chars);
            return updatedWord;
        }
    }
    public static String printMan(int chances) {
        switch (chances) {
            case 7 -> { return """
                                |-----
                                |
                                |
                                |
                                |
                                |
                                |______
                                """;}
            case 6 -> { return """
                                |----
                                |   |
                                |
                                |
                                |
                                |
                                |______
                                """;}
            case 5 -> { return """
                                |----
                                |   |
                                |  ( )
                                |
                                |
                                |
                                |______
                                """;}
            case 4 -> { return """
                                |-----
                                |   |
                                |  ( )
                                |   |
                                |   |
                                |
                                |______
                                """;}
            case 3 -> { return """
                                |-----
                                |   |
                                |  ( )
                                |  /|
                                |   |
                                |
                                |______
                                """;}
            case 2 -> { return """
                                |-----
                                |   |
                                |  ( )
                                |  /|\\
                                |   |
                                |
                                |______
                                """;}
            case 1 -> { return """
                                |-----
                                |   |
                                |  ( )
                                |  /|\\
                                |   |
                                |  /
                                |______
                                """;}
            case 0 -> { return """
                                |-----
                                |   |
                                | (×_×)
                                |  /|\\
                                |   |
                                |  / \\
                                |______
                                """;}
            } return "";
        }
}

// limit user entry to one character
// remove word from loaded list once someone wins and finds the word
// Add a difficulty level with different word length
// Create a list of theme
// add a menu where you can add words to the list