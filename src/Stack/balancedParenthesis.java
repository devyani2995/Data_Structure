package Stack;
import java.util.*;
public class balancedParenthesis {
	  public static boolean isBalanced(String expression) {
	        //Your code goes here
		    // create an empty stack   
	        Stack stack = new Stack();   
	        
	        for(int i=0;i<expression.length();i++) {
	        	if(expression.charAt(i)== '(') {
	        		stack.push(expression.charAt(i));
	        		continue;
	        	}
	        	
	        	 // if stack is empty, return false   
	            if (stack.isEmpty()) {    
	                return false;   
	            } 
	            
	            
	            char popChar;
	            popChar = (char) stack.pop();   
                if (popChar == '{' || popChar == '[')   
                    return false;   
	        }
	        
	        return stack.isEmpty();
	    }
	 public static void main(String[] args) 
	    {
	        Scanner sr = new Scanner(System.in);
	        String expression = sr.next();
	        System.out.println(isBalanced(expression));
	    }
}
