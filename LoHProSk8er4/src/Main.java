public class Main {
	
	public static void main(String[] args) {
		
		GameController game = new GameController();
		
		//game loop
		while(!game.getIsExit())
		{
			
			game.update();
			
			TextHandler.displayText("This is a test to see how the text input handler works. Essentially, it should create a new line every 100 characters to remove the need to go through each line of text and format it such that it fits within the confined space of the console.");
			
		}
		
		TextHandler.displayText("Game exited.");
		
	}

}
