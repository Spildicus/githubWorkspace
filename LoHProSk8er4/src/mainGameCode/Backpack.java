package mainGameCode;

import java.util.ArrayList;

import items.Equipment;
import items.Item;

public class Backpack {
	
	//backpack
	private int maxSize;
	ArrayList<Equipment> equipment;
	private ArrayList<Item> misc;
	
	Backpack(int maxSize)
	{
		this.maxSize = maxSize;
		
		equipment = new ArrayList<Equipment>(maxSize);
		misc = new ArrayList<Item>(maxSize);
	}
	
	public boolean addItem(Item item)
	{
		if(item instanceof Equipment)
		{
			if(equipment.size() < maxSize)
			{
				equipment.add((Equipment) item);
				return true;
			}
			else return false;
		}
		else if(misc.size() < maxSize)
		{
			misc.add(item);
			return true;
		}
		else return false;
	}
	
	public ArrayList<Equipment> getEquipment()
	{
		return equipment;
	}
	
	public ArrayList<Item> getMisc()
	{
		return misc;
	}
	
}
