package linkedlist;

public class deleteNode {
	public static Node<Integer> deleteNode( Node<Integer> head, int pos) {
		// Write your code here.
        if(head==null )
            return head;
        if(pos==0)
            return head.next;
        int count=0;
        Node<Integer> prev=head;
        while(prev!=null && count<pos-1)
        {
            prev=prev.next;
            count++;
        }
        if(prev==null)
            return head;
        if(prev.next!=null)
            prev.next=prev.next.next;
         
        
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
		Node<Integer> newNode = deleteNode(n1,0);
		 print(newNode);
	}

}
