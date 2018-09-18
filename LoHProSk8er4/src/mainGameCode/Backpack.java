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
		Item item = itemCollection.getItemByName(name);
		
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
			removeItem(selection-1);
		}
		else
			TextHandler.displayText("invalid input");
	}
	
}
