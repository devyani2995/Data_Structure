/*
 * Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.
Return empty string for numbers 0 and 1.
Note :
1. The order of strings are not important.
2. Input and output has already been managed for you. You just have to populate the output array and return the count of elements
   populated in the output array.
 */
package Recursion3;
import java.util.Scanner;

public class ReturnKeypad {
//	public static String getOptions(int digit) {
//		if(digit == 2) {
//			return "abc";
//		}
//		
//		if(digit == 3) {
//			return "def";
//		}
//		
//		if(digit == 4) {
//			return "ghi";
//		}
//		
//		if(digit == 5) {
//			return "jkl";
//		}
//		
//		if(digit == 6) {
//			return "mnq";
//		}
//		
//		if(digit == 7) {
//			return "pqrs";
//		}
//		
//		if(digit == 8) {
//			return "tuv";
//		}
//		
//		if(digit == 9) {
//			return "wxyz";
//		}
//		 
//		return "";
//	}
	
	
	// Define the keypad mappings
    private static final String[] KEYPAD_MAPPING = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };
	public static String[] keypad(int n){
//		if(n==0) {
//			String[] output = new String[1];
//			output[0] = "";
//			return output;
//		}
//		
//		String[] smallOutput = keypad(n/10);
//		int lastDigit = n%10;
//		String lastDigitOptions = getOptions(lastDigit);
//        String[] output =  new String[smallOutput.length * lastDigitOptions.length()];
//        
//        int k=0;
//        for(int i=0;i<smallOutput.length;i++) {
//        	for(int j=0;j<lastDigitOptions.length();j++) {
//        		output[k]=smallOutput[i] + lastDigitOptions.charAt(j);
//        		k++;
//        	}
//        }
//        
//        return output;
		
		if (n == 0) {
            String[] empty = {""};
            return empty;
        }

        int lastDigit = n % 10;
        n /= 10;

        String[] smallOutput = keypad(n);
        String keypadChars = KEYPAD_MAPPING[lastDigit];
        
        String[] output = new String[smallOutput.length * keypadChars.length()];
        int k = 0;
        
        for (int i = 0; i < smallOutput.length; i++) {
            for (int j = 0; j < keypadChars.length(); j++) {
                output[k] = smallOutput[i] + keypadChars.charAt(j);
                k++;
            }
			}
        
        return output;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("enter number");
		int input=s.nextInt();
		String[] output =  keypad(input);
		  for(String str:output) {
	    	  System.out.println(str);
	      }
	}

}
