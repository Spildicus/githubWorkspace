package MainGameCode;
import java.util.ArrayList;

import items.Equipment;
import items.Item;

public class Player {

	//player's name -kb
	private String name; 
	//player's level -kb
	private int level;
	//player's current defense, as equipped -kb
	private int defense;
	//current and max xp -kb
	private int xp, maxXp;
	//current and max health -kb
	private int health, maxHealth; 
	//current and max mana -kb
	private int mana, maxMana;
	//vitality stat, will effect maxHealth -kb
	private int vitality;
	//intelligence stat, will effect maxMana -kb
	private int intelligence;
	//strength stat, will effect melee damage (multiplier) -kb
	private int strength;
	//wisdom stat, will effect melee damage (multiplier) -kb
	private int wisdom; 
	
	//backpack
	private ArrayList<Item> equipment, consumable, misc;
	//equipment order: head, torso, arms, waist, legs, weapon, offHand -kb
	private Equipment[] equipped;
	 

	public Player(String name){ //dummy character -kb	
		this.setName(name);
		setLevel(1);
		setXp(0);
		setMaxXp(100);
		setHealth(100);
		setMaxHealth(100);	
		setMana(50);
		setMaxMana(50);
		
		setVitality(5);
		setIntelligence(5);
		setStrength(5);
		setWisdom(5);
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public int getDefense() {
		return defense;
	}


	public void setDefense(int defense) {
		this.defense = defense;
	}


	public int getXp() {
		return xp;
	}


	public void setXp(int xp) {
		this.xp = xp;
	}


	public int getMaxXp() {
		return maxXp;
	}


	public void setMaxXp(int maxXp) {
		this.maxXp = maxXp;
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


	public int getMana() {
		return mana;
	}


	public void setMana(int mana) {
		this.mana = mana;
	}


	public int getMaxMana() {
		return maxMana;
	}


	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}


	public int getVitality() {
		return vitality;
	}


	public void setVitality(int vitality) {
		this.vitality = vitality;
	}


	public int getIntelligence() {
		return intelligence;
	}


	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}


	public int getStrength() {
		return strength;
	}


	public void setStrength(int strength) {
		this.strength = strength;
	}


	public int getWisdom() {
		return wisdom;
	}


	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}
	
}
