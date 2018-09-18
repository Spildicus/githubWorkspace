
public class Player {

	//player's name -kb
	private String name; 
	//player's level -kb
	private int level;
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
	
	Player(String name){ //dummy character -kb
		
		this.name = name;
		level = 1;
		xp = 0;
		maxXp = 100;
		health = 100;
		maxHealth =	100;	
		mana = 50;
		maxMana = 50;
		
		vitality = 5;
		intelligence = 5;
		strength = 5;
		wisdom = 5;
		
	}
	
	
	
	
}
