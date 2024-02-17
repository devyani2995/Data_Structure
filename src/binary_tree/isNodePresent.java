package binary_tree;

public class isNodePresent {
	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
	    //Your code goes here
		if(root==null)
			return false;
		if(root.data == x)
			return true;
		return isNodePresent(root.left,x)||isNodePresent(root.right,x);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root=TakeInput.takeTreeInputBetter(true, 0, true);		
		System.out.println(isNodePresent(root,2));
	}

}
