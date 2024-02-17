package queue;

public class QueueUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//        QueueUsingArray queue = new QueueUsingArray(3);      
//          QueueUsingLL<Integer> queue= new QueueUsingLL<Integer>();
//        int arr[]= {10,20,30,40,50,55};
//        for(int elem:arr) {
//        	queue.enqueue(elem);
//        }
//
//        while(!queue.isEmpty()) {
//        	System.out.println(queue.dequeue());
//        }
		
		QueueUsingStacks q= new QueueUsingStacks();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		
	      /* Dequeue items */
        System.out.print(q.deQueue() + " ");
        System.out.print(q.deQueue() + " ");
        System.out.println(q.deQueue() + " ");
		
	}

}
