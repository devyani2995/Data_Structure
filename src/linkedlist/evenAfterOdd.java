package linkedlist;
import java.util.Scanner;

public class evenAfterOdd {
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
	public static Node<Integer> evenAfterOdd(Node<Integer> head) {
		//Your code goes here
		if(head == null)
			return head;
		Node<Integer> current = head;
		Node<Integer> evenStart =null,evenEnd =null,oddStart = null,oddEnd =null;
		
		while(current!=null) {
			if(current.data % 2 == 0) {
				if(evenStart == null) {
					evenStart = current;
					evenEnd = current;
				}else {
					evenEnd.next = current;
					evenEnd = evenEnd.next;
				}
			}else {
				if(oddStart == null) {
					oddStart = current;
					oddEnd = current;
				}else {
					oddEnd.next = current;
					oddEnd = oddEnd.next;
				}
			}
			current = current.next;
		}
		
		if(oddStart == null)
			return  evenStart;
		if(evenStart == null)
			return oddStart;
		
		oddEnd.next = evenStart;
		evenEnd.next = null;
//	    head = oddStart;
	    
		return oddStart;
		
	}
	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		 Node<Integer> head =takeInput();
		Node<Integer> newHead = evenAfterOdd(head);
		print(newHead);
	}

}
