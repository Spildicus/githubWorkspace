import java.util.ArrayList;

public class TextHandler {
		
	private static String text = "";
	
	private static ArrayList<String> menuList = new ArrayList<String>(10);
	
	//maximum string length in console before new line is created
	private static int maxCharLength = 100;
	
	TextHandler()
	{
		
	}
	
	//When this function is called, it will set the variable and send it to the console
	
	public static void displayText(String textToDisplay)
	{
		text = textToDisplay;
		sendToScreen();
	}
	
	//format the text so a new line is created every <maxCharLength> characters
	public static void createNewList(String[] s)
	{
		int listNum = 1;
		
		for (String str : s)
		{
			displayText("\t (" + listNum + ")" + " " + str + "\n");
			listNum++;
		}
	}
	
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
