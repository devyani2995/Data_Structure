package linkedlist;

public class insertAtIthPos {
	public static Node<Integer> insert(Node<Integer> head, int pos, int data){
		//Your code goes here
		 Node<Integer> nodeToBeInserted= new Node<Integer>(data);

		    if(pos==0){
		      nodeToBeInserted.next= head;
		      return nodeToBeInserted;
		    }else{
		        int count=0;
		        Node<Integer> prev= head;
		        while(count<pos-1 && prev!=null){
		          count++;
		          prev=prev.next;
		        }
		        if(prev!=null){
		            nodeToBeInserted.next= prev.next;
		            prev.next= nodeToBeInserted;
		        }
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
		Node<Integer> newNode = insert(n1,0,80);
		 print(newNode);
	}

}
