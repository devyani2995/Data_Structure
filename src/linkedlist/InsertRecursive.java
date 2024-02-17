package linkedlist;

public class InsertRecursive {
	public static Node<Integer> insertRecursive(Node<Integer> head, int pos, int elem){
		   if(head == null && pos>0)
			   return head;
					   
		   if(pos==0) {
			   Node<Integer> newNode = new Node<Integer>(elem);
			   newNode.next = head;
			   return newNode;
		   }else {
			  
			   Node<Integer> smallerHead =  insertRecursive(head.next, pos-1, elem);
			   head.next = smallerHead;
			   return head;
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
		 Node<Integer> n1 = new Node<Integer>(2);
		 Node<Integer> n2 = new Node<Integer>(8);
		 Node<Integer> n3 = new Node<Integer>(30);
		 Node<Integer> n4 = new Node<Integer>(40);
		 
		 n1.next =n2;
		 n2.next=n3;
		 n3.next = n4;
		 
		 Node<Integer> newHead = insertRecursive(n1,2,20);
		 print(newHead);
	}

}
