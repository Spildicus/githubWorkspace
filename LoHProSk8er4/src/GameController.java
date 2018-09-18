
public class GameController {

	//private Player player;
	private boolean isExit; 
	
	GameController()
	{
		isExit = false;
	}
	
	//used to update all aspects of the game
	public void update()
	{
		
	}
	
	//set if the game is going to exit at the end of the next update loop
	public void setIsExit(boolean set)
	{
		isExit = set;
	}
	
	public boolean getIsExit()
	{
		return isExit;
	}
	
}
