/**
 * Kyle Dickson
 * 50116781
 * I pledge that this submission is solely my work, and that I have neither given, nor received help from anyone.
 */
package project1cs111;

//imports
import java.util.Scanner;

public class MonsterRoom extends Room{
	
	/**
	 * Non-Default constructor. Calls the constructor of the superclass Room
	 * @param roomName The name of the room.
	 * @param objects The objects in the room.
	 * @param roomNum The room number. 
	 * @param listOfExits A list of exits.
	 */
	public MonsterRoom(String roomName, String objects, int roomNum, String listOfExits) {
		super(roomName, objects, roomNum, listOfExits);
		
	}
	
	
	/**
	 * This method returns the getNextRoom method that holds the bulk of the game action choice logic.
	 * @return the next room number for the player. 
	 */
    public int playRoom(Player player) {
        return this.getNextRoom(player);
    }
    
    /**
     * This method check the players input and calls other methods accordingly. 
     * @param player object
     * @return the new room number for the player to move to if they move.
     */
    private int getNextRoom(Player player) {

        // inform the player of his/her current room
        System.out.println("You are in the " + getRoomName());
        System.out.println("What would you like to do?");

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
            default:
                System.out.println("Invalid command. Type help for details.");
        }
        //kb.close();
        return newRoomNum;
    }
    
    
    /**
     * Prints only dialog and removes all functionality found in the overridden method. 
     * @param The player object
     */
    protected void userPicksUp(Player player) {
        System.out.println("You see a cute kitten sitting in the middle of the floor\n"
        		+ "and you lean over to pick it up.\n"
        		+ "The kitten didn't like  that...  \n"
        		+ "You may or may not be missing a finger.");
        
        
    }

    /**
     * transfer item from user's inventory to room.
     * Items dropped in this room are erased/unable to be picked up.
     * @param The player object
     */
    protected void userDrops(Player player) {
        System.out.println("What would you like to drop?");
        @SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
        String itemToDrop = kb.nextLine();
        
        //item is removed from the inventory and is gone forever
        if (Utilities.isItemInContainer(itemToDrop, player.getInventory())) {
            player.removeFromInventory(itemToDrop);
            System.out.println("As the item hits the floor a swarm of beetles\n"
            		+ "scuttle over and whisk the item off in to \n"
            		+ "the void never to be seen again.");
        } else {
            System.out.println("You cannot drop something that you don't have");
        }
        //kb.close();
    }
    
    
    
}
