package binary_tree;
public class removeLeafNode {
    public static BinaryTreeNode<Integer> removesLeaf(BinaryTreeNode<Integer> root){
    	if(root==null)
    		return null;
    	
    	//if root is a leaf
    	if(root.left == null && root.right == null)
    		return null;
    	
    	root.left=removesLeaf(root.left); //updating root.left
    	root.right=removesLeaf(root.right); //updating root.right
    	 
    	return root;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root=TakeInput.takeTreeInputBetter(true, 0, true);	
		BinaryTreeNode<Integer> newRoot = removesLeaf(root);
		
		TakeInput.printTreeDetailed(newRoot);
	}

}
