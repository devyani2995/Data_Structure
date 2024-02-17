package linkedlist;

class DoubleNode{

    Node<Integer> head;
    Node<Integer> tail;
    DoubleNode(){

    }

    DoubleNode(Node<Integer> head, Node<Integer> tail){
      this.head= head;
      this.tail= tail;
    }
}

public class reverseRecursive {
	// Recursive relation:-T(n)=T(n-1) + n-1 and T(n) = O(n^2) 
	public static Node<Integer> reverseRec(Node<Integer> head) {
		//Your code goes here
     if(head==null)
            return head;
        if(head.next==null)
            return head;
        Node<Integer> tail=head.next;
        Node<Integer> smallhead=reverseRec(head.next);
        tail.next=head;
        head.next=null;
        return smallhead; 
	}
	
	//Recursive relation:- T(n)=T(n-1) + k and T(n)=O(n)
	public static DoubleNode reverseRBetter(Node<Integer> head){
	    DoubleNode ans;
	    if(head==null || head.next ==null){
	        ans= new DoubleNode(head, head);
//	        ans.head= head;
//	        ans.tail= head;
	        return ans;
	    }
        
	    //this double will have both head and tail of reversed LL
	    DoubleNode smallAns= reverseRBetter(head.next);
	    smallAns.tail.next= head;
	    head.next= null;
	    ans = new DoubleNode();
	    ans.head= smallAns.head;
	    ans.tail= head;
	    return ans;
	}
	
	public static Node<Integer> reverseRBetter1(Node<Integer> head){
		DoubleNode ans = reverseRBetter(head);
		return ans.head;
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
		Node<Integer> n1 = new Node<Integer>(20);
		 Node<Integer> n2 = new Node<Integer>(80);
		 Node<Integer> n3 = new Node<Integer>(30);
		 Node<Integer> n4 = new Node<Integer>(40);
		 
		 n1.next =n2;
		 n2.next=n3;
		 n3.next = n4;
		 
//		 Node<Integer> newHead = reverseRec(n1);
		 Node<Integer> newHead = reverseRBetter1(n1);
		 print(newHead);

	}
}
