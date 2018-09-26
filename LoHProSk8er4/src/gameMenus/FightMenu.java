package gameMenus;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import mainGameCode.Enemy;
import mainGameCode.GameController;
import mainGameCode.InputHandler;
import mainGameCode.Player;
import mainGameCode.TextHandler;

public class FightMenu extends Menu{

	Player player;
	Enemy enemy;
	
	Queue<Boolean> turns;
	
	double turnMultP;
	double turnMultE;
	
	//TRUE = Player's turn
	//FALSE = Enemy's turn
	boolean turnSwitch;
	
	FightMenu(Enemy enemy, Player player)
	{
		super("Fight Menu");
		
		this.enemy = enemy;
		this.player = player;
		
		turns = new LinkedList<Boolean>();
		
		turnMultP = 0;
		turnMultE = 0;
		turnSwitch = false;
	}
	
	public void update()
	{
		
		calculateTurns();
		
		setTitle("Layer " + GameController.getLayer() + 
				"\n" + player.getName() + "\tLevel (" + player.getLevel() + ")" + 
				"\nHealth: " + player.getHealth() + " / " + player.getMaxHealth() + 
				"\nMana: " + player.getMana() + " / " + player.getMaxMana() + 
				"\nXP until next level: " + (player.getMaxXp() - player.getXp()));
		displayTitle();
		TextHandler.displayText(enemy.getName() + " LV(" + enemy.getLevel() + ") HP: " + enemy.getHealth() + "/" + enemy.getMaxHealth() + "\n");
		
		TextHandler.createNewList(new String[] {"Attack", "Item", "Run"});
		setPlayerInput(InputHandler.getInput());
		if(getPlayerInput().contains("1")) attack();
		if(getPlayerInput().contains("2")) GameController.addMenu(new InventoryMenu());
		if(getPlayerInput().contains("3")) {
			if(playerRun())
			{
				TextHandler.displayText("You ran away!");
				GameController.exitMenu();
			}
			else 
			{
				TextHandler.displayText("You tried to run but your dumbass fell over and ate shit.");
				player.deductHealth(Math.round(player.getMaxHealth() * 0.05f)); //deal 5% of the players maximum health in damage
			}
		}
		
		//TODO: in GameController, add method to return player stats string to reduce redundancy
		//TODO: check if the enemy has died, if so, congratulate the player, give loot and XP, and exit menu, otherwise, continue
	}
	
	private void calculateTurns()
	{
		
		if(player.getLevel() != enemy.getLevel())
		{
			int difference = enemy.getLevel() - player.getLevel();
			if(difference > 0) 
			{
				turnMultE += (0.2 * difference);
				while(!(turnMultE-- >= 1))
					turns.add(false); //add enemy turn
			}
			else 
			{
				turnMultP += (0.2 * (-difference));
				while(!(turnMultP-- >= 1))
					turns.add(true); //add player turn
			}
		}
		
		turnSwitch = !turnSwitch;
		turns.add(turnSwitch);
		
	}
	
	private boolean playerRun()
	{
		int difference = enemy.getLevel() - player.getLevel();
		Random r = new Random();
		int chance = r.nextInt(100) + 1; //1 to 100
		return (chance >= 50 + (difference*3)) ? false : true;
	}
	
	private void attack() throws IllegalStateException
	{
		if(turns.isEmpty()) throw new IllegalStateException("Empty 'turns' queue");
		else 
		{
			if(!turns.poll())
			{
				enemy.deductHealth(player.getDamage());
				TextHandler.displayText("You dealt " + player.getDamage() + " to " + enemy.getName() + "\n");
			}
			else
			{
				player.deductHealth(enemy.getDamage());
				TextHandler.displayText(enemy.getName() + " hit you for " + enemy.getDamage() + " damage\n");
			}
		}
	}
	
}
