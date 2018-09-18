import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class GameController {

	//private Player player;
	private LinkedList<Menu> menus;
	private static boolean isExit; 
	
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
		
		menus.getFirst().update();
		
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
	
	
}
