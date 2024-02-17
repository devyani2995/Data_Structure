package Stack;
import java.util.*;
public class checkRedundantBrackets {

	public static boolean checkRedundantBrackets(String expression) {
		//Your code goes here
		Stack stack = new Stack();  

        for(int i=0;i<expression.length();i++) {
         	if(expression.charAt(i)== ')') {
         	   char top = (char)stack.peek();
               stack.pop();
               
               // If immediate pop have open parenthesis '('
               // duplicate brackets found
               boolean flag = true;
               
               while (top != '(') {
            	   
                   // Check for operators in expression
                   if (top == '+' || top == '-'
                           || top == '*' || top == '/') {
                       flag = false;
                   }

                   // Fetch top element of stack
                   top = (char)stack.peek();
                   stack.pop();
               }

               // If operators not found
               if (flag == true) {
                   return true;
               }
         	}else {
         	// push open parenthesis '(',operators and operands to stack
         		stack.push(expression.charAt(i));
         	}
         	
        }
        return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String str = "(a+b)";
	        System.out.println(checkRedundantBrackets(str));
	}

}
