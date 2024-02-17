package Stack;
import java.util.*;
public class StackUsingQueue {
	Queue<Integer> q1,q2;
	
	public StackUsingQueue(){
		q1=new LinkedList<Integer>();
		q2=new LinkedList<Integer>();
	}
	
	 public int getSize() { 
	    //Implement the getSize() function
		 return q1.size();
	 }
	 
	 public boolean isEmpty() {
	    //Implement the isEmpty() function
	    return q1.isEmpty();
	 }
	 
	 public void push(int element) {
	        //Implement the push(element) function
		 q1.add(element);
	 }
	 
	 public int pop() {
		 if (q1.isEmpty())
	            return -1;
	 
	        // Leave one element in q1 and
	        // push others in q2.
	        while (q1.size() != 1) {
	            q2.add(q1.peek());
	            q1.remove();
	        }
	 
	        // Pop the only left element
	        // from q1
	      int temp = q1.remove();
	 
	        // swap the names of two queues
	        Queue<Integer> q = q1;
	        q1 = q2;
	        q2 = q;
	        
	      return temp;  
	 }
	 
	 public int top() {
		 if (q1.isEmpty())
	            return -1;
	 
	        while (q1.size() != 1) {
	            q2.add(q1.peek());
	            q1.remove();
	        }
	 
	        // last pushed element
	        int temp = q1.peek();
	 
	        // to empty the auxiliary queue after
	        // last operation
	        q1.remove();
	 
	        // push last element to q2
	        q2.add(temp);
	 
	        // swap the two queues names
	        Queue<Integer> q = q1;
	        q1 = q2;
	        q2 = q;
	        return temp;
	 }
	
}
