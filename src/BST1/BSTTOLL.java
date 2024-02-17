package BST1;

import Test5.LinkedListNode;
import Test5.replaceDupicateValue;
import binary_tree.BinaryTreeNode;
import binary_tree.TakeInputLevelWise;

public class BSTTOLL {
    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root){
    	return null; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root=TakeInputLevelWise.takeInputLevelWise();
		LinkedListNode<Integer> head = constructLinkedList(root);
		replaceDupicateValue.print(head);
	}

}
