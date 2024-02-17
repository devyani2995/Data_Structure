package linkedlist;

public class findNode {
	public static int findNode(Node<Integer> head, int n) {
		// Write your code here.
		if(head == null)
			return -1;
		Node<Integer> temp=head;
		int count=0;
		while(temp!=null && temp.data!=n) {
			temp=temp.next;
			count++;
		}
		if(temp!=null) {
			return count;
		}else {
			return -1;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		 Node<Integer> n1 = new Node<Integer>(3);
		 Node<Integer> n2 = new Node<Integer>(4);
		 Node<Integer> n3 = new Node<Integer>(5);
		 Node<Integer> n4 = new Node<Integer>(2);
		 Node<Integer> n5 = new Node<Integer>(6);
		 Node<Integer> n6 = new Node<Integer>(1);
		 Node<Integer> n7 = new Node<Integer>(9);
		 
		 n1.next =n2;
		 n2.next=n3;
		 n3.next = n4;
		 n4.next=n5;
		 n5.next=n6;
		 n6.next=n7;
		 
		 System.out.println(findNode(n1, 6));
	}

}
