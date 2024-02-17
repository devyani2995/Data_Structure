package linkedlist;

public class midPointOfLL {
	public static Node<Integer> midPoint(Node<Integer> head) {
        //Your code goes here
//		Node<Integer> slow=head,fast=head;
//		if(fast.next!=null && fast.next.next != null) {
//			slow=slow.next;
//			fast=fast.next.next;
//		}
//		
//		return slow;
		if(head == null) {
			return head;
		}
		Node<Integer> slow= head, fast= head;
	    while(fast.next!=null && fast.next.next != null){
	      slow= slow.next;
	      fast= fast.next.next;
	    }
	    return slow;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> n1 = new Node<Integer>(20);
		 Node<Integer> n2 = new Node<Integer>(80);
		 Node<Integer> n3 = new Node<Integer>(30);
		 Node<Integer> n4 = new Node<Integer>(40);
		 Node<Integer> n5 = new Node<Integer>(90);
		 
		 n1.next =n2;
		 n2.next=n3;
		 n3.next = n4;
		 n4.next = n5;
		 
		 Node<Integer> mid= midPoint(null);
		 if(mid!=null)
	      System.out.println(mid.data);

	}

}
