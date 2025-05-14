/**
 * Kyle Dickson
 * 50116781
 * I pledge that this submission is solely my work, and that I have neither given, nor received help from anyone.
 */
package project1cs111;

public class GameVersion3 {
	
	/**
	 * Copy of game version 2 with CustomPlayer replacing the Player object. 
	 * There is also a new room layout.
	 * @param args
	 */
	public static void main(String args[]) {

        // designate how many rooms are in the game
        final int NUM_ROOMS = 5;

        // declare array of rooms
        Room[] gameBoard = new Room[NUM_ROOMS];

        // populate the room array, using the superclass Room
        
        gameBoard[0] = new Room("Space Room", "start;moon;spaceman", 0, "s1;e2;w0;n4");
        gameBoard[1] = new MonsterRoom("Cute Kitten Room", "a cute kitten", 1, "s2;e3;w1;n0");
        gameBoard[2] = new Room("Green Room", "meowing kitten;", 2, "s3;e4;w2;n1");
        gameBoard[3] = new Room("Lab Room", "2 laptops;barking Germany Shephard;angry instructor", 3, "s4;e0;w3;n2");
        gameBoard[4] = new Room("First Room", "1 apple;pumpkin", 4, "s0;e4;w1;n3");
        

        // keep track of which room player is in 
        int playerRoomNumber = 0;

        // create CustomPlayer object, using the subclass CustomPlayer
        CustomPlayer player = new CustomPlayer("Mark", playerRoomNumber, "slice of pizza;football;sunglasses", 100, true);

        // play the game, as long as player object has field continuePlay set to true
        while (player.getContinuePlay() == true) {
        	
            playerRoomNumber = gameBoard[playerRoomNumber].playRoom(player);
        }
    }
}
