# Hangman Game

## Description
This is a console-based Hangman game written in Java.
The program loads words from a text file, randomly selects one, and allows the player to guess letters until they win or run out of chances.

The game keeps track of total wins and total games played.

## Features
- Random word selection from external file (WordList.txt)
- II Hangman visual representation
- Score tracking (wins / total games)
- Letter tracking (shows already tried letters)
- Replay option
- Clean console interaction

## Technologies
- Java
- BufferedReader
- FileReader
- ArrayList
- Scanner
- Java Switch Expressions
- Java Text Blocks (for ASCII art)

## How to Run
1. Clone the repo
2. Open in IntelliJ
3. Make sure WordList.txt is located inside the src folder.
4. Run Main.java

## How to Play

-	The game displays the number of letters in the word.
-	Type one letter and press Enter.
-	If the letter exists in the word, it will be revealed.
-	If not, you lose one life.
-	You have 7 chances.
-	The game ends when:
-	You guess the full word (Win 🎉)
-	You run out of chances (Lose 💀)
-	You can choose to continue playing after each game.

## Future Improvements

-	Add difficulty levels (easy / medium / hard)
-	Add word categories (animals, countries, etc.)
-	Prevent duplicate letter guesses
-	Remove guessed word from list after win
-	Add menu system
-   Add option for user to add their own words to the game
-	Convert to GUI version (JavaFX or Swing)
