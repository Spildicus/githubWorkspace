package mainGameCode;
import java.util.ArrayList;

import items.Item;
public class Enemy {
	
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
	
	public Enemy(String name, int level, int maxHealth, int damage)
	{
		setName(name);
		setLevel(level);
		setHealth(maxHealth);
		setMaxHealth(maxHealth);
		setDamage(damage);
	}
	
	private void setDamage(int damage) {
		this.damage = damage;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getMaxHealth() {
		return maxHealth;
	}
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void deductHealth(int dmgDealt) {
		if(health - dmgDealt <= 0)
			health = 0;
		else health -= dmgDealt;
	}
	public int getDamage() {
		return damage;
	}


}
