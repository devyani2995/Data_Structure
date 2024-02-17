package Test5;
import java.util.*;

import linkedlist.Node;
public class replaceDupicateValue {
	
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
	   public static void changeLL(LinkedListNode<Integer> head) {
		   // map to store the frequency of numbers
		    Map<Integer, Integer> mymap = new HashMap<>();
		    
		    LinkedListNode<Integer> temp = head;
		    LinkedListNode<Integer> temp1 = head;
		    
		    // variable to store the maximum number
		    // in linked list
		    int maxNum = 0;
		    

		    // traverse the linked list to store
		    // the frequency of every number and
		    // find the maximum integer
		    while (temp != null)
		    {
		        mymap.put(temp.data,(mymap.get(temp.data) ==
		                    null?0:mymap.get(temp.data))+1);
		        if (maxNum < temp.data)
		            maxNum = temp.data;
		        temp = temp.next;
		    }
		    
		    while (temp1 != null)
		    {
		     
		        // Mark the node with frequency more
		        // than 1 so that we can change the
		        // 2nd occurrence of that number
		        if (mymap.get(temp1.data) > 1)
		            mymap.put(temp1.data, -1);
		 
		        // -1 means number has occurred
		        // before change its value
		        else if (mymap.get(temp1.data) == -1)
		        	temp1.data = ++maxNum;
		 
		        temp1 = temp1.next;
		    }
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode<Integer> head =takeInput();
		changeLL(head);
		 print(head);

	}

}
