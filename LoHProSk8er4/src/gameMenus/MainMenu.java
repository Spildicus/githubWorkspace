package gameMenus;
import mainGameCode.GameController;
import mainGameCode.InputHandler;
import mainGameCode.TextHandler;

public class MainMenu extends Menu{
	
	public MainMenu()
	{
		super("Main Menu");
	}
	
	public void update()
	{
		displayTitle();
		TextHandler.createNewList(new String[] {"New Game", "Load Game", "Options", "Exit"});
		setPlayerInput(InputHandler.getInput());
		if(getPlayerInput().contains("1")) GameController.addMenu(new NewGameMenu()); //new game
		if(getPlayerInput().contains("2")); //load game
		if(getPlayerInput().contains("3")); //options
		if(getPlayerInput().contains("4")) GameController.setIsExit(true); //exit
	}
	
}
