package binary_tree;

public class BuildTreeUsingPreAndInOrder {
	public static BinaryTreeNode<Integer> buildTreePreInHelper(int pre[],int in[],int siPre,int eiPre,int siIn,int eiIn){
	   if(siPre > eiPre) //if siPre  cross eiPre then return null
		   return null;
	   
	   int rootData = pre[siPre];
	   BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootData);
	   
	   //search for root in inOrder
	   int rootIndex=-1;
	   for(int i=siIn;i<=eiIn;i++) {
		    if(in[i] == rootData) {
		    	rootIndex=i;
		    	break;
		    }
	   }
	   
	   int siPreleft=siPre + 1;
	   int siInLeft=siIn;	   
	   int eiInLeft=rootIndex - 1;  
	   int siInRight=rootIndex + 1;
	   int eiPreRight=eiPre;
	   int eiInRight=eiIn;
	   
	   int leftSubtreeLength = eiInLeft - siInLeft + 1;
	   int eiPreLeft=siPreleft + leftSubtreeLength - 1;
	   int siPreRight=eiPreLeft + 1;
	   
	   BinaryTreeNode<Integer> left=buildTreePreInHelper(pre, in, siPreleft, eiPreLeft, siInLeft, eiInLeft);
	   BinaryTreeNode<Integer> right =buildTreePreInHelper(pre, in, siPreRight, eiPreRight, siInRight, eiInRight);
	   
	   root.left =left;
	   root.right=right;
	   
	   return root;
	   
	}
	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
		//Your code goes here
		BinaryTreeNode<Integer> root =buildTreePreInHelper(preOrder, inOrder, 0, preOrder.length-1, 0, inOrder.length-1);
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pre[]= {1,2,4,5,3};
		int in[]= {4,2,5,1,3};
		
		BinaryTreeNode<Integer> root = buildTree(pre, in);
		TakeInput.printTreeDetailed(root);
	}
}