package gameMenus;

import items.Equipment;
import mainGameCode.GameController;
import mainGameCode.InputHandler;
import mainGameCode.Player;
import mainGameCode.TextHandler;

public class StatusMenu extends Menu{
	
	Player player;
	Equipment[] equipment;
	
	StatusMenu()
	{
		super("Status");
		
		player = GameController.getPlayer();
		equipment = player.getEquipped();
	}
	
	public void update()
	{
		displayTitle();
		
		TextHandler.displayText("Head: " + equipment[0].getName() + "\n");
		TextHandler.displayText("Torso: " + equipment[1].getName() + "\n");
		TextHandler.displayText("Arms: " + equipment[2].getName() + "\n");
		TextHandler.displayText("Legs: " + equipment[3].getName() + "\n");
		TextHandler.displayText("Feet: " + equipment[4].getName() + "\n");
		TextHandler.displayText("Weapon: " + equipment[5].getName() + "\n");
		TextHandler.displayText("Offhand: " + equipment[6].getName() + "\n");
		
		InputHandler.getInput();
	}

}
