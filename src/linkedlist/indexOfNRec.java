package linkedlist;

public class indexOfNRec {
	public static int findNodeRec(Node<Integer> head, int n,int index) {
		if(head == null)
			return -1;
		if(head.data == n)
			return index;
		int ans = findNodeRec(head.next,n,index+1);
		return ans;
	}
	public static int findNodeRec(Node<Integer> head, int n) {
    	//Your code goes here
		return findNodeRec(head,n,0);
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
		 
		 System.out.println(findNodeRec(n1,2));
	}

}
