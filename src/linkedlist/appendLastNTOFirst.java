package linkedlist;

import java.util.Scanner;

public class appendLastNTOFirst {
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
	 
	 public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {
			//Your code goes here
		 if(head == null)
			 return head;
		if(n==0){
			return head;
		}
		 Node<Integer> temp=head;
	        int count=0;
	        while(temp!=null ){
	            temp=temp.next;
	            count++;
	        }
	        int newcount=count-n;
	        count=0;
	        Node<Integer> temp1=head;
	        while(count<newcount-1){
	            temp1=temp1.next;
	            count++;
	        }
	        Node<Integer> temp2=temp1.next;
	       Node<Integer> temp3=temp1.next;
	        while(temp2.next!=null){
	            temp2=temp2.next;
	        }
	        temp2.next=head;
	        temp1.next=null;
	        return temp3;
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
		 head = appendLastNToFirst(head,0);
		 print(head);
	}

}
