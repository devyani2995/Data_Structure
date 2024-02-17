package binary_tree;

public class checkBalanceTree {
	//time:O(n)
	public static BalancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root) {
		if(root==null) {
			int height = 0;
			boolean isBal = true;
			BalancedTreeReturn ans = new BalancedTreeReturn();
			ans.height=height;
			ans.isBalanced=isBal;
			return ans;
		}
		
		BalancedTreeReturn leftOutput = isBalancedBetter(root.left);
		BalancedTreeReturn rightOutput = isBalancedBetter(root.right);
	
		//let by default isBal=true
		boolean isBal = true;
		int height = 1+Math.max(leftOutput.height, rightOutput.height);
		
		if(Math.abs(leftOutput.height -rightOutput.height)>1) {
			isBal=false;
		}
		
		if(!leftOutput.isBalanced || !rightOutput.isBalanced ) {
			isBal=false;
		}
		
		BalancedTreeReturn ans = new BalancedTreeReturn();
		ans.height=height;
		ans.isBalanced=isBal;
		return ans;
	}
	
	//time:O(nh)
	//if height is log(n) then time :O(nlogn)
	//if height is n then time:O(n^2)
	public static boolean isBalanced(BinaryTreeNode<Integer> root) {
		if(root==null)
			return true;
		int leftHeight = heightOfTree.height(root.left);
		int rightHeight=heightOfTree.height(root.right);
		
		if(Math.abs(leftHeight-rightHeight) > 1)
			return false;
		
		boolean isLeftBalanced = isBalanced(root.left);
		boolean isRighttBalanced = isBalanced(root.right);
		
		return isLeftBalanced && isRighttBalanced;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root=TakeInput.takeTreeInputBetter(true, 0, true);	
		System.out.println(isBalancedBetter(root).isBalanced);
	}
}
