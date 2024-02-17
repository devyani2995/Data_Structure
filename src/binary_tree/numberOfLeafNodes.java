package binary_tree;

public class numberOfLeafNodes {
	//Time:O(n)
    public static int numOfLeaf(BinaryTreeNode<Integer> root) {
    	if(root==null)
    		return 0;
    	if(root.left==null && root.right==null) {
    		return 1;
    	}
    	return numOfLeaf(root.left) + numOfLeaf(root.right);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root=TakeInput.takeTreeInputBetter(true, 0, true);
		System.out.println("num of leafs: "+numOfLeaf(root));
	}

}
