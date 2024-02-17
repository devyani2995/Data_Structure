package linkedlist;

public class lengthOfLL {
	public static int length(Node<Integer> head){
        //Your code goes here
		Node<Integer> temp = head;
		int count =0;
		if(temp==null)
			return 0;
		while(temp!=null) {
			count++;
			temp=temp.next;
		
		}
		
		return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Node<Integer> n1 = new Node<Integer>(10);
		 Node<Integer> n2 = new Node<Integer>(20);
		 Node<Integer> n3 = new Node<Integer>(10);
		 Node<Integer> n4 = new Node<Integer>(20);
		 
		 n1.next =n2;
		 n2.next=n3;
		 n3.next = n4;
		
		  System.out.println(length(n1));
	}

}
