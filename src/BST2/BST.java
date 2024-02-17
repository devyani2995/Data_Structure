package BST2;

import binary_tree.BinaryTreeNode;

public class BST {
   private BinaryTreeNode<Integer> root;
   private int size;
   
   private static boolean isPresentHelper(BinaryTreeNode<Integer> root,int x) {
	    if (root==null){
            return false;
        }
	    
	    if(root.data == x)
	    	return true;
	    
	    if(x<root.data) {
	    	//call on left side
	    	return isPresentHelper(root.left,x); 	
	    }else {
	    	//call on right side
	    	return isPresentHelper(root.right, x);
	    }
   }
   public boolean isPresent(int x) {
     return isPresentHelper(root, x);
   }
   
   public void insert(int x) {
	   root = insertHelper(root,x);
	   size++;   
   }
   
   private BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root, int x) {
	// TODO Auto-generated method stub
		if (root==null){
			BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<Integer>(x);
			return newRoot;
		}
		
		if (x>root.data){
			root.right=insertHelper(root.right,x);
		}else{
			root.left=insertHelper(root.left,x);
		}
		return root;
   }
   
   public boolean deleteData(int x) {
	BSTDeleteReturn output = deleteDataHelper(root,x);
	root=output.root;
	if(output.deleted) {
		size--;
	}
	return output.deleted;
   }
   
   private static BSTDeleteReturn deleteDataHelper(BinaryTreeNode<Integer> root, int x) {
	// TODO Auto-generated method stub
	    if (root == null)
			return new BSTDeleteReturn(null,false);
	   
		if (root.data < x){
			BSTDeleteReturn outputRight = deleteDataHelper(root.right,x);
			root.right = outputRight.root;
			outputRight.root=root;
			return outputRight;
		}
		
		if (root.data>x){
			BSTDeleteReturn outputLeft = deleteDataHelper(root.left,x);
			root.left = outputLeft.root;
			outputLeft.root=root;
			return outputLeft;
		}
		
		//Now, we handle the three sub cases where root.data==x
	    //Handling case where root has no children
		if (root.left == null && root.right == null)
			return new BSTDeleteReturn(null,true);
		
		//Handling case where only left child is present
		if (root.left!=null && root.right==null)
			return new BSTDeleteReturn(root.left,true);
		
		//Handling case where only right child is present
		if (root.right!=null && root.left==null)
			return new BSTDeleteReturn(root.right,true);
		
		//Both children are present
		//Get the smallest node's data from right subtree
		int rightMax=minimum(root.right);
				
		//Replace current root's data with smallest node's data
		root.data=rightMax;
		 
		//Now, delete the node with the smallest value from the right subtree
		BSTDeleteReturn outputRight = deleteDataHelper(root.right,rightMax);
		
		//Update the current root's right child, after removing the node with smallest value
		root.right=outputRight.root;
		
		return new BSTDeleteReturn(root,true);
   }
   private static int minimum(BinaryTreeNode<Integer> root) {
   	  if(root==null)
   		return Integer.MAX_VALUE;
   	  int largestLeft=minimum(root.left);
   	  int largestRight =minimum(root.right);
   	  return Math.min(root.data,Math.min(largestLeft, largestRight));
   	
   }
   
   public int size() {
	   return size;
   }
   
   private static void printTreeHelper(BinaryTreeNode<Integer> root) {
       if(root == null){
           return;
       }
       System.out.print(root.data+":");
       if(root.left != null){
           System.out.print("L"+root.left.data+", ");
           }
       if(root.right != null){
           System.out.print("R"+root.right.data);
           }
       System.out.println();
       printTreeHelper(root.left);
       printTreeHelper(root.right);
   }
   public void printTree() {
	   printTreeHelper(root);
   }
}
