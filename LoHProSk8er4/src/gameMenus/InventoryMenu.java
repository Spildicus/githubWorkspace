package gameMenus;

import java.util.ArrayList;

import items.Equipment;
import items.Item;
import mainGameCode.GameController;
import mainGameCode.InputHandler;
import mainGameCode.Player;
import mainGameCode.TextHandler;

public class InventoryMenu extends Menu{

	private int pageNum;
	
	private Player player;
	private ArrayList<Equipment> equipment;
	private ArrayList<Item> misc;
	
	InventoryMenu()
	{
		super("Inventory");
		
		pageNum = 0;
		
		player = GameController.getPlayer();
		equipment = player.getBackpack().getEquipment();
		misc = player.getBackpack().getMisc();
	}
	
	public void update()
	{
		if(pageNum == 0)
		{
			setTitle("Inventory - Misc");
			displayTitle();
			
			int counter = 1;
			for (Item i : misc)
			{
				if(counter % 2 != 0)
					TextHandler.displayText("(" + counter + ") " + i.getName() + "\t");
				else
					TextHandler.displayText("(" + counter + ") " + i.getName() + "\n");
				counter++;
			}
			
			TextHandler.displayText("\n(" + counter + ") Back\n");
			
			int selection = InputHandler.getIntegerInput();
			
			if(selection == counter)
				GameController.exitMenu();
			else
				player.getBackpack().useItem(selection);
			
			//check if the player input a number that's displayed on the list
			
		}
		
		
		
	}
	
}
