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
    private static boolean justScoredForPipe = false;  // Track if we just scored


    // method to clear the console
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // If clearing fails, just print some newlines
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    // method to display the flappy bird game window in the console
    public static void displayGameWindow(char[][] array) {
        System.out.println("Flappy Bird Game - Score: " + score);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    // method to initialise the array with spaces
    public static void initialiseArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = ' ';
            }
        }
    }

    // method to initialise the bird
    public static void initialiseBird(char[][] array) {
        // the bird is represented by a 'o'
        // put it in the middle on the left of the array
        array[array.length / 2][0] = 'o';

    }

    // method to shift the nested char arrays to the left by 1 position
    public static void shiftLeft(char[][] array) {
        // First, find and save the bird's row position
        int birdRow = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] == 'o') {
                birdRow = i;
                break;
            }
        }
        
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
        
        // Restore the bird to column 0 at its saved row position
        if (birdRow != -1) {
            array[birdRow][0] = 'o';
        }
        
        // Now we need to add a new column to the right of the array
        // this will either have pipes or nothing

        if (shouldAddPipes()) {
            addPipes(array);
        }
    }

    // method to determine if we should add pipes to the right of the array
    public static boolean shouldAddPipes() {
        pipeCounter++;
        if (pipeCounter > GAP_BETWEEN_PIPES) {
            pipeCounter = 0;
            return true;
        }
        return false;
    }

    // method to add pipes to the right of the array
    public static void addPipes(char[][] array) {
        // add a pipe to the right of the array
        // It will be random but will have a space of 4
        Random random = new Random();
        
        // The random number determines where the gap starts
        // Make sure the gap doesn't go beyond the array bounds
        int maxStart = array.length - SPACE_FOR_BIRD;
        int randomNumber = random.nextInt(maxStart);

        // Top pipes (from 0 to randomNumber-1)
        for (int i = 0; i < randomNumber; i++) {
            array[i][array[i].length - 1] = '║';
        }
        // Gap for the bird (from randomNumber to randomNumber + SPACE_FOR_BIRD - 1)
        for (int i = randomNumber; i < randomNumber + SPACE_FOR_BIRD; i++) {
            array[i][array[i].length - 1] = ' ';
        }
        // Bottom pipes (from randomNumber + SPACE_FOR_BIRD to end)
        for (int i = randomNumber + SPACE_FOR_BIRD; i < array.length; i++) {
            array[i][array[i].length - 1] = '║';
        }
    }

    // method to detect collisions with the pipes or the boundaries
    public static boolean detectCollisions(char[][] array) {
        // Find the bird's position
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 'o') {
                    // Check if bird hit top or bottom boundary
                    if (i == 0 || i == array.length - 1) {
                        return true;  // Collision detected
                    }
                    // Check if bird hit a pipe (check the next column to the right)
                    if (j + 1 < array[i].length && array[i][j + 1] == '║') {
                        return true;  // Collision detected
                    }
                    return false;  // No collision
                }
            }
        }
        return false;
    }

    // method to count the score
    public static void countScore(char[][] array) {
        // Find the bird's position
        int birdRow = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] == 'o') {
                birdRow = i;
                break;
            }
        }
        
        if (birdRow == -1) return;
        
        // Check if there's a pipe in column 1 (bird is currently passing through)
        boolean pipeInColumn1 = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i][1] == '║') {
                pipeInColumn1 = true;
                break;
            }
        }
        
        // If there's a pipe in column 1 and bird is in the gap
        if (pipeInColumn1 && array[birdRow][1] == ' ') {
            // Check if bird is in a gap (has pipes above and below in column 1)
            boolean pipeAbove = false;
            boolean pipeBelow = false;
            
            for (int i = 0; i < birdRow; i++) {
                if (array[i][1] == '║') {
                    pipeAbove = true;
                    break;
                }
            }
            for (int i = birdRow + 1; i < array.length; i++) {
                if (array[i][1] == '║') {
                    pipeBelow = true;
                    break;
                }
            }
            
            // If bird is in a gap and we haven't scored for this pipe yet
            if (pipeAbove && pipeBelow && !justScoredForPipe) {
                score++;
                justScoredForPipe = true;  // Mark that we scored for this pipe
            }
        } else if (!pipeInColumn1) {
            // No pipe in column 1, reset the flag for next pipe
            justScoredForPipe = false;
        }
    }

    // method to handle the user input to move up or down
    public static void handleUserInput(char[][] array) {
        Scanner scanner = new Scanner(System.in);
        // We need the input to stay on the same line so we don't get a new line character
        // enters should stay on the same line from the user
        //System.out.print("\r");
        
        String input = scanner.next();
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
        // move the bird up by 1 position
        // the bird is represented by a 'o'
        // we need to find the 'o' in the array and move it up by 1 position
        // the bird will stay on the left most column
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 'o') {
                    array[i][j] = ' ';
                    if (i > 0) {  // Check boundary
                        array[i - 1][j] = 'o';
                    } else {
                        array[i][j] = 'o';  // Keep bird in place if at top
                    }
                    return;  // Exit after moving the bird once
                }
            }
        }
    }

    // method to move the bird down
    public static void moveDown(char[][] array) {
        // move the bird down by 1 position
        // the bird is represented by a 'o'
        // we need to find the 'o' in the array and move it down by 1 position
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 'o') {
                    array[i][j] = ' ';
                    if (i < array.length - 1) {  // Check boundary
                        array[i + 1][j] = 'o';
                    } else {
                        array[i][j] = 'o';  // Keep bird in place if at bottom
                    }
                    return;  // Exit after moving the bird once
                }
            }
        }
    }

    // method to display the score and the game over message
    public static void displayScoreAndGameOverMessage(char[][] array) {
        System.out.println("Score: " + score);
        System.out.println("Game Over");
    }

    public static void main(String[] args) {
        // create the array
        char[][] array = new char[ARRAY_HEIGHT][ARRAY_WIDTH];

        // initialise the array with spaces
        initialiseArray(array);
        
        // initialise the bird
        initialiseBird(array);

        // Play the game
        while (true) {
            // Clear console first for smooth animation
            clearConsole();
            
            // Display the game state
            displayGameWindow(array);
            System.out.println("Press 'w' to move up, 's' to move down, 'q' to quit");
            System.out.print("Enter your input: ");

            // Handle user input
            handleUserInput(array);
            
            // Shift the array to the left (world moves)
            shiftLeft(array);
            
            // Detect collisions
            if (detectCollisions(array)) {
                clearConsole();
                displayGameWindow(array);
                displayScoreAndGameOverMessage(array);
                break;  // End the game
            }
            
            // Count the score
            countScore(array);
        }
    }
}