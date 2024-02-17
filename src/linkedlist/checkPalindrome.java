package linkedlist;

import java.util.Scanner;


public class checkPalindrome {
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
	 public static Node<Integer> reverseList(Node<Integer> temp){  
	        Node<Integer> current = temp;  
	        Node<Integer> prevNode = null, nextNode = null;  
	  
	       //Swap the previous and next nodes of each node to reverse the direction of the list  
	        while(current != null){  
	            nextNode = current.next;  
	            current.next = prevNode;  
	            prevNode = current;  
	            current = nextNode;  
	        }  
	        return prevNode;  
	    } 
	public static boolean isPalindrome(Node<Integer> head) {
		//Your code goes here
		if(head == null) {
//			System.out.println("line 49");
			return true;
		}else if(head.next == null){
//			System.out.println("line 51");
			  return true;
			}
		else {
//			System.out.println("line 55");
		Node<Integer> temp = head;
		int count =0;
		while(temp!=null) {
			count++;
			temp=temp.next;
		
		}
		
		    Node<Integer> current = head;  
	        boolean flag = true;  
		
	      //Store the mid position of the list  
	        int mid = (count%2 == 0)? (count/2) : ((count+1)/2); 
	        
	        //Finds the middle node in given singly linked list  
	        for(int i=1; i<mid; i++){  
	            current = current.next;  
	        }  
	        
	        //Reverse the list after middle node to end  
	        Node<Integer> revHead = reverseList(current.next); 
	        //Compare nodes of first half and second half of list  
	        while(head != null && revHead != null){  
	            if(head.data != revHead.data){  
	                flag = false;  
	                break;  
	            }  
	            head = head.next;  
	            revHead = revHead.next;  
	        } 
	        
	        if(flag)  
	            return true; 
	        else  
	           return false; 
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Node<Integer> head =takeInput();
		 print(head);
		 boolean isPalindrome = isPalindrome(head);
		 if(isPalindrome)
			 System.err.println("Palindrome");
		 else
			 System.out.println("not palindrome");
		 
	}
}
