/* Plan:
Create a method that displays a flappy bird game window in the console
A method to shift the nested char arrays to the left by 1 position
Method to add pipes to the right of the array
Method to detect collisions with the pipes or the boundaries
Method to count the score
A method to handle the user input to move up or down
A method to display the score and the game over message

*/

// Imports
import java.util.Scanner;

public class FlappyBird {
    // method to display the flappy bird game window in the console
    public static void displayGameWindow(char[][] array) {
        System.out.println("Flappy Bird Game");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    // method to shift the nested char arrays to the left by 1 position
    public static void shiftLeft(char[][] array) {
        // take the current array and shift it to the left by 1 position
        // the right most column will be empty when we return
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length - 1; j++) {
                // Make the current column equal to the column on the left,
                // this will shift the column to the left by 1 position
                array[i][j] = array[i][j + 1];
            }
            // Make the right most column empty
            array[i][array[i].length - 1] = ' ';
        }
    }

    // method to add pipes to the right of the array
    public static void addPipes(char[][] array) {

    }

    // method to detect collisions with the pipes or the boundaries
    public static void detectCollisions(char[][] array) {
    }

    // method to count the score
    public static void countScore(char[][] array) {
    }

    // method to handle the user input to move up or down
    public static void handleUserInput(char[][] array) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("w")) {
            moveUp(array);
        } else if (input.equals("s")) {
            moveDown(array);
        } else if (input.equals("q")) {
            System.exit(0);
        }
    }

    // method to move the bird up
    public static void moveUp(char[][] array) {
    }

    // method to move the bird down
    public static void moveDown(char[][] array) {
    }

    // method to display the score and the game over message
    public static void displayScoreAndGameOverMessage(char[][] array) {
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}