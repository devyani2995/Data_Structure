package binary_tree;
import java.util.*;
public class TakeInputLevelWise {
    public static BinaryTreeNode<Integer> takeInputLevelWise(){
      Scanner sc=new Scanner(System.in);
      System.out.println("enter root data");
      int rootData=sc.nextInt();
      if(rootData==-1) {
    	  return null;
      }
      
      BinaryTreeNode<Integer> root =new BinaryTreeNode<Integer>(rootData);
      Queue<BinaryTreeNode<Integer>> pendingChild =new LinkedList<BinaryTreeNode<Integer>>();
      pendingChild.add(root);
      
      while(!pendingChild.isEmpty()) {
    	  BinaryTreeNode<Integer> front =pendingChild.poll();
    	  System.out.println("Enter left child of "+front.data);
    	  int left =sc.nextInt();
    	  if(left!=-1) {
    		  BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(left);
    		  front.left=leftChild; //attach data to the element on left side 
    		  pendingChild.add(leftChild);//push that data on the queue
    	  }
    	  
    	  System.out.println("Enter right child of "+front.data);
    	  int right =sc.nextInt();
    	  if(right!=-1) {
    		  BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(right);
    		  front.right=rightChild; //attach data to the element on right side 
    		  pendingChild.add(rightChild);//push that data on the queue
    	  }
      }
      return root;
    }
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		//Your code goes here
		  if (root == null) 
			return;
		  
	      Queue<BinaryTreeNode<Integer>> pendingChild =new LinkedList<BinaryTreeNode<Integer>>();
	      pendingChild.add(root);
	      while(!pendingChild.isEmpty()) {
	    	  BinaryTreeNode<Integer> front =pendingChild.poll();
	    	  if (front==null){
	                if (pendingChild.isEmpty())
	                    break;
	                else
	                {
	                    System.out.println();
	                    pendingChild.add(null);
	                }   
	          }else {
	            	System.out.print(front.data+":");
	                if (front.left!=null) {
	                	pendingChild.add(front.left);
	                    System.out.print("L:"+front.left.data);
	                }else {
	                	System.out.print("L:"+ -1);
	                }
	                
	                if (front.right!=null) {
	                	pendingChild.add(front.right);
	                    System.out.print(",R:"+front.right.data);
	                }else {
	                	System.out.print(",R:"+-1);
	                }
	                System.out.println();
	          }
	      }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		
	    printLevelWise(root);
	}

}
