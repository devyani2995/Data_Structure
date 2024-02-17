package BST1;

import binary_tree.BinaryTreeNode;
import binary_tree.TakeInputLevelWise;
import binary_tree.nodesWithLargestData;

public class checkBST {
    public static boolean isBST(BinaryTreeNode<Integer> root) {
    	if(root == null) {
    		return true;
    	}
    	
    	int leftMax =maximum(root.left);
    	if(leftMax >= root.data)
    		return false;
    	
    	int rightMin = minimum(root.right);
    	if(rightMin < root.data)
    		return false;
    	
    	boolean isLeftBST  = isBST(root.left);
    	boolean isRightBST = isBST(root.right);
    	
    	return isLeftBST && isRightBST;
    	
    }
    
    //Time:O(n)
    public static isBSTReturn isBST2(BinaryTreeNode<Integer> root) {
    	if(root == null) {
    		isBSTReturn ans = new isBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
    		return ans;
    	}
    	
    	isBSTReturn leftAns = isBST2(root.left);
    	isBSTReturn rightAns = isBST2(root.right);
    	
    	int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
    	int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
    	
    	boolean isBST = true; //let assume;
    	
    	if(leftAns.max > root.data) {
    		isBST = false;
    	}
    	
    	if(rightAns.min < root.data) {
    		isBST = false;
    	}
    	
    	if(!leftAns.isBST) {
    		isBST = false;
    	}
    	
    	if(!rightAns.isBST) {
    		isBST = false;
    	}
    	
    	isBSTReturn ans = new isBSTReturn(min, max, isBST);
    	return ans;
    	
    }
    
    public static boolean isBST3(BinaryTreeNode<Integer> root , int minRange, int maxRange) {
    	
    	if(root==null) {
    		return true;
    	}
    	
    	if(root.data < minRange || root.data > maxRange) {
    		return false;
    	}
    	
    	boolean isLeftWithinRange = isBST3(root.left, minRange,root.data - 1);
    	boolean isRightWithinRange = isBST3(root.right, root.data,maxRange);
    	
    	return isLeftWithinRange && isRightWithinRange;
    	
    }
	private static int minimum(BinaryTreeNode<Integer> root) {
		// TODO Auto-generated method stub
		if(root == null)
			return Integer.MAX_VALUE;
		
		int leftMin = minimum(root.left);
		int rightMin = minimum(root.right);
		
		return Math.min(root.data,Math.min(leftMin, rightMin));
	}
	private static int maximum(BinaryTreeNode<Integer> root) {
		// TODO Auto-generated method stub
//		if(root==null)
//    		return Integer.MIN_VALUE;
//    	int largestLeft=maximum(root.left);
//    	int largestRight =maximum(root.right);
//    	return Math.max(root.data,Math.max(largestLeft, largestRight));
		
		int max=nodesWithLargestData.largest(root); 
		
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root=TakeInputLevelWise.takeInputLevelWise();
//		System.out.println(isBST(root));
//		isBSTReturn ans = isBST2(root);
//		System.out.println(ans.min +" "+ ans.max + " " + ans.isBST);
		System.out.println(isBST3(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
	}

}
