
// Import the scanner class to access its method.
import java.util.Scanner;
public class stoneGame {
    public static void main(String[] args) {
        System.out.println("\nWELCOME TO THE STONE GAME🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳\n" +
                "The winner will be a player with an ODD number of stones. Good Luck!!");
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println("START GAME👍");
        // allow the scanner class to accept input from users
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a positive odd number of stones to start: ");
        int numStone = input.nextInt(); // Store the user input into a variable called numStone

        //  repeatedly ask the user for Number of stones, if the stones entered was even or less than 1
        while (true) {
            if (numStone < 0 || numStone % 2 == 0) {
                System.out.println("OOps👾👾! The number must be odd: ");
                numStone = input.nextInt();
                // breaks the loop and continue from the next line if odd number is entered
            } else {
                break;
            }
        }
        input.nextLine();
        // set the number of stones each player has and the stones left to the total stones
        int firstPlayerStones = 0, secondPlayerStones = 0,numStonesLeft = numStone;
        System.out.println("Player1: Enter your name: ");
        String firstName = input.nextLine(); // store the first input to the firstName variable as a string
        System.out.println("Player2: Enter your name: ");
        String secondName = input.nextLine(); //store the next input to the firstName variable as a string

        // initialize the number of stones picked
        int playerPick = 0;
        System.out.println(firstName + " has " + firstPlayerStones + " stones");
        System.out.println(secondName + " has " + secondPlayerStones + " stones");
        System.out.println("There are " + numStonesLeft + " stones to start with ");

        // Accept number of stones from the first player
        do {
            System.out.println(firstName + ", Enter a number of stone from 1-" + numStonesLeft / 2);
            playerPick = input.nextInt();
            // repeatedly ask the user to input the number conditions not satisfied
        } while (playerPick <= 0 || playerPick > numStonesLeft / 2);
        firstPlayerStones += playerPick; // update the value of the firstplayer
        numStonesLeft -= playerPick; // subtract the number of stones from the number of stones left

        while (numStonesLeft > 0) {   // repeatedly allow different players to take turns
            System.out.println(firstName + " has " + firstPlayerStones + " stones");
            System.out.println(secondName + " has " + secondPlayerStones + " stones");
            System.out.println("There are " + numStonesLeft + " stones left");

            // calculate the maximum limit a player can select up to
            int limit = 0;
            if (2 * playerPick > numStonesLeft) {
                limit = numStonesLeft;
            } else {
                limit = 2 * playerPick;
            }

                 //allow second player to also select stones
                do {
                    System.out.println(secondName + ", Enter a number of stone from 1-" + limit);
                    playerPick = input.nextInt();
                } while (playerPick <= 0 || playerPick > limit);
                secondPlayerStones += playerPick;// update the number of stones second player has
                numStonesLeft -= playerPick;// update the number of stones left

                System.out.println(firstName + " has " + firstPlayerStones + " stones");
                System.out.println(secondName + " has " + secondPlayerStones + " stones");
                System.out.println("There are " + numStonesLeft + " stones left");

            // break the code whenever the number of stones left is 0
            if (numStonesLeft == 0) {
                break;
            }
                // check the maximum limit that second player can pick
                if (2 * playerPick > numStonesLeft) {
                    limit = numStonesLeft;
                } else {
                    limit = 2 * playerPick;
                }

                do {
                    System.out.println(firstName + ", Enter a number of stone from 1-" + limit);
                    playerPick = input.nextInt();
                } while (playerPick <= 0 || playerPick > limit);
                numStonesLeft -= playerPick;
                firstPlayerStones += playerPick;

                // break the code whenever the number of stones left is 0
            if (numStonesLeft == 0) {
                break;
            }
        }
        input.close();// close the scanner to prevent source leak

        // check the player with odd number of stones and announce as winner
        if (firstPlayerStones % 2 != 0) {
            System.out.println("\n" + firstName + " has won with " + firstPlayerStones + " stones🎉🎉");
        } else {
            System.out.println("\n" + secondName + " has won with " + secondPlayerStones + " stones🎉🎉");
        }
    }
}



