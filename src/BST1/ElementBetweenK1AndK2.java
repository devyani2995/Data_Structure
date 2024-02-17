package BST1;

import binary_tree.BinaryTreeNode;
import binary_tree.TakeInput;

public class ElementBetweenK1AndK2 {
	
	public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){
	     if (root == null) 
		   return;

         if (root.data < k1) {
   	     elementsInRangeK1K2(root.right, k1, k2);
       } else if (root.data > k2) {
   	     elementsInRangeK1K2(root.left, k1, k2);
       } else {
   	       elementsInRangeK1K2(root.left, k1, k2);
           System.out.print(root.data + " ");
           elementsInRangeK1K2(root.right, k1, k2);
       }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   BinaryTreeNode<Integer> root=TakeInput.takeTreeInputBetter(true, 0, true);
		   elementsInRangeK1K2(root,6,10);
	}

}
