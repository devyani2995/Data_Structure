package Recursion3;
import java.util.*;
public class subsequences {
    public static String[] subsequences(String input) {
    	//base case
    	if(input.length()==0) {
    	   String[] output = new String[1];
    	   output[0]="";
    	   return output;
    	}
    	
    	String[] smallOutput = subsequences(input.substring(1));
    	String[] output = new String[smallOutput.length * 2]; //double the size
    	
    	for(int i=0;i<smallOutput.length;i++) {
    		output[i] = smallOutput[i];
            
    	}
    	for(int i=0;i<smallOutput.length;i++) {
    		output[smallOutput.length + i] =input.charAt(0) + smallOutput[i];
            
    	}
    	
    	return output;
    }
	public static void main(String[] args) {
      Scanner s=new Scanner(System.in);
      System.out.println("Enter string");
      String input=s.next();
      String[] output =  subsequences(input);
      for(String outputString:output) {
    	  System.out.println(outputString);
      }
	}

}
