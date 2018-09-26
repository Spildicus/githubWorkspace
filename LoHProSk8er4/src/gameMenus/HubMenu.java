package gameMenus;

import mainGameCode.Enemy;
import mainGameCode.GameController;
import mainGameCode.InputHandler;
import mainGameCode.Player;
import mainGameCode.TextHandler;

public class HubMenu extends Menu{
	
	private Player player;
	
	HubMenu()
	{	
		super("Hub Menu");
		
		player = GameController.getPlayer();
		
	}
	
	public void update()
	{
		setTitle("Layer " + GameController.getLayer() + 
				"\n" + player.getName() + "\tLevel (" + player.getLevel() + ")" + 
				"\nHealth: " + player.getHealth() + " / " + player.getMaxHealth() + 
				"\nMana: " + player.getMana() + " / " + player.getMaxMana() + 
				"\nXP until next level: " + (player.getMaxXp() - player.getXp()));
		displayTitle();
		TextHandler.createNewList(new String[] {"Continue Journey", "Inventory", "Status", "Save and Exit"});
		setPlayerInput(InputHandler.getInput());
		if(getPlayerInput().contains("1")) GameController.addMenu(new FightMenu(new Enemy("Papa", 8, 350, 16), player)); //test fight scene
		if(getPlayerInput().contains("2")) GameController.addMenu(new InventoryMenu());; //open inventory menu
		if(getPlayerInput().contains("3")) GameController.addMenu(new StatusMenu()); //check character status
		if(getPlayerInput().contains("4")) saveAndExit(); //save and exit game
	}
	
	private void saveAndExit()
	{
		setTitle("Save and Exit");
		displayTitle();
		TextHandler.displayText("Are you sure you want to quit? (your game will be saved)\n");
		TextHandler.createNewList(new String[] {"Yes get me the fuck outta here", "no please I wanna play more of this shit"});
		setPlayerInput(InputHandler.getInput());
		if(getPlayerInput().contains("1")) GameController.setIsExit(true); //exit
		if(getPlayerInput().contains("2")) return; //continue game
	}
}
