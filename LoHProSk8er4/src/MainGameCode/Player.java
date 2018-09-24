package mainGameCode;

import items.Equipment;

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
	//damage stat for damage that will be dealt when attacking
	private int damage;
	
	private Backpack backpack;
	//equipment order: (0)head, (1)torso, (2)arms, (3)legs, (4)weapon, (5)offHand -kb
	private Equipment[] equipped = {new Equipment("EMPTY", 0, "", "HEAD", 0, 0, 0, 0, 0, 0),
			new Equipment("EMPTY", 0, "", "TORSO", 0, 0, 0, 0, 0, 0),
			new Equipment("EMPTY", 0, "", "ARMS", 0, 0, 0, 0, 0, 0),
			new Equipment("EMPTY", 0, "", "LEGS", 0, 0, 0, 0, 0, 0),
			new Equipment("EMPTY", 0, "", "FEET", 0, 0, 0, 0, 0, 0),
			new Equipment("EMPTY", 0, "", "WEAPON", 0, 0, 0, 0, 0, 0),
			new Equipment("EMPTY", 0, "", "OFFHAND", 0, 0, 0, 0, 0, 0)};
	 

	public Player(String name){ //dummy character -kb	
		
		this.setName(name);
		addLevel();
		setXp(0);
		setMaxXp(100);
		setHealth(20);
		setMaxHealth(100);	
		setMana(50);
		setMaxMana(50);
		
		setVitality(5);
		setIntelligence(5);
		setStrength(5);
		setWisdom(5);
		
		setDamage(5);
		setDefense(0);
		
		setBackpack(new Backpack(20));
		
		backpack.addItem("Polar Pop");
		backpack.addItem("Klondike Bar");
		backpack.addItem("Big tiddy goth GF");
		backpack.addItem("Sippy Cup");
		
		backpack.addItem("A Big Boy's Sword");
		backpack.addItem("Red Copper Pan");
		backpack.addItem("Broken Helmet");
		backpack.addItem("Bloodied Tunic");
		backpack.addItem("Muddy Pants");
		backpack.addItem("Torn Gloves");
		backpack.addItem("Worn Boot");
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public void addHealth(int add) {
		if(health + add >= maxHealth) health = maxHealth;
		else health += add;
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

	public Backpack getBackpack() {
		return backpack;
	}

	public void setBackpack(Backpack backpack) {
		this.backpack = backpack;
	}

	public Equipment[] getEquipped() {
		return equipped;
	}

	public void setEquipped(Equipment[] equipped) {
		this.equipped = equipped;
	}
	
	public void updateStats()
	{
		int dmg = 0;
		int def = 0;
		int vit = 0;
		int intel = 0;
		int str = 0;
		int wis = 0;
		
		for(Equipment i : equipped)
		{
			int[] stats = i.getStatus();
			dmg += stats[0];
			def += stats[1];
			vit += stats[2];
			intel += stats[3];
			str += stats[4];
			wis += stats[5];
		}
		
		setDamage(dmg + 5);
		setDefense(def);
		setVitality(vit);
		setIntelligence(intel);
		setStrength(str);
		setWisdom(wis);
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public void checkForLevelUp()
	{
		/*TODO: check if player XP >= maxXP, if so, increase level by one and set the maxXP to the new value
		 * 
		 * TIPS: 
		 *  - use an algorithm with level as your 'x' variable
		 *  - when increasing level by one, call the method addLevel(); (This is where you will actually gain a level
		 * 	  and go to some sort of 'congratulations' menu. You can decide what happens though.
		 */
	}
	
	public int getLevel() {
		return level;
	}
	
	public void addLevel() 
	{
		//TODO: increase level by one, show menu of some sort (ill show you how later)
		//		and increase stats by whatever amount you specify.
	}
	
	/*TODO: Something we should do is create a separate class for handling the player's stats.
	 * 		This is because doing it all in the player class is cumbersome and it takes alot
	 * 		of space, especially since we need to do more in here. An easy way to solve this would
	 * 		be to make it it's own object that the player will 'own'.
	 * 
	 * To start off, I have made a new Stats class. More info on there.
	 * 
	 */

}
