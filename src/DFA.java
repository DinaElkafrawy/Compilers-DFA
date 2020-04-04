import java.util.Scanner;

public class DFA {
	String suffix;
	String prefix;
	
	static String[] states;
	static String[] acceptedStates;
	
	public static void divide(String description) {
		String[] values = description.split("#");
		
		states = values[0].split(";");
		
		String goal = values[1];
		acceptedStates = goal.split(",");
		
	}
	
	public static Boolean run(String string) {
		int currentIndex = 0;
		char[] characters = string.toCharArray();
		
		for(int i = 0; i < characters.length; i ++) {
			String[] currentState = states[currentIndex].split(",");
			
			if(characters[i] == '0' ) {
				currentIndex = Integer.parseInt(currentState[1]);
			}
			else
				currentIndex = Integer.parseInt(currentState[2]);
		}
		
		for(int j = 0; j < acceptedStates.length; j++) {
			if(currentIndex == Integer.parseInt(acceptedStates[j]))
				return true;
		}
		
		return false;
		
	}
	
	public static void main (String[] args) {
		
		Scanner input = new Scanner(System.in);
		
//		System.out.println("Enter string respresentation");
//		String str = input.next();
		
		divide("0,3,1;1,2,1;2,2,1;3,3,3#2");
		
		System.out.println("Enter your string");
		String strInput = input.next();
		
		Boolean result = run(strInput);
		
		System.out.println(result);
	}
	

}
