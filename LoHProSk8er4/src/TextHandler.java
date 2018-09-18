public class TextHandler {
		
	private static String text;
	
	//maximum string length in console before new line is created
	private static int maxCharLength = 100;
	
	TextHandler()
	{
		//dud
	}
	
	//When this function is called, it will set the variable and send it to the console
	public static void displayText(String textToDisplay)
	{
		text = textToDisplay;
		sendToScreen();
	}
	
	//format the text so a new line is created every <maxCharLength> characters
	private static void sendToScreen()
	{
		int charsUsed = 0;
		
		for(int i = 0; i < text.length(); i++)
		{
			if(charsUsed >= maxCharLength && text.charAt(i) == ' ')
			{
				System.out.printf("\n");
				charsUsed = 0;
			}
			else
			{
				System.out.printf("%c", text.charAt(i));
				charsUsed++;
			}
		}
	}
	
}
