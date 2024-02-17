package queue;
import java.util.*;
public class QueueUsingStacks {
	Stack<Integer> s1;
    Stack<Integer> s2;
    
    public QueueUsingStacks() {
    	s1=new Stack<Integer>();
    	s2=new Stack<Integer>();
    }
    
    /* Function to push an item to stack*/
   public static void push(Stack<Integer> top_ref, int new_data)
    {
        // Push the data onto the stack
        top_ref.push(new_data);
    }
    
    /* Function to pop an item from stack*/
   public static int pop(Stack<Integer> top_ref)
    {
        /*If stack is empty then error */
        if (top_ref.isEmpty()) {
            return -1;
        }
 
        // pop the data from the stack
        return top_ref.pop();
    }
   public void enQueue(int x)
    {
        push(s1, x);
    }
    
    /* Function to deQueue an item from queue */
    public int deQueue()
    {
        int x;
 
        /* If both stacks are empty then error */
        if (s1.isEmpty() && s2.isEmpty()) {
            return -1;
        }
 
        /* Move elements from stack1 to stack 2 only if
        stack2 is empty */
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                x = pop(s1);
                push(s2, x);
            }
        }
        x = pop(s2);
        return x;
    }
 
}
