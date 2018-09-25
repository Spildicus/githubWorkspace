package items;

import java.util.ArrayList;

import mainGameCode.GameController;
import mainGameCode.Player;
import mainGameCode.TextHandler;

public class ItemCollection {

	private static ArrayList<Item> itemCollections = new ArrayList<Item>();
	private static ArrayList<Equipment> equipmentCollections = new ArrayList<Equipment>();
	
	//initialize all item entities in the game
	public ItemCollection()
	{
		/*
		 * master list of all consumable/miscellaneous items in the game
		 * 
		 * to add a new item to the game, add the item to the itemCollections, and if it is a consumable,
		 * add the effect to the useItem method in the switch statement. If it has no effect, don't add anything.
		 * 
		 * sorted by NAME, VALUE, DESCRIPTION, TYPE
		 */
		
		//CONSUMABLES
		itemCollections.add(new Item("Polar Pop", 1, "Do you ever drink water?", "Consumable"));
		itemCollections.add(new Item("Klondike Bar", 20, "What would you do for this?", "Consumable"));
		itemCollections.add(new Item("Big tiddy goth GF", 666, "Vore.", "Consumable"));
		
		//MISC, i.e. NO STATUS EFFECT
		itemCollections.add(new Item("Sippy Cup", 9, "Somebody otta get their child their sippy cup back.", "Misc"));
		
		/*
		 * master list of equipment items in the game
		 * 
		 * same as above
		 * 
		 * sorted by NAME, VALUE, DESCRIPTION, TYPE, DAMAGE, DEFENSE, VITALITY, INTELLIGENCE, STRENGTH, WISDOM
		 */
		
		//2H-WEAPONS
		equipmentCollections.add(new Equipment("A Big Boy's Sword", 69, "A two- handed sword for a big boy like you... You're growing up so fast!", "2H-Weapon", 10, 0, 0, 0, 0, 0));
		
		//1H-WEAPONS
		equipmentCollections.add(new Equipment("Red Copper Pan", 300, "Hey there mothafuckas it's ya girl cathy, I got some brand new shit", "1H-Weapon", 250, 0, 25, 3, 25, 3));
		
		//HEAD
		equipmentCollections.add(new Equipment("Broken Helmet", 1, "Leather helmet broken from thousands of years of war and abuse", "Head", 0, 3, 0, 0, 0, 0));
		
		//TORSO
		equipmentCollections.add(new Equipment("Bloodied Tunic", 1, "Tunic covered in your own blood, you can see your wounds through its holes", "Torso", 0, 2, 0, 0, 0, 0));
		
		//ARMS
		equipmentCollections.add(new Equipment("Torn Gloves", 1, "Gloves so torn they hardly protect your hands", "Arms", 0, 1, 0, 0, 0, 0));
		
		//LEGS
		equipmentCollections.add(new Equipment("Muddy Pants", 1, "Cloth pants soiled in mud", "Legs", 0, 2, 0, 0, 0, 0));
		
		//FEET
		equipmentCollections.add(new Equipment("Worn Boot", 1, "A boot with a hole in it, but where is the other one?", "Feet", 0, 1, 0, 0, 0, 0));
	}
	
	//search and return an item from the item collection
	public static Item getItemByName(String name)
	{
		for(Item i : itemCollections)
		{
			if(i.getName() == name)
				return i;
		}
		for(Equipment equ : equipmentCollections)
		{
			if(equ.getName() == name)
				return equ;
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
		Player player = GameController.getPlayer();
		
		switch(name)
		{
		case "Polar Pop":
			player.addHealth(30);
			TextHandler.displayText("Mmm, tastes like root beer. You restored 30 HP.");
			break;
			
		case "Klondike Bar":
			player.addHealth(50);
			TextHandler.displayText("What would you dooOOOoooo, for a klondike bar? Ha. You restored 50 HP.");
			break;
			
		case "Big tiddy goth GF":
			player.setHealth(player.getMaxHealth());
			player.setMana(player.getMaxMana());
			player.setXp(player.getMaxXp());
			TextHandler.displayText("Very scrumptious. You have regained all life and mana, and have even gained a new level");
			break;
			
			default:
				TextHandler.displayText("There is no use for " + name + ".");
		}
	}
	
}
