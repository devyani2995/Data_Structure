package Stack;
import java.util.*;
public class reverseStack {
	public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
		//Your code goes here
		int n = input.size();
		for(int i = 0; i < n; i++)
	    {
	         
	        // Store the top element
	        // of the given stack
	        int temp = input.peek();
	 
	        // Pop that element
	        // out of the stack
	        input.pop();
	 
	        transfer(input, extra, n - i - 1);
	        input.push(temp);
	        transfer(extra, input, n - i - 1);
	    }
	}
	private static void transfer(Stack<Integer> input, Stack<Integer> extra, int n) {
		// TODO Auto-generated method stub
		
		 for(int i = 0; i < n; i++)
		    {
		         
		        // Store the top element
		        // in a temporary variable
		        int temp = input.peek();
		 
		        // Pop out of the stack
		        input.pop();
		 
		        // Push it into s2
		        extra.push(temp);
		    }
	}
	private static Stack<Integer> takeInput() {
		// TODO Auto-generated method stub
		   Scanner sr = new Scanner(System.in);
	        
	    	int size = sr.nextInt();
	    	Stack<Integer> input = new Stack<>();

	    	if (size == 0) 
	    	{
	    		return input;
	    	}

	    	for(int i = 0; i < size; i++) 
	    	{
	    	    int var = sr.nextInt();
	    		input.push(var);
	    	}

	    	return input;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Integer> input = takeInput();
    	Stack<Integer> empty = new Stack<>();

    	
    	reverseStack(input, empty);

    	while(!input.isEmpty()) 
    	{
    		System.out.print(input.pop() + " ");
    	}

	}

	

}
