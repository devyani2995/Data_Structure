package binary_tree;

public class mirrorBinaryTree {
	public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
		//Your code goes here
		    if(root==null){
	            return;
	        }
	        
	        BinaryTreeNode<Integer> temp=root.left;
	        root.left=root.right;
	        root.right=temp;
	        mirrorBinaryTree(root.left);
	        mirrorBinaryTree(root.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root=TakeInput.takeTreeInputBetter(true, 0, true);	
	    mirrorBinaryTree(root);
		
		TakeInput.printTreeDetailed(root);
	}

}
