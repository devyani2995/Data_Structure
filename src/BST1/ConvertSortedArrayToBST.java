package BST1;

import binary_tree.BinaryTreeNode;
import binary_tree.TakeInputLevelWise;

public class ConvertSortedArrayToBST {
	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
		return SortedArrayToBSTHelper(arr,0,n-1);
	}
	private static BinaryTreeNode<Integer> SortedArrayToBSTHelper(int[] arr, int si, int ei) {
		// TODO Auto-generated method stub
		if (si>ei)
            return null;
        
        int mid=(si+ei)/2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr[mid]);
        
        root.left=SortedArrayToBSTHelper(arr,si,mid-1);
        root.right=SortedArrayToBSTHelper(arr,mid+1,ei);
        return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] arr= {1,2,3,4,5,6,7};
       BinaryTreeNode<Integer> root= SortedArrayToBST(arr, arr.length);
       TakeInputLevelWise.printLevelWise(root);
	}

}
