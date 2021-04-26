

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//System objects
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		
		//Game variables
		String[] enemies = {"Pikachu", "Squirtle", "Charmander", "Bulbasaur" };
		int maxEnemyHealth = 75;
		int enemyAttackDamage = 25;
		
		//Player variables
		int health = 100;
		int attackDamage = 50;
		int numHealthPotions = 5;
		int healthPotionHealAmount = 30;
		int healthPotionDropChance = 50; //Percentage
		
		boolean running = true;
		System.out.println();
		System.out.println();
		System.out.println("POKEMON GENERATIONS");
		System.out.println("-------------------");
		System.out.println();
		System.out.println("Welcome to the Kanto Region!");
		
		GAME:
		while(running) {
			System.out.println("---------------------------------------------------------------");
			
			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# " + enemy + " has appeared! #\n");
			
			while(enemyHealth > 0) {
				System.out.println("\tYour Greninja's HP: " + health);
				System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink health potion");
				System.out.println("\t3. Run!");
				
				String input = in.nextLine();
				if(input.equals("1")) {
					int damageDealt = rand.nextInt(attackDamage);
					int damageTaken = rand.nextInt(enemyAttackDamage);
					
					enemyHealth -= damageDealt;
					health -= damageTaken;
					
					System.out.println("\t> Your attacked " + enemy + " for " + damageDealt + " damage. It was super effective! ");
					System.out.println("\t> You receive " + damageTaken + " in retaliation!");
					
					if(health < 1) {
						System.out.println("\t> You have taken too much damage, you have no more Pokemon left, you are too weak to go on!");
						break;
					}
					
				}
				else if(input.equals("2")) {
					if(numHealthPotions > 0) {
						health += healthPotionHealAmount;
						numHealthPotions--;
						System.out.println("\t> You used a health potion, healing your Pokemon for " + healthPotionHealAmount + "."
										+ "\n\t> You now have " + health + " HP. "
										+ "\n\t> You have " + numHealthPotions + " health potions left.\n");
					}
					else {
						System.out.println("\t> You have no more health potions left! Defeat enemies for a chance to get one!");
					}
				}
				else if(input.equals("3")) {
					System.out.println("\tYou ran away from  " + enemy + "!");
					continue GAME;
				}
				else {
					System.out.println("\tInvalid command! ");
				}
			}
			
			if(health < 1) {
				System.out.println("You lost the fight! You ran back to the Pokemon Center.");
				break;
			}
			
			System.out.println("---------------------------------------------------------------");
			System.out.println(" # " + enemy + " was defeated! # ");
			System.out.println(" # You have " + health + " HP left. #");
			if(rand.nextInt(100) < healthPotionDropChance) {
				numHealthPotions++;
				System.out.println(" # The " + enemy + " dropped a health potion! # ");
				System.out.println(" # You now have " + numHealthPotions + " health potion(s). # ");
			}
			System.out.println("---------------------------------------------------------------");
			System.out.println("What would you like to do now?");
			System.out.println("1. Continue fighting in the wild");
			System.out.println("2. Exit the wild");
			
			String input = in.nextLine();
			
			while(!input.equals("1") && !input.equals("2")) {
				System.out.println("Invalid Command!");
				input = in.nextLine();
			}
			
			if(input.equals("1") ) {
				System.out.println("You contine you on your adventure!");
			}
			else if(input.equals("2")) {
				System.out.println("You exited the wilderness, successful from your adventures!");
				break;
			}
			
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		//Blank space for used for Credits:
		System.out.println("#######################");
		System.out.println("# THANKS FOR PLAYING! #");
		System.out.println("#######################");
		System.out.println();
		System.out.println("#######################");
		System.out.println("##### CREATED BY ######");
		System.out.println("### CHRISTIAN PHAN ####");
		System.out.println("#######################");

	}
	
	
	
	
	
}
