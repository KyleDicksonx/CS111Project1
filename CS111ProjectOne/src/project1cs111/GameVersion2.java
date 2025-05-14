/**
 * Kyle Dickson
 * 50116781
 * I pledge that this submission is solely my work, and that I have neither given, nor received help from anyone.
 */
package project1cs111;

public class GameVersion2 {
	
	
	/**
	 * The main method for GameVersion2.
	 * This is a copy of the example game with the added MonsterRoom and 
	 * a new room layout
	 * @param args
	 */
	public static void main(String args[]) {

        // designate how many rooms are in the game
        final int NUM_ROOMS = 5;

        // declare array of rooms
        Room[] gameBoard = new Room[NUM_ROOMS];

        // populate the room array, using the superclass Room
        gameBoard[0] = new Room("First Room", "1 apple;pumpkin", 0, "e1;w2;s3");
        gameBoard[1] = new Room("Lab Room", "2 laptops;barking Germany Shephard;angry instructor", 1, "w0;e2;n4");
        gameBoard[2] = new Room("Green Room", "meowing kitten;", 2, "w1;e0");
        gameBoard[3] = new Room("Space Room", "start;moon;spaceman", 3, "w0;n2;s4");
        gameBoard[4] = new MonsterRoom("Cute Kitten Room", "a cute kitten", 4, "s1;n3");

        // keep track of which room player is in 
        int playerRoomNumber = 0;

        // create player object, using the superclass Player
        Player player = new Player("Mark", playerRoomNumber, "slice of pizza;football;sunglasses");

        // play the game, as long as player object has field continuePlay set to true
        while (player.getContinuePlay() == true) {
            playerRoomNumber =
                    gameBoard[playerRoomNumber].playRoom(player);
        }
    }
}
