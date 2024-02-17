package binary_tree;

public class nodesWithLargestData {
    public static int largest(BinaryTreeNode<Integer> root) {
    	if(root==null)
    		return -1;
    	int largestLeft=largest(root.left);
    	int largestRight =largest(root.right);
    	return Math.max(root.data,Math.max(largestLeft, largestRight));
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root=TakeInput.takeTreeInputBetter(true, 0, true);
		System.out.println("Largest data: "+largest(root));
	}

}
