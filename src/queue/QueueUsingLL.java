package queue;
//all frunctions have time compl of O(1)
import linkedlist.Node;

public class QueueUsingLL<T> {
  private Node<T> front;
   private Node<T> rear;
   int size=0; //size of the will be the size of the linked list
   
   public QueueUsingLL() {
	   front=null;
	   rear=null;
	   size=0;
   }
   
   public int size() {
	   return size;
   }
   
   public boolean isEmpty(){
	 return size==0;   
   }
   
   public void enqueue(T elem) {
	   Node<T> newNode = new Node<T>(elem);
	   size++;
	   if(rear==null) {
		   front=newNode;
		   rear=newNode;
	   }else {
		   rear.next = newNode;
		   rear=newNode; //or rear=rear.next;		   
	   }
   }
   
   public T front() {
	   if(front == null) {
   		System.out.println("queue is empty");
   	}
   	return front.data;
   }
   
   public T dequeue() {
	   if(front == null) {
		   System.out.println("Queue is empty");
	   }
	   T temp=front.data;
	   front=front.next;
	   if(front==null) {
		   rear=null;
	   }
	   size--;
	   return temp;
   }
   
}
