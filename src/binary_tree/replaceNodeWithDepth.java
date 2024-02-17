package binary_tree;

public class replaceNodeWithDepth {
	public static void inOrder(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);

	}
    public static void changeToDepthTree(BinaryTreeNode<Integer> root, int depth)
    {
		        if (root==null)
		        {
		            return;
		        }
		        root.data=depth;
		        changeToDepthTree(root.left,depth+1);
		        changeToDepthTree(root.right,depth+1);
    }
	public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
	    //Your code goes here
		changeToDepthTree(root,0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root=TakeInput.takeTreeInputBetter(true, 0, true);
		changeToDepthTree(root);
		inOrder(root);
	}

}
