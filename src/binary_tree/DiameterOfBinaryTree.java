package binary_tree;

public class DiameterOfBinaryTree {
	public static int height(BinaryTreeNode<Integer> root) {
		//Your code goes here
		if(root==null)
			return 0;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		if(leftHeight > rightHeight) {
			return leftHeight + 1;
		}else {
			return rightHeight + 1;
		}
	}
	public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
		//Your code goes here
		 // base case if tree is empty
        if (root == null)
            return 0;
 
        // get the height of left and right sub-trees
        int lheight = height(root.left);
        int rheight = height(root.right);
 
        // get the diameter of left and right sub-trees
        int ldiameter = diameterOfBinaryTree(root.left);
        int rdiameter = diameterOfBinaryTree(root.right);
 
        /* Return max of following three
          1) Diameter of left subtree
          2) Diameter of right subtree
          3) Height of left subtree + height of right
          subtree + 1
         */
        return Math.max(lheight + rheight + 1,
                        Math.max(ldiameter, rdiameter));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root=TakeInput.takeTreeInputBetter(true, 0, true);	
		System.out.println("Diameter: "+diameterOfBinaryTree(root));
	}

}
