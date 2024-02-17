package linkedlist;
import java.util.*;
public class takeInput {
   public static Node<Integer> takeInput(){
	   Scanner s=new Scanner(System.in);	   
	   int data = s.nextInt();
	   Node<Integer> head =null,tail=null;
	   while(data != -1) {
		   Node<Integer> currentNode = new Node<Integer>(data);
		   if(head == null) {
			   //Make this node as head node and tail node
			   head = currentNode;
			   tail =currentNode;
		   }else {
//			   Node<Integer> tail = head;
//			   while(tail.next != null) {
//				   tail=tail.next;
//			   }
//			   //now tail will refer to the last node
//			   //connect current node after last node
			   tail.next = currentNode;
			   tail = currentNode;//or tail=tail.next()
		   }
		   data=s.nextInt();
	   }
	   return head;
   }
   
   public static void print(Node<Integer> head) {
	   Node<Integer> temp = head;
	    while(temp!=null) {
	    	System.out.print(temp.data+" ");
	    	temp=temp.next;
	    }
   }
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Node<Integer> head =takeInput();
		 print(head);
	}

}
