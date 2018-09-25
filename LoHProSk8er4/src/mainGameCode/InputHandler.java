package mainGameCode;
import java.util.Scanner;
import java.util.InputMismatchException;

public class InputHandler {

	private static Scanner in = new Scanner(System.in);
	
	//private static String input = "";
	
	public static String getInput()
	{
		return in.nextLine();
	}
	
	public static int getIntegerInput()
	{
		boolean success = false;
		int input = -1;
		
		while(!success)
		{
			try
			{
				input = in.nextInt();
				success = true;
			}
			catch (InputMismatchException e)
			{
				TextHandler.displayText("invalid input");
			}
		}
		
		return input;
	}
	
}
