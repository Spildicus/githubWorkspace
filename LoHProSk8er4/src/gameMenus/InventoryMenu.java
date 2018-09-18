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
	private String[] page = {"Equipment", "Misc"};
	
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
			setTitle("Inventory - Equipment");
			displayTitle();
			
			int counter = 1;
			for (Equipment eq : equipment)
			{
				if(counter % 2 != 0)
					TextHandler.displayText("(" + counter + ") " + eq.getName() + "\t");
				else
					TextHandler.displayText("(" + counter + ") " + eq.getName() + "\n");
				counter++;
			}

		}
		
		InputHandler.getInput();
		
	}
	
}
