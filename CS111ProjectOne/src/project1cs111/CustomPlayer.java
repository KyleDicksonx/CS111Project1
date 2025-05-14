/**
 * Kyle Dickson
 * 50116781
 * I pledge that this submission is solely my work, and that I have neither given, nor received help from anyone.
 */
package project1cs111;

import java.util.StringTokenizer;

public class CustomPlayer extends Player {
	
	/**The health points of the player*/
	private int healthPoints;
	/**The attack damage of the player*/
	private int attackDamage;
	/**Does the player have a weapon.*/
	private boolean hasWeapon;
	
	
	/**
	 * Non-default constructor. Calls the constructor of Player superclass and sets attack damage according to the hasWeapon instance field.
	 * @param name Name of the player.
	 * @param room Starting room number.
	 * @param inventory Contents of the players inventory
	 * @param healthPoints Starting health points of the player.
	 * @param hasWeapon Does the player have a weapon.
	 */
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
    
    /**
     * Getter method for the player's inventory.
     * Prints all of the players current items, the number of items, the player's current health, 
     * attack damage, and if the player is carrying a weapon.
     */
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
    
    /**
     * Getter method for the healthPoints instance field. 
     * @return healthPoints
     */
    public int getHealthPoints() {
    	return this.healthPoints;
    }
    /**
     * Setter method for the healthPoints instance field.
     * @param healthPoints
     */
    public void setHealthPoints(int healthPoints) {
    	this.healthPoints = healthPoints;
    }
    
    /**
     * Getter method for the attackDamage instance field.
     * @return attackDamage
     */
    public int getAttackDamage() {
    	return this.attackDamage;
    }
    /**
     * Setter method for the attack damage instance field.
     * @param attackDamage
     */
    public void setAttackDamage(int attackDamage) {
    	this.attackDamage = attackDamage;
    }
    
    /**
     * Getter method for the hasWeapon instance field.
     * @return hasWeapon
     */
    public boolean getHasWeapon() {
    	return this.hasWeapon;
    }
    /**
     * Setter method for the hasWeapon instance field.
     * @param hasWeapon
     */
    public void setHasWeapon(boolean hasWeapon) {
    	this.hasWeapon = hasWeapon;
    }
    
    
}