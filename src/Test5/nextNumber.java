package Test5;

import java.util.Scanner;

import linkedlist.Node;

public class nextNumber {
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
	   public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
			//Your code goes here
	     if(head==null)
	            return head;
	        if(head.next==null)
	            return head;
	        LinkedListNode<Integer> tail=head.next;
	        LinkedListNode<Integer> smallhead=reverse(head.next);
	        tail.next=head;
	        head.next=null;
	        return smallhead; 
		}
	   
	 public static LinkedListNode increment( LinkedListNode<Integer>  head){
	        // res is head node of the resultant list
	        LinkedListNode<Integer> res = head;
	        LinkedListNode<Integer>  temp = null, prev = null;
	 
	        int carry = 1, sum;
	 
	        while (head != null) // while both lists exist
	        {
	            // Calculate value of next digit in resultant
	            // list. The next digit is sum of following
	            // things (i) Carry (ii) Next digit of head list
	            // (if there is a next digit)
	            sum = carry + head.data;
	 
	            // update carry for next calculation
	            carry = (sum >= 10) ? 1 : 0;
	 
	            // update sum if it is greater than 10
	            sum = sum % 10;
	 
	            // Create a new node with sum as data
	            head.data = sum;
	 
	            // Move head and second pointers to next nodes
	            temp = head;
	            head = head.next;
	        }
	 
	        // if some carry is still there, add a new node to
	        // result list.
	        if (carry > 0)
	            temp.next =new LinkedListNode<Integer>(carry);
	 
	        // return head of the resultant list
	        return res;
	    }
	   
	   public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {
		    if(head == null)
		    	return head;
		   // Reverse linked list
	        head = reverse(head);
	        // Add one from left to right of reversed
	        // list
	        head = increment(head);
	 
	        // Reverse the modified list
	        return reverse(head);
		}
	   public static void main(String[] args) {
			// TODO Auto-generated method stub
			LinkedListNode<Integer> head =takeInput();
			LinkedListNode<Integer> newHead = nextLargeNumber(head);
			 print(newHead);

		}
}
