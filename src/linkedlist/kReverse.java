package linkedlist;

import java.util.Scanner;

public class kReverse {
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
	   
	   public static Node<Integer> kReverse(Node<Integer> head, int k) {
			//Your code goes here
	        if(head == null)
	          return null;
	       if(k==0)
	         return head;

	        Node<Integer> current = head;
	        Node<Integer> next = null;
	        Node<Integer> prev = null;
	  
	        int count = 0;
	  
	        while (count < k && current != null) {
	            next = current.next;
	            current.next = prev;
	            prev = current;
	            current = next;
	            count++;
	        }
	  
	        if (next != null)
	            head.next = kReverse(next, k);
	  
	        return prev;
		}
	   
	   public static void main(String[] args) { 
			// TODO Auto-generated method stub
			 Node<Integer> head =takeInput();
			Node<Integer> newHead = kReverse(head,2);
			print(newHead);
		}
}
