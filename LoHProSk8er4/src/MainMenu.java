
public class MainMenu extends Menu{
	
	MainMenu()
	{
		super("MainMenu");
	}
	
	public void update()
	{
		displayTitle();
		TextHandler.createNewList(new String[] {"New Game", "Load Game", "Options", "Exit"});
		setPlayerInput(InputHandler.getInput());
		if(getPlayerInput().contains("1")); //new game
		if(getPlayerInput().contains("2")); //load game
		if(getPlayerInput().contains("3")); //options
		if(getPlayerInput().contains("4")) GameController.setIsExit(true); //exit
	}
	
}
