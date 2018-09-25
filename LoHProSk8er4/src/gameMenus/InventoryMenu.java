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
		//used to label available selections
		int counter = 1;
		
		if(pageNum == 0)
		{
			setTitle("Inventory - Misc");
			displayTitle();
			
			for (Item i : misc)
			{
				if(counter % 2 != 0)
					TextHandler.displayText("(" + counter + ") " + i.getName() + "\t");
				else
					TextHandler.displayText("(" + counter + ") " + i.getName() + "\n");
				counter++;
			}
			
			TextHandler.displayText("\n(" + counter + ") Exit Inventory\t(" + ++counter + ") Next Page\n");
			
		}
		
		else if(pageNum == 1)
		{
			setTitle("Inventory - Equipment");
			displayTitle();

			for (Item i : equipment)
			{
				if(counter % 2 != 0)
					TextHandler.displayText("(" + counter + ") " + i.getName() + "\t");
				else
					TextHandler.displayText("(" + counter + ") " + i.getName() + "\n");
				counter++;
			}
			
			TextHandler.displayText("\n(" + counter + ") Exit Inventory\t(" + ++counter + ") Next Page\n");
			
		}
		
		int selection = InputHandler.getIntegerInput();
		
		//if selection was exit inventory button
		if(selection == counter-1)
		{
			GameController.exitMenu();
		}
		//else if the selection was the next button
		else if(selection == counter)
		{
			if(pageNum == 0) pageNum = 1;
			else pageNum = 0;
		}
		else
		{
			if(pageNum == 0) player.getBackpack().useItem(selection);
			else player.getBackpack().equipItem(selection);
		}
	}
	
}
