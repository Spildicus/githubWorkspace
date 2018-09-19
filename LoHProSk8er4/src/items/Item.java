package items;

public class Item {
	//item's name -kb
	protected String name;
	//item's selling value -kb
	protected int worth;
	//description of item -kb
	protected String description; 
	//type of item
	protected String type;
	
	Item(String name, int worth, String description, String type){
		this.name = name;
		this.worth = worth;
		this.description = description;
		this.type = type;
	}
	
	//get item's name, worth, description, and rarity -kb
	public String getName() {return name;}
	public int getWorth() {return worth;}
	public String getDescription() {return description;}
	public String getType() {return type;}
}
