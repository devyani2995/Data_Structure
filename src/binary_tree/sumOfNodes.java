package binary_tree;

public class sumOfNodes {
	public static int getSum(BinaryTreeNode<Integer> root) {
		//Your code goes here.
		if(root==null) {
			return 0;
		}
		int smallSum=getSum(root.left)+getSum(root.right);
        return root.data+smallSum;
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=TakeInput.takeTreeInputBetter(true, 0, true);
		int sumOfNodes = getSum(root);
		System.out.println("sum of nodes "+sumOfNodes);
	}
}
