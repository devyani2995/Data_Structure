package Test6;

import java.util.Scanner;

import Test5.LinkedListNode;
import linkedlist.Node;

public class multiplyTwoLinkedList {
	 public static LinkedListNode<Integer> temphead;
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
	   public static void multiply(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
	        //Your code goes here
//		   int N = 1000000007;
//	        int num1 = 0, num2 = 0;
//	  
//	        while (head1 != null || head2 !=  null){
//	              
//	            if(head1 != null){
//	                num1 = ((num1)*10)%N + head1.data;
//	                head1 = head1.next;
//	            }
//	              
//	            if(head2 != null)
//	            {
//	                num2 = ((num2)*10)%N + head2.data;
//	                head2 = head2.next;
//	            }
//	              
//	        }
//	        int temp= ((num1%N)*(num2%N))%N;
//           int digit;
//           LinkedListNode<Integer> newhead =null,newtail=null;
//	       while(temp!=0) {
//	    	   digit=temp%10; 
//	    	   LinkedListNode<Integer> currentNode = new LinkedListNode<Integer>(digit);
//	    	   if(newhead == null) {
//				   //Make this node as head node and tail node
//				   newhead = currentNode;
//				   newtail =currentNode;
//			   }else {
//				   newtail.next = currentNode;
//				   newtail = currentNode;//or tail=tail.next()
//			   }
//	    	   temp=temp/10;  
//	       }
//	       LinkedListNode<Integer> temp1=newhead;
//	       LinkedListNode<Integer> temp2 = reverseRec(temp1);
//		    
//	 
//	    	    while(temp2!=null) {
//	    	    	System.out.print(temp2.data+" ");
//	    	    	temp2=temp2.next;
//	    	   }
    	    LinkedListNode<Integer> print = multiplyLL(head1, head2);
	        while (print != null) {
	            System.out.print(print.data + " ");
	            print = print.next;
	        }
	    }
	   
	   public static LinkedListNode<Integer> multiplyLL(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {

	        // Reverse the input lists and get their lengths
	        int m = reverse(head1);
	        head1 = temphead;
	        int n = reverse(head2);
	        head2 = temphead;

	        // Make a list that will contain the result of multiplication, m+n+1 can be max size of the list
	        LinkedListNode<Integer> result = makeEmptyList(m + n);

	        // Pointers for traversing the linked lists
	        LinkedListNode<Integer> secondPtr = head2, resultPtr1 = result, resultPtr2, firstPtr;

	        // multiply each Node of second list with first
	        while (secondPtr != null) {
	            int carry = 0;

	            // Each time we start from the next of Node from which we started last time
	            resultPtr2 = resultPtr1;

	            firstPtr = head1;

	            while (firstPtr != null) {

	                // Multiply first list's digit with current second list's digit
	                int mul = firstPtr.data * secondPtr.data + carry;

	                // Assign the product to corresponding Node of result
	                resultPtr2.data += mul % 10;

	                // Resultant Node itself can have more than 1 digit
	                carry = mul / 10 + resultPtr2.data / 10;
	                resultPtr2.data = resultPtr2.data % 10;

	                firstPtr = firstPtr.next;
	                resultPtr2 = resultPtr2.next;
	            }

	            // If carry is remaining from last multiplication
	            if (carry > 0) {
	                resultPtr2.data += carry;
	            }

	            resultPtr1 = resultPtr1.next;
	            secondPtr = secondPtr.next;

	        }

	        // reverse the result list
	        reverse(result);
	        result = temphead;

	        // Remove if there are zeros at starting
	        while (result.next != null && result.data == 0) {
	            LinkedListNode<Integer> temp = result;
	            result = result.next;
	            //free(temp);
	        }

	        // Return head of multiplication list
	        return result;

	    }
	   
//		public static LinkedListNode<Integer> reverseRec(LinkedListNode<Integer> head) {
//			//Your code goes here
//	     if(head==null)
//	            return head;
//	        if(head.next==null)
//	            return head;
//	        LinkedListNode<Integer> tail=head.next;
//	        LinkedListNode<Integer> smallhead=reverseRec(head.next);
//	        tail.next=head;
//	        head.next=null;
//	        return smallhead; 
//		}

	    public static int reverse(LinkedListNode<Integer> head) {
	        LinkedListNode<Integer> prev = null;
	        LinkedListNode<Integer> curr = head;
	        int len = 0;
	        LinkedListNode<Integer> ahead = null;
	        while (curr != null) {
	            len++;
	            ahead = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = ahead;
	        }

	        head = prev;
	        temphead = head;
	        return len;
	    }

	    public static LinkedListNode<Integer> makeEmptyList(int length) {
	        LinkedListNode<Integer> head = null;
	        LinkedListNode<Integer> traverse = null;

	        while (length > 0) {

	            LinkedListNode<Integer> temp = new LinkedListNode<Integer>(0);

	            if (head == null) {
	                head = temp;
	                traverse = temp;
	            } else {
	                traverse.next = temp;
	                traverse = traverse.next;

	            }
	            length--;
	        }

	        return head;
	    }

	public static void main(String[] args) {
		   System.out.println("enter elem. of 1st LL");
		      LinkedListNode<Integer> head1 =takeInput();
		   System.out.println("enter elem. of 2nd LL");
		      LinkedListNode<Integer> head2 =takeInput();
		   multiply(head1,head2);
		   
		   
		   
	   }
	   
}
