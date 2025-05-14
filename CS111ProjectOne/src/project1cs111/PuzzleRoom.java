package project1cs111;

import java.util.Scanner;

public class PuzzleRoom extends Room{
	
	public PuzzleRoom(String roomName, String objects, int roomNum, String listOfExits, String puzzleAnswer) {
		super(roomName, objects, roomNum, listOfExits);
		
	}
	public int playRoom(Player player) {
        return this.getNextRoom(player);
    }
    
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
            case "puzzle":
            	runPuzzle();
            	break;
            default:
                System.out.println("Invalid command. Type help for details.");
        }
        //kb.close();
        return newRoomNum;
    }
    
    protected void runPuzzle() {
    	
    }
}
