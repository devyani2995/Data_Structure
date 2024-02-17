package Recursion3;
import java.util.*;
public class PrintKeypad {
	public static String getOptions(int digit) {
		if(digit == 2) {
			return "abc";
		}
		
		if(digit == 3) {
			return "def";
		}
		
		if(digit == 4) {
			return "ghi";
		}
		
		if(digit == 5) {
			return "jkl";
		}
		
		if(digit == 6) {
			return "mnq";
		}
		
		if(digit == 7) {
			return "pqrs";
		}
		
		if(digit == 8) {
			return "tuv";
		}
		
		if(digit == 9) {
			return "wxyz";
		}
		 
		return "";
	}
	private static void printKeypadHelper(int input, String stringSoFar) {
		 if(input == 0) {
			 System.out.println(stringSoFar);
			 return;
		 }
		 int lastDigit = input % 10;
		 int smallOutput = input / 10;
		 String optionLastDigit = getOptions(lastDigit);
		 
		for(int i=0;i< optionLastDigit.length();i++) {
			printKeypadHelper(smallOutput, optionLastDigit.charAt(i) + stringSoFar);
		}
	}
	public static void printKeypad(int input){
		printKeypadHelper(input,"");
	}
	
	/*------------another method-----------------*/
	private static void printKeypad(int input,HashMap<Integer,String>h,String soFar){
		if(input==0){
			System.out.println(soFar);
			return;
		}
		int rem=input%10; input/=10;
		String str=h.get(rem);
		for(int i=0;i<str.length();i++){
			printKeypad(input,h,str.charAt(i)+soFar);
		}
	}

	public static void printKeypad2(int input){
		// Write your code here
	HashMap<Integer,String> h = new HashMap<>();

		h.put(2,"abc"); 
		h.put(3,"def"); 
		h.put(4,"ghi");
		h.put(5,"jkl");
		h.put(6,"mno");
		h.put(7,"pqrs");
		h.put(8,"tuv");
		h.put(9,"wxyz");

		printKeypad(input,h,"");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("enter no.");
		int input = s.nextInt();
		printKeypad(input);
	}

}
