package queue;
import java.util.LinkedList;
import java.util.Queue;
public class reverseQueue {
	public static void reverseQueue(Queue<Integer> input) {
		//Your code goes here
		 if (input.size()==0 || input.size()==1)
        {
            return;
        }
        
        int temp=input.remove();
        reverseQueue(input);
        input.add(temp);
	
	}
	public static void main(String[] args) {
		Queue<Integer>  queue = new LinkedList<Integer>(); 
      int arr[]= {10,20,30,40,50,55};
     
      for(int elem:arr) {
    	  System.out.println(elem);
      	queue.add(elem);
      }
      reverseQueue(queue);
    while(!queue.isEmpty()) {
  	System.out.println(queue.poll());
  }
 
	}

}
