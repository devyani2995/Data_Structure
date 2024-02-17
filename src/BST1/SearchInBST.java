package BST1;

import binary_tree.BinaryTreeNode;
import binary_tree.TakeInput;
import binary_tree.TakeInputLevelWise;

public class SearchInBST {
	public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
		    if (root==null){
	            return false;
	        }
	        
	        int rootData=root.data;
	        
	        if (k<rootData){
	            return searchInBST(root.left,k);
	        }else if(k>rootData){
	            return searchInBST(root.right,k);
	        }else{
	            return true;
	        }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   BinaryTreeNode<Integer> root=TakeInputLevelWise.takeInputLevelWise();
       System.out.println(searchInBST(root,2));
	}

}
