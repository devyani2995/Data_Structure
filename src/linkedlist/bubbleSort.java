package linkedlist;

import java.util.Scanner;

public class bubbleSort {
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
	
	public static Node<Integer> bubbleSort(Node<Integer> head) {
		//Your code goes here
		// Node current will point to head
        Node<Integer> current = head, index = null;
 
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
		 System.out.println("Enter LL elements");
		 Node<Integer> head =takeInput();
		 System.out.println("Element after sorting");
		 Node<Integer> newHead = bubbleSort(head);
		 print(newHead);
	}

}
