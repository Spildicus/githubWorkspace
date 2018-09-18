package gameMenus;

import mainGameCode.GameController;
import mainGameCode.InputHandler;
import mainGameCode.Player;
import mainGameCode.TextHandler;

public class NewGameMenu extends Menu{

	public NewGameMenu()
	{
		super("New Game");
	}
	
	public void update()
	{
		Player player;
		
		displayTitle();
		TextHandler.displayText("Enter Character Name: ");
		player = new Player(InputHandler.getInput());
		
		TextHandler.displayText("Welcome, " + player.getName() + ", to Layers of Hell Pro Sk8er 4. You will be tested on your might, and your ability to fucking understand what the fuck is going on most of the time for the duration of this game. Good fucking luck.\n");
		TextHandler.createNewList(new String[] {"Damn ok", "no fuk u"});
		setPlayerInput(InputHandler.getInput());
		if(getPlayerInput().contains("1")) 
		{
			GameController.setPlayer(player); //add player to game
			GameController.pollMenu(new HubMenu()); //continue to main game
		}
		if(getPlayerInput().contains("2"))
		{
			TextHandler.displayText("Well ok, bye then :(\n");
			GameController.setIsExit(true);
		}
	}
}
