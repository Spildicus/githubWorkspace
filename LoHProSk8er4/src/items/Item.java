package items;

public class Item {
	//item's name -kb
	private String name;
	//item's selling value -kb
	private int worth;
	//description of item -kb
	private String description; 
	//type of item
	private String type;
	
	//dummy item -kb
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
