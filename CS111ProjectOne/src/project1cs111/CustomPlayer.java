package project1cs111;

import java.util.StringTokenizer;

public class CustomPlayer extends Player {
	
	private int healthPoints;
	private int attackDamage;
	private boolean hasWeapon;
	
	
	
    public CustomPlayer(String name, int room, String inventory, int healthPoints, boolean hasWeapon) {
        super(name, room, inventory);
        this.healthPoints = healthPoints;
        this.hasWeapon = hasWeapon;
        
        if (this.hasWeapon) {
    		this.attackDamage = 25;
    	}else {
    		this.attackDamage = 7;
    	}
    }
    
    // getter function to get listing of inventor
    @Override
    public void printInventory() {
        StringTokenizer strT = new StringTokenizer(getInventory(), ";");
        System.out.println(getName() + "'s items: ");
        int numItems = 0;
        while (strT.hasMoreTokens()) {
            System.out.println("  " + strT.nextToken());
            numItems++;
        }
        System.out.println("  A total of " + numItems + " item(s)");
        System.out.println("Your current health is " + this.healthPoints + ".");
        System.out.println("Your attack damage is " + this.attackDamage + ".");
        
        if (this.hasWeapon) {
        	System.out.println("You are carrying a weapon.");
        }else {
        	System.out.println("You are not carrying a weapon.");
        }
       
    }
    
    
}