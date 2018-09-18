package items;

import java.util.ArrayList;

import mainGameCode.GameController;
import mainGameCode.TextHandler;

public class ItemCollection {

	private static ArrayList<Item> itemCollections = new ArrayList<Item>();
	
	//initialize all item entities in the game
	public ItemCollection()
	{
		//master list of all consumable/miscellaneous items in the game
		//sorted by NAME, VALUE, DESCRIPTION
		/*
		 * master list of all consumable/miscellaneous items in the game
		 * 
		 * to add a new item to the game, add the item to the itemCollections, and if it is a consumable,
		 * add the effect to the useItem method in the switch statement. If it has no effect, don't add anything.
		 * 
		 * sorted by NAME, VALUE, DESCRIPTION
		 */
		itemCollections.add(new Item("Polar Pop", 1, "Do you ever drink water?"));
		itemCollections.add(new Item("Klondike Bar", 20, "What would you do for this?"));
	}
	
	//search and return an item from the item collection
	public Item getItemByName(String name)
	{
		for(Item i : itemCollections)
		{
			if(i.getName() == name)
				return i;
		}
		return null;
	}
	
	/*
	 * Idea here is that when a player 'uses' an item, the game controller or inventory menu will
	 * call this function, with the item they've selected as the argument,
	 * the function will execute the ability(s) of the consumable used, and the gamecontroller or inventory
	 * will deduct the item from the inventory
	 */
	public void useItem(Item i)
	{
		String name = i.getName();
		
		switch(name)
		{
		case "Polar Pop":
			GameController.getPlayer().addHealth(30);
			TextHandler.displayText("Mmm, tastes like root beer. You restored 30 HP.");
			break;
		case "Klondike Bar":
			GameController.getPlayer().addHealth(50);
			TextHandler.displayText("What would you dooOOOoooo, for a klondike bar? Ha. You restored 50 HP.");
			break;
			default:
				TextHandler.displayText("There is no use for " + name + ".");
		}
	}
	
}
