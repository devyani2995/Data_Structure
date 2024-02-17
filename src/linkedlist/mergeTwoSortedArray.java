package linkedlist;

import java.util.Scanner;

public class mergeTwoSortedArray {
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
	public static Node<Integer> mergeTwoSorteds(Node<Integer> head1, Node<Integer> head2) {
	        //Your code goes here
		if(head1 == null && head2 == null) {
			return head1;
		}else if(head1==null && head2!=null) {
			return head2;
		}else if(head1!=null && head2==null) {
			return head1;
		}else {
		Node<Integer> t1= head1, t2= head2;
	      Node<Integer> head= null, tail=null;
	      if(t1.data<= t2.data){
	          head=t1;
	          tail=t1;
	          t1=t1.next;
	      }else{
	        head= t2;
	        tail=t2;
	        t2=t2.next;
	      }
	      while(t1 != null && t2!= null){
	        if(t1.data <= t2.data){
	          tail.next= t1;
	          tail=t1;
	          t1= t1.next;
	        }else{
	        tail.next= t2;
	        tail=t2;
	        t2= t2.next;
	        }
	      }
	      if(t1!= null){
	        tail.next= t1;
	      }else{
	        tail.next=t2;
	      }
	      return head;
		}
			
	}   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter first sorted LL");
		 Node<Integer> head1 =takeInput();
		 System.out.println("Enter sec sorted LL");
		 Node<Integer> head2 =takeInput();
		 
		 Node<Integer> newHead = mergeTwoSorteds(head1, head2);
		 System.out.println();
		 print(newHead);
		
	}

}
