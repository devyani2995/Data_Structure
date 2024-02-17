package binary_tree;

public class heightOfTree {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root=TakeInput.takeTreeInputBetter(true, 0, true);
		System.out.println("Height: "+height(root));
	}

}
