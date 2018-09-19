package mainGameCode;

import java.util.ArrayList;

import items.Equipment;
import items.Item;
import items.ItemCollection;

public class Backpack {
	
	//backpack
	private int maxSize;
	ArrayList<Equipment> equipment;
	private ArrayList<Item> misc;
	
	private ItemCollection itemCollection;
	
	Backpack(int maxSize)
	{
		this.maxSize = maxSize;
		
		equipment = new ArrayList<Equipment>(maxSize);
		misc = new ArrayList<Item>(maxSize);
		
		//initialize itemcollection, create an instance of each item to use on runtime
		itemCollection = new ItemCollection();
	}
	
	public boolean addItem(String name)
	{
		Item item = ItemCollection.getItemByName(name);
		
		if(item instanceof Equipment)
		{
			if(equipment.size() < maxSize)
			{
				equipment.add((Equipment) item);
				return true;
			}
			else TextHandler.displayText("Not enough space in inventory");
		}
		else if(misc.size() < maxSize)
		{
			misc.add(item);
			return true;
		}
		else TextHandler.displayText("Not enough space in inventory");
		return false;
	}
	
	public boolean removeItem(int index)
	{	
		if(index < misc.size() && index >= 0)
		{
			misc.remove(index);
			return true;
		}
		else
			return false;
	}
	
	public boolean removeEquipmentFromInventory(int index)
	{	
		if(index < equipment.size() && index >= 0)
		{
			equipment.remove(index);
			return true;
		}
		else
			return false;
	}
	
	public ArrayList<Equipment> getEquipment()
	{
		return equipment;
	}
	
	public ArrayList<Item> getMisc()
	{
		return misc;
	}
	
	public void useItem(int selection)
	{
		if(selection <= misc.size() && selection > 0)
		{
			itemCollection.useItem(misc.get(selection-1));
			//if the item was a consumable, delete it from inventory
			if(misc.get(selection-1).getType() == "Consumable") removeItem(selection-1);
		}
		else
			TextHandler.displayText("invalid input");
	}
	
	public void equipItem(int selection)
	{
		if(selection <= equipment.size() && selection > 0)
		{
			Equipment[] current = GameController.getPlayer().getEquipped();
			Equipment[] newSet = new Equipment[current.length];
			System.arraycopy(current, 0, newSet, 0, current.length);
			
			switch(equipment.get(selection-1).getType())
			{
			
			case "2H-Weapon":
				if(equipment.size() <= maxSize-2)
				{
					newSet[5] = equipment.get(selection-1);
					newSet[6] = new Equipment("EMPTY", 0, "", "OFFHAND", 0, 0, 0, 0, 0, 0);
					//add current weapons back into inventory
					if(current[5].getName() != "EMPTY") equipment.add(current[5]);
					if(current[6].getName() != "EMPTY") equipment.add(current[6]);
					//remove item that was equipped from inventory
					removeEquipmentFromInventory(selection-1);
				}
				break;
				
			case "1H-Weapon":
				
				//ask player which hand they want to equip to
				TextHandler.displayText("Where would you like to equip this to?\n" + 
				"(1) Main Hand\n(2) Off Hand\n");
				
				int input;
				boolean done = false;
				
				do
				{
					input = InputHandler.getIntegerInput();
					
					if(input == 1) 
					{
						newSet[5] = equipment.get(selection-1);
						if(current[5].getName() != "EMPTY") equipment.add(current[5]);
						removeEquipmentFromInventory(selection-1);
						done = true;
					}
					else if (input == 2)
					{
						newSet[6] = equipment.get(selection-1);
						if(current[6].getName() != "EMPTY") equipment.add(current[6]);
						removeEquipmentFromInventory(selection-1);
						done = true;
					}
				}while(!done);
				break;
				
			case "Head":
				newSet[0] = equipment.get(selection-1);
				if(current[0].getName() != "EMPTY") equipment.add(current[0]);
				removeEquipmentFromInventory(selection-1);
				break;
				
			case "Torso":
				newSet[1] = equipment.get(selection-1);
				if(current[1].getName() != "EMPTY") equipment.add(current[1]);
				removeEquipmentFromInventory(selection-1);
				break;
				
			case "Arms":
				newSet[2] = equipment.get(selection-1);
				if(current[2].getName() != "EMPTY") equipment.add(current[2]);
				removeEquipmentFromInventory(selection-1);
				break;
				
			case "Legs":
				newSet[3] = equipment.get(selection-1);
				if(current[3].getName() != "EMPTY") equipment.add(current[3]);
				removeEquipmentFromInventory(selection-1);
				break;
				
			case "Feet":
				newSet[4] = equipment.get(selection-1);
				if(current[4].getName() != "EMPTY") equipment.add(current[4]);
				removeEquipmentFromInventory(selection-1);
				break;
				
				default:
					TextHandler.displayText("Equipment of type " + equipment.get(selection-1).getType() + " does not exist.");
			}
			
			GameController.getPlayer().setEquipped(newSet);
			
		}
	}
	
}
