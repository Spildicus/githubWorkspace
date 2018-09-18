import java.util.Scanner;

public class GameController {

	//private Player player;
	//private Menu menu;
	private boolean isExit; 
	
	//input scanner
	private Scanner in;
	
	//set isExit to false and start the scanner
	GameController()
	{
		isExit = false;
		in = new Scanner(System.in);
	}
	
	//used to update all aspects of the game
	public void update()
	{
		TextHandler.displayText("Enter Input: ");
		getInput();
	}
	
	//set if the game is going to exit at the end of the next update loop
	public void setIsExit(boolean set)
	{
		isExit = set;
	}
	
	//check isExit
	public boolean getIsExit()
	{
		return isExit;
	}
	
	//get player input
	public String getInput()
	{
		return in.nextLine();
	}
	
}
