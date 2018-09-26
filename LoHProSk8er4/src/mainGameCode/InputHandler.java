package mainGameCode;
import java.util.Scanner;

public class InputHandler {

	private static Scanner in = new Scanner(System.in);
	
	//private static String input = "";
	
	public static String getInput()
	{
		return in.nextLine();
	}
	
	public static int getIntegerInput()
	{
		int input;
		
		while(!in.hasNextInt())
			in.next();
		input = in.nextInt();
		
		return input;
	}
	
}
