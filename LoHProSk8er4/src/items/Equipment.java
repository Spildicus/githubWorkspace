package items;
public class Equipment extends Item {

	private int damage;
	private int defense;
	private int vitalityBoost;
	private int intelligenceBoost;
	private int strengthBoost;
	private int wisdomBoost;

	public Equipment(
			String name, 
			int worth, 
			String description, 
			String type, 
			int damage, 
			int defense, 
			int vitalityBoost, 
			int intelligenceBoost,
			int strengthBoost, 
			int wisdomBoost)
	{
		super(name, worth, description, type);
		
		this.damage = damage;
		this.defense = defense;
		this.vitalityBoost = vitalityBoost;
		this.intelligenceBoost = intelligenceBoost;
		this.strengthBoost = strengthBoost;
		this.wisdomBoost = wisdomBoost;
	}
	
	//returns an array of all the stats of the equipment
	public int[] getStatus()
	{
		int[] stats = {damage, defense, vitalityBoost, intelligenceBoost, strengthBoost, wisdomBoost};
		return stats;
	}

}

