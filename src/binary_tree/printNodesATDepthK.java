package binary_tree;

public class printNodesATDepthK {
	//Time:O(n)
    public static void printAtDepthK(BinaryTreeNode<Integer> root,int k) {
    	if(root==null)
    		return ;
    	if(k==0)
    		System.out.println(root.data);
    	
    	printAtDepthK(root.left, k-1);
    	printAtDepthK(root.right, k-1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root=TakeInput.takeTreeInputBetter(true, 0, true);
		printAtDepthK(root, 2);
		
	}

}
