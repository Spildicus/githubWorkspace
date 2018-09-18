package mainGameCode;
import java.util.LinkedList;

import gameMenus.MainMenu;
import gameMenus.Menu;

public class GameController {

	//private Player player;
	private static LinkedList<Menu> menus;
	private static boolean isExit; 
	
	private static Player player;
	private static int layer = 1; //represents the 'layer' the player is currently on
	

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
		
		menus.getFirst().update();
		
	}
	
	//used when you want to exit a menu and replace it with a new one
	public static void pollMenu(Menu m)
	{
		menus.removeFirst();
		addMenu(m);
	}
	
	public static void exitMenu()
	{
		menus.removeFirst();
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
	
	//adds a menu to the queue
	public static void addMenu(Menu m)
	{
		menus.addFirst(m);
	}

	public static Player getPlayer() {
		return player;
	}

	public static void setPlayer(Player player) {
		GameController.player = player;
	}

	public static int getLayer() {
		return layer;
	}

	public static void setLayer(int layer) {
		GameController.layer = layer;
	}
	
}
