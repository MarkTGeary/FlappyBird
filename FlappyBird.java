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
import java.util.Random;

public class FlappyBird {
    // class variables
    private static final int ARRAY_WIDTH = 25;
    private static final int ARRAY_HEIGHT = 15;
    private static final int PIPE_WIDTH = 1;
    private static final int GAP_BETWEEN_PIPES = 5;
    private static final int SPACE_FOR_BIRD = 4;

    private static int pipeCounter = 0;
    private static int score = 0;


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
        // Now we need to add a new column to the right of the array
        // this will either have pipes or nothing

        if (shouldAddPipes()) {
            addPipes(array);
        }
    }

    // method to determine if we should add pipes to the right of the array
    public static boolean shouldAddPipes() {
        if (pipeCounter - GAP_BETWEEN_PIPES >= 0) {
            pipeCounter = 0;
            return true;
        } else {
            pipeCounter++;
            return false;
        }
    }

    // method to add pipes to the right of the array
    public static void addPipes(char[][] array) {
        // add a pipe to the right of the array
        // It will be random but will have a space of 4
        Random random = new Random();
        
        // The random number is between 1 and 10 inclusive.
        // Whatever the number is, we put that many pipes on the top
        // then we have 4 blank spaces
        // and then the top pipe will be the rest of the spaces filled with a pipe
        int randomNumber = random.nextInt(10) + 1;

        for (int i = 0; i < randomNumber; i++) {
            array[i][array[i].length - 1] = '║';
        }
        for (int i = randomNumber + 1; i < randomNumber + SPACE_FOR_BIRD; i++) {
            array[i][array[i].length - 1] = ' ';
        }
        for (int i = randomNumber + SPACE_FOR_BIRD; i < array.length; i++) {
            array[i][array[i].length - 1] = '║';
        }
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
        System.out.println("Score: " + score);
        System.out.println("Game Over");
    }

    public static void main(String[] args) {
        // create the array
        char[][] array = new char[ARRAY_HEIGHT][ARRAY_WIDTH];
        // print the game window
        displayGameWindow(array);

        // Play the game
        while (true) {
            // shift the array to the left
            shiftLeft(array);

            // detect collisions with the pipes or the boundaries
            detectCollisions(array);
            // count the score
            countScore(array);
        }
    }
}