package linkedlist;

import java.util.Scanner;

    public class removeDuplicates {
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
	
	public static Node<Integer> removeDuplicates(Node<Integer> head) {
		//Your code goes here
		if(head == null)
			return head;
		else {
		Node<Integer> current = head,index=null,temp=null;
		Node<Integer> finalHead = head;
		while(current!=null) {	
			temp=current;	  //Node temp will point to previous node to index.  
			index=current.next; //Index will point to node next to current  
			
			while(index !=null) {
				if(current.data == index.data) {
					temp.next = index.next;
				}else {
					temp=index;
				}
				index=index.next;
			}
			
			current=current.next;
		}
		
		return finalHead;
		}
//		if(head==null)
//            return head;
//      
//        Node<Integer> t1=head,t2=head.next;
//        Node<Integer> finalhead=head;
//        while(t2!=null){
//            if(t1.data.equals(t2.data))
//            {
//                t2=t2.next; 
//            }
//            else{
//                t1.next=t2;
//                t1=t2;
//            }
//        }
//
//        t1.next=null;
//        return finalhead;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Node<Integer> head =takeInput();
		 Node<Integer> newhead = removeDuplicates(head);
		 print(newhead);
	}

}
