package project1cs111;


import java.util.Scanner;

public class MonsterRoom extends Room{
	
	public MonsterRoom(String roomName, String objects, int roomNum, String listOfExits) {
		super(roomName, objects, roomNum, listOfExits);
		
	}

    public int playRoom(Player player) {
        return getNextRoom(player);
    }
    
    private int getNextRoom(Player player) {

        // inform the player of his/her current room
        System.out.println("You are in the " + getRoomName());
        System.out.println("What would you like to do?");

        // variables for player interaction
        String command;
        int newRoomNum = getRoomNum();
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
        kb.close();
        return newRoomNum;
    }
    
    protected void userPicksUp(Player player) {
        System.out.println("You see a cute kitten sitting in the middle of the floor\n"
        		+ "and you lean over to pick it up.\n"
        		+ "The kitten didn't like  that...  \n"
        		+ "You may or may not be missing a finger.");
        
        
    }

    // transfer item from user's inventory to room  
    
    protected void userDrops(Player player) {
        System.out.println("What would you like to drop?");
        Scanner keyboard = new Scanner(System.in);
        String itemToDrop = keyboard.nextLine();
        if (Utilities.isItemInContainer(itemToDrop, player.getInventory())) {
            player.removeFromInventory(itemToDrop);
            System.out.println("As the item hits the floor a swarm of beetles\n"
            		+ "scuttle over and whisk the item off in to \n"
            		+ "the void never to be seen again.");
        } else {
            System.out.println("You cannot drop something that you don't have");
        }
    }
    
    
    
}
