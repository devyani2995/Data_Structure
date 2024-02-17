package queue;
import java.util.*;
public class QueueCollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Queue<Integer> queue = new LinkedList<Integer>(); //we can't create the object of queue bcz it is an interface and here LinkedList class implements Queue
       queue.add(10);
       queue.add(20);
       System.out.println(queue.size());
       System.out.println(queue.peek());
       System.out.println(queue.poll());
       System.out.println(queue.size());
	}

}
