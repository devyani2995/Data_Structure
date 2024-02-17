package linkedlist;

public class LinkedListUse {
   public static Node<Integer> createLinkedList(){
	   Node<Integer> n1= new Node<>(10);
	   Node<Integer> n2= new Node<>(20);
	   Node<Integer> n3= new Node<>(30);
	   Node<Integer> n4= new Node<>(40);
	   
	   n1.next =n2;
	   n2.next=n3;
	   n3.next=n4;
	  return n1;
   }
   
   public static void print(Node<Integer> head) {
	   Node<Integer> temp = head;
	    while(temp!=null) {
	    	System.out.println(temp.data);
	    	temp=temp.next;
	    }
   }
   
   public static void increment(Node<Integer> head){
	    Node<Integer> temp = head;
	    while(temp != null){
	        temp.data++;
	        temp = temp.next;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//       Node<Integer> n1= new Node<>(10);//create one node in the list nd n1 has the address of this node
//       System.out.println(n1.data);
//       System.out.println(n1.next);
//		Node<Integer> head = createLinkedList();
//		print(head);
		 Node<Integer> node1 = new Node<Integer>(10);
		    Node<Integer> node2 = new Node<Integer>(20);
		    node1.next = node2;
		    increment(node1);
		    print(node1);	
	}

}
