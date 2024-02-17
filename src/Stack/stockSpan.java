package Stack;
import java.util.*;
public class stockSpan {
	public static int[] stockSpan(int[] price) {
		//Your code goes here
		 int[] span=new int[price.length];
	        Stack<Integer> stack=new Stack<Integer>();
	        span[0]=1;
	        stack.push(0);
	        
	        for (int i=1;i<price.length;i++)
	        {
	            while(!stack.isEmpty() && price[stack.peek()]<price[i])
	            {
	                stack.pop();
	            }
	            //System.out.println(stack.size());
	            
	            if (stack.isEmpty())
	            {
	                span[i]=i+1;
	            }
	            else
	            {
	                //System.out.println("i = "+i);
	                //System.out.println("top = "+stack.peek());
	                span[i]=i-stack.peek();
	            }
	            stack.push(i);
	            //System.out.println("New top: "+stack.peek());
	            //System.out.println();
	        }
	        return span;
	        
	}
	   public static int[] takeInput() 
	    {
	        Scanner sr = new Scanner(System.in);
	    	int size = sr.nextInt();
	    	int[] input = new int[size];

	    	if (size == 0) 
	    	{
	    		return input;
	    	}
	    	for(int i = 0; i < size; i++) 
	    	{
	    		input[i] = sr.nextInt();
	    	}

	    	return input;
	    }

	    public static void printArray(int[] arr) 
	    {
	    	for (int i = 0 ; i < arr.length; i++) 
	    	{
	    		System.out.print(arr[i] + " ");
	    	}

	    	System.out.println();
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] input = takeInput();

    	int[] output = stockSpan(input);

    	printArray(output);
	}

}
