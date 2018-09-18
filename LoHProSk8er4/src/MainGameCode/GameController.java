package MainGameCode;
import java.util.LinkedList;

import gameMenus.MainMenu;
import gameMenus.Menu;


public class GameController {

	//private Player player;
	private static LinkedList<Menu> menus;
	private static boolean isExit; 
	
	private static Player player;
	//input scanner

	
	//set isExit to false and start the scanner
	GameController()
	{
		isExit = false;

		
		//initialize linkedlist for menus
		menus = new LinkedList<Menu>();
		//add menus to list (in this case just the main menu
		menus.add(new MainMenu());
	}
	
	//used to update all aspects of the game
	public void update()
	{
		
		menus.getLast().update();
		
	}
	
	//set if the game is going to exit at the end of the next update loop
	public static void setIsExit(boolean set)
	{
		isExit = set;
	}
	
	//check isExit
	public boolean getIsExit()
	{
		return isExit;
	}
	
	public static void addMenu(Menu m)
	{
		menus.add(m);
	}

	public static Player getPlayer() {
		return player;
	}

	public static void setPlayer(Player player) {
		GameController.player = player;
	}
	
}
