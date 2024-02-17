package binary_tree;

public class preAndPostOrder {
	public static void preOrder(BinaryTreeNode<Integer> root) {
		//Your code goes here
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	public static void postOrder(BinaryTreeNode<Integer> root) {
		//Your code goes here
		if(root==null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root=TakeInput.takeTreeInputBetter(true, 0, true);
		preOrder(root);
	    
	}

}
