package Stack;
import java.util.*;
public class countBrackets {
	public static int countBracketReversals(String input) {
		//Your code goes here
		 if (input.length()%2!=0)
        {
            return -1;
        }
        Stack<Character> stack=new Stack<Character>();
        int count=0;
        for (int i=0;i<input.length();i++)
        {
            char c=input.charAt(i);
            if (c=='{')
            {
                stack.push(c);
            }
            else
            {
                if (stack.isEmpty())
                {
                    stack.push(c);
                }
                else if (stack.peek()=='}')
                {
                    stack.push(c);
                }
                else if (stack.peek()=='{')
                {
                    stack.pop();
                }
            }
        }
        
        while(!stack.isEmpty())
        {
            char c1=stack.pop();
            char c2=stack.pop();
            
            if (c1==c2)
            {
                count=count+1;
            }
            else
            {
                count=count+2;
            }
        }
        return count;
        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner sr = new Scanner(System.in);
	      String ch = sr.next();
	      System.out.println(countBracketReversals(ch));
	}

}
