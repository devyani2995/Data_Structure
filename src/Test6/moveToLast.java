package Test6;

import java.util.Scanner;

import linkedlist.Node;

public class moveToLast {
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
	public static Node<Integer> func(Node<Integer> head,int n) {
		 // Keeps track of locations where key
        // is present.
        Node<Integer> posOfKey = head;
 
        // Traverse list
        Node<Integer> temp = head;
        while (temp != null) {
            // If current pointer is not same as pointer
            // to a key location, then we must have found
            // a key in linked list. We swap data of pCrawl
            // and pKey and move pKey to next position.
            if (temp != posOfKey && temp.data != n) {
                posOfKey.data = temp.data;
                temp.data = n;
                posOfKey = posOfKey.next;
            }
 
            // Find next position where key is present
            if (posOfKey.data != n)
            	posOfKey = posOfKey.next;
 
            // Moving to next Node
            temp = temp.next;
        }
        
       		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner s=new Scanner(System.in);
		System.out.println("Enter LL data");
		 Node<Integer> head =takeInput();
		 System.out.println("enter key");
		 int k=s.nextInt();
		 Node<Integer> newHead = func(head, k);
		 print(newHead);

	}

}
