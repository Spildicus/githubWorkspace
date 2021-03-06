package gameMenus;
import mainGameCode.TextHandler;

//this is an abstract class used as a stencil for each menu

public abstract class Menu {

	private String title;
	private String playerInput;
	
	//display title on create
	Menu(String title)
	{
		this.title = title;
	}
	
	public void update()
	{
	}
	
	protected void displayTitle()
	{
		TextHandler.displayText("\n------------------------------\n");
		TextHandler.displayText(this.title + "\n");
		TextHandler.displayText("------------------------------\n");
	}

	public String getPlayerInput() {return playerInput;}

	public void setPlayerInput(String playerInput) {this.playerInput = playerInput;}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}

}
