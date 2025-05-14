/**
 * Kyle Dickson
 * 50116781
 * I pledge that this submission is solely my work, and that I have neither given, nor received help from anyone.
 */


package project1cs111;

//imports
import java.util.Scanner;

public class PuzzleRoom extends Room{
	
	/**
	 * Calls the constructor of the superclass Room
	 * @param roomName The name of the room.
	 * @param objects The objects in the room.
	 * @param roomNum The room number. 
	 * @param listOfExits A list of exits.
	 */
	public PuzzleRoom(String roomName, String objects, int roomNum, String listOfExits) {
		super(roomName, objects, roomNum, listOfExits);
		
	}
	
	/**
	 * Calls the getNextRoom method.
	 * @param The player object
	 * @return the next room number for the player. 
	 */
	@Override
	public int playRoom(Player player) {
        return this.getNextRoom(player);
    }
	
	/**
	 * Calls the getNextRoom method.
	 * @param The CustomPlayer object
	 * @return the next room number for the player. 
	 */
	@Override
	public int playRoom(CustomPlayer player) {
        return this.getNextRoom(player);
    }
	
	/**
	 * Handles the players input and calls other methods accordingly
	 * @param player
	 * @return the next room num for the player
	 */
    private int getNextRoom(Player player) {

        // inform the player of his/her current room
        System.out.println("You are in the " + getRoomName());
        System.out.println("What would you like to do?");
        System.out.println("SPECIAL ACTION! Type \"puzzle\" to interact with the puzzle.");

        // variables for player interaction
        String command;
        int newRoomNum = getRoomNum();
        @SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
        
        command = kb.nextLine();  

        // switch on the user's command
        switch (command) {
            case "exits":
                printListOfExits();
                break;
            case "look":
                printObjectsInRoom();
                break;
            case "inventory":
                player.printInventory();
                break;
            case "go west":
            case "go east":
            case "go south":
            case "go north":
                newRoomNum = leaveRoom(command);
                break;
            case "quit":
                player.setContinuePlay(false);
                break;
            case "pick up":
                userPicksUp(player);
                break;
            case "drop":
                userDrops(player);
                break;
            case "help":
                Utilities.printHelp();
                break;
            case "puzzle":
            	runPuzzle();
            	break;
            default:
                System.out.println("Invalid command. Type help for details.");
        }
        //kb.close();
        return newRoomNum;
    }
    
    /**
     * This method runs the puzzle. It asks the question "This statement is false"
     * and asks the user if the statement is true. It will always print "Correct!".
     * There is no puzzle  logic, just a mind game.
     */
    protected void runPuzzle() {
    	
    	@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
    	System.out.println("\"This statement is false.\"");
    	System.out.println("Is the above statement true: ");
    	
    	//any and all input accepted 
    	kb.nextLine();
    	
    	System.out.println("Correct!");
    	
    	//kb.close();
    }
}
