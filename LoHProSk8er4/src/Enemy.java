import java.util.ArrayList;

import Items.Item;
public abstract class Enemy {
	
	//enemy's name -kb
	private String name;
	//enemy's level -kb
	private int level;
	//enemy's current and max health -kb
	private int health, maxHealth;
	//enemy's damage -kb
	private int damage;
	//items enemies can drop -kb
	private ArrayList<Item> dropList;


}
