package MainGameCode;

public class Main {
	
	public static void main(String[] args) {
		
		GameController game = new GameController();
		
		//game loop
		while(!game.getIsExit())
		{
			
			game.update();
			
			
		}
		
		TextHandler.displayText("Game exited.");
		
	}

}
