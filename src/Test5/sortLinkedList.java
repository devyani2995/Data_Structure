package Test5;

import java.util.Scanner;

import linkedlist.Node;

public class sortLinkedList {
	 public static LinkedListNode<Integer> takeInput(){
		   Scanner s=new Scanner(System.in);	   
		   int data = s.nextInt();
		   LinkedListNode<Integer> head =null,tail=null;
		   while(data != -1) {
			   LinkedListNode<Integer> currentNode = new LinkedListNode<Integer>(data);
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
	   
	   public static void print(LinkedListNode<Integer> head) {
		   LinkedListNode<Integer> temp = head;
		    while(temp!=null) {
		    	System.out.print(temp.data+" ");
		    	temp=temp.next;
		    }
	   }
	   public static LinkedListNode<Integer> sortList(LinkedListNode<Integer> head) {
	        //Write your code here
		   LinkedListNode<Integer> current = head, index = null;
		   
	        int temp;
	 
	        if (head == null) {
	            return head;
	        }
	        else {
	            while (current != null) {
	                // Node index will point to node next to
	                // current
	                index = current.next;
	 
	                while (index != null) {
	                    // If current node's data is greater
	                    // than index's node data, swap the data
	                    // between them
	                    if (current.data > index.data) {
	                        temp = current.data;
	                        current.data = index.data;
	                        index.data = temp;
	                    }
	 
	                    index = index.next;
	                }
	                current = current.next;
	            }
	            return head;
	        }
	    }
	   public static void main(String[] args) {
			// TODO Auto-generated method stub
			LinkedListNode<Integer> head =takeInput();
			LinkedListNode<Integer> newHead = sortList(head);
			 print(newHead);

		}
}
