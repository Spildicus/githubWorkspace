package items;
public class Equipment extends Item {

	//item's type (e.g head, torso, arms, legs, feet, weapon, offHand) -kb
	private String type;
	//equipment's defense value (e.g arm defense = 150)  -kb
	private int defense;
	//equipment's damage value (e.g weapon damage = 970 ) -kb
	private int damage;

	Equipment(String name, int worth, String desription, String rarity, String type, int defense, int damage){
		super(name, worth, desription);
		this.type = type;
		this.defense = defense;
		this.damage = damage;
	}

}

