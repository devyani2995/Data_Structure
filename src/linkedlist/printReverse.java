package linkedlist;

public class printReverse {
	public static void printReverse(Node<Integer> root) {
		//Your code goes here
		if (root == null )  
		{  
		return;  
		}else if(root.next == null){
			System.out.println(root.data);
		}
		else {
			Node previous = null;  
			Node curr = root;  
			Node next = null;  
			  
			  
			while (curr != null)   
			{  
			next = curr.next;  
			curr.next = previous;  
			previous = curr;  
			curr = next;  
			}  
			root = previous;  
			  Node<Integer> temp1 = root;
			    while(temp1!=null) {
			    	System.out.print(temp1.data+" ");
			    	temp1=temp1.next;
			    } 
		}
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
		 Node<Integer> n1 = new Node<Integer>(3);
//		 Node<Integer> n2 = new Node<Integer>(4);
//		 Node<Integer> n3 = new Node<Integer>(5);
//		 Node<Integer> n4 = new Node<Integer>(2);
//		 Node<Integer> n5 = new Node<Integer>(6);
//		 Node<Integer> n6 = new Node<Integer>(1);
//		 Node<Integer> n7 = new Node<Integer>(9);
		 
//		 n1.next =n2;
//		 n2.next=n3;
//		 n3.next = n4;
//		 n4.next=n5;
//		 n5.next=n6;
//		 n6.next=n7;
		 System.out.println("original ll");
		 print(n1);
		 System.out.println();
		 System.out.println("reversed ll");
		 printReverse(n1);
		 
	}

}
