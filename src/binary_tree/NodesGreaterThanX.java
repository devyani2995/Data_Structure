package binary_tree;

public class NodesGreaterThanX {
	public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
		//Your code goes here
		if(root==null)
			return 0;
		int leftCount = countNodesGreaterThanX(root.left, x) ;
		int rightCount = countNodesGreaterThanX(root.right, x);
		if(root.data > x)
			return 1+ leftCount+rightCount;
		else 
			return leftCount+rightCount;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root=TakeInput.takeTreeInputBetter(true, 0, true);
		System.out.println(countNodesGreaterThanX(root, 2));
	}

}
