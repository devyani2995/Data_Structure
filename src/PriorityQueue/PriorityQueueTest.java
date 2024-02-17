package PriorityQueue;

public class PriorityQueueTest{

	public static void main(String[] args) throws PriorityQueueException {
		// TODO Auto-generated method stub
//        Priority_queue< String> pq= new Priority_queue<String>();
//        pq.insert("abc", 15);
//        pq.insert("def", 13);
//        pq.insert("fsas", 90);
//        pq.insert("klkl", 150);
//        pq.insert("njkl", 120);
//        
//        while(!pq.isEmpty()) {
//        	System.out.println(pq.getMin());
//        	pq.removeMin();
//        }
		
	 MaxPriorityQueue mq = new MaxPriorityQueue();
      mq.insert(15);
      mq.insert(13);
      mq.insert(90);
      mq.insert(150);
      mq.insert(120);
      
    while(!mq.isEmpty()) {
  	 System.out.println(mq.getMax());
  	  mq.removeMax();
     }
  }
}