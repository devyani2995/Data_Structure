package queue;
import java.util.*;
public class reverseKElements {
	 public static void reverseQueue(Queue<Integer> input, int k){
			//Your code goes here
	        if (input.size()==0 || input.size()==1 || k==0){
	            return;
	        }
	        
	        int temp=input.remove();
	        reverseQueue(input,k-1);
	        input.add(temp);
		}
		public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
			//Your code goes here
			 if (input.size()>k)
	        {
	            k=k%input.size();
	        }
	        if (k==0 || k==1)
	        {
	            return input;
	        }
	        
	        reverseQueue(input,k);
	        
	        for (int i=0;i<input.size()-k;i++)
	        {
	            input.add(input.remove());
	        }
	        
	        return input;
	        
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer>  queue = new LinkedList<Integer>(); 
	      int arr[]= {10,20,30,40,50,55};
	     int k=2;
	      for(int elem:arr) {
	    	  System.out.println(elem);
	      	queue.add(elem);
	      }
	      reverseKElements(queue,k);
	    while(!queue.isEmpty()) {
	  	System.out.println(queue.poll());
	  }
	}

}
