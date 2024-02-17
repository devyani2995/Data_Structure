package binary_tree;

public class buildTreeUsingInANdPostOrder {
	public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
		//Your code goes here
        BinaryTreeNode<Integer> root = buildTree(postOrder, inOrder, 0 ,postOrder.length-1, 0, inOrder.length-1);
    	return root;
	}
	private static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder,int siPost, int eiPost, int siIn, int eiIn) {
		// TODO Auto-generated method stub
		if (siPost>eiPost)
    	{
    		return null;
    	}
    	
    	//Defining the root node for current recursion
    	int rootData=postOrder[eiPost];
    	BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
    	
    	//Finding root data's location in Inorder (Assuming root data exists in Inorder)
    	int rootIndex=-1;
    	for (int i=siIn;i<=eiIn;i++)
    	{
    		if (rootData==inOrder[i])
    		{
                rootIndex=i;
    			break;
    		}
    	}
    	    	
    	//Defining index limits for Left Subtree Inorder
    	int siInLeft=siIn;
    	int eiInLeft=rootIndex-1;
    	
    	//Defining the index limits for Left Subtree Preorder
    	int siPostLeft=siPost;
    	int leftSubTreeLength = eiInLeft - siInLeft + 1;
    	int eiPostLeft=(siPostLeft)+(leftSubTreeLength-1);
    	
    	//Defining index limits for Right Subtree Inorder
    	int siInRight=rootIndex+1;
    	int eiInRight=eiIn;
    	
    	//Defining index limits for Right Subtree Preorder
    	int siPostRight=eiPostLeft+1;
    	int eiPostRight=eiPost-1;
    	
        BinaryTreeNode<Integer> rightChild = buildTree(postOrder, inOrder, siPostRight, eiPostRight, siInRight, eiInRight);
    	BinaryTreeNode<Integer> leftChild = buildTree(postOrder, inOrder, siPostLeft, eiPostLeft, siInLeft, eiInLeft);
    	
    	root.left=leftChild;
    	root.right=rightChild;
    	return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int post[]= {4,5,2,3,1};
		int in[]= {4,2,5,1,3};
		
		BinaryTreeNode<Integer> root = buildTree(post, in);
		TakeInput.printTreeDetailed(root);
	}

}
