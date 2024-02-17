package binary_tree;

import java.util.Scanner;

public class numberOfNodes {
	
	//Time:O(n)
	public static int numNodes(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int leftNodeCount = numNodes(root.left);
		int rightNodeCount = numNodes(root.right);
		return 1 + leftNodeCount + rightNodeCount;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root=TakeInput.takeTreeInputBetter(true, 0, true);
		int numOfnodes= numNodes(root);
		System.out.println("Number of nodes "+ numOfnodes);

	}

}
