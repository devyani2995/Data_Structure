package linkedlist;

public class printIthNode {
	  public static void printIthNode(Node<Integer> head, int i){
		  int count=0;
		  Node<Integer> temp=head;
		        while(count!=i && temp!=null)
		        {
		            temp=temp.next;
		            count++;
		        }
		       if( count==i &&temp!=null)
		           System.out.println(temp.data);
	  }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Node<Integer> n1 = new Node<Integer>(10);
		 Node<Integer> n2 = new Node<Integer>(20);
		 Node<Integer> n3 = new Node<Integer>(30);
		 Node<Integer> n4 = new Node<Integer>(40);
		 
		 n1.next =n2;
		 n2.next=n3;
		 n3.next = n4;
		 
		 printIthNode(n1,3);
	} 

}
