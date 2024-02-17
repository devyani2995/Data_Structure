package Recursion3;
import java.util.*;
public class PrintSubsequences {
	public static void printSubseq(String input,String stringSoFar) {
		if(input.length()==0) {
			System.out.println(stringSoFar);
			return;
		}
		
		String smallInput = input.substring(1);
		printSubseq(smallInput, stringSoFar);
		printSubseq(smallInput, stringSoFar + input.charAt(0));
		
	}
	public static void main(String[] args) {
	  Scanner s=new Scanner(System.in);
	  System.out.println("enter string");
	  String str=s.next();
	  printSubseq(str, "");
	}
}
