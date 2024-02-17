package linkedlist;

public class deleteRecursive {
	public static Node<Integer> deleteNodeRec(Node<Integer> head, int pos) {
    	//Your code goes here
         if(head==null)
            return head;
        if(pos==0)
            return head.next;
        head.next=deleteNodeRec(head.next,pos-1);
        return head;
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
		 
		 Node<Integer> newHead = deleteNodeRec(n1,1);
		 print(newHead);

	}

}
