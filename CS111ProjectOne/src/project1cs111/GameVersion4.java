/**
 * Kyle Dickson
 * 50116781
 * I pledge that this submission is solely my work, and that I have neither given, nor received help from anyone.
 */
package project1cs111;

public class GameVersion4 {
	
	/**
	 * Copy of game version 3 with a new room (PuzzleRoom) added.
	 * New room layout. The most straightforward layout. No loops.
	 * @param args
	 */
	public static void main(String args[]) {

        // designate how many rooms are in the game
        final int NUM_ROOMS = 6;

        // declare array of rooms
        Room[] gameBoard = new Room[NUM_ROOMS];

        // populate the room array, using the superclass Room and subclasses MonsterRoom and PuzzleRoom
        gameBoard[0] = new Room("First Room", "1 apple;pumpkin", 0, "e1;n2");
        gameBoard[1] = new Room("Lab Room", "2 laptops;barking Germany Shephard;angry instructor", 1, "s4;w0;e3");
        gameBoard[2] = new Room("Green Room", "meowing kitten;", 2, "s0;w5");
        gameBoard[3] = new Room("Space Room", "start;moon;spaceman", 3, "w3");
        gameBoard[4] = new MonsterRoom("Cute Kitten Room", "a cute kitten", 1, "n1");
        gameBoard[5] = new PuzzleRoom("Puzzle Room",  "A magic tablet inscribed with text", 5, "e2");
    
        // keep track of which room player is in 
        int playerRoomNumber = 0;

        // create CustomPlayer object, using the subclass CustomPlayer
        CustomPlayer player = new CustomPlayer("Git", playerRoomNumber, "piece of cake;hyperion;midas gem", 100, false);

        // play the game, as long as player object has field continuePlay set to true
        while (player.getContinuePlay() == true) {
        	
            playerRoomNumber = gameBoard[playerRoomNumber].playRoom(player);
        }
    }
}
