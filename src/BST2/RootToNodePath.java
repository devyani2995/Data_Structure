package BST2;
import java.util.*;
import binary_tree.BinaryTreeNode;
import binary_tree.TakeInputLevelWise;
public class RootToNodePath {
	public static ArrayList<Integer> nodeToRootPath(BinaryTreeNode<Integer> root, int x){
        if(root==null){
            return null;
        }

        if(root.data==x){
            ArrayList<Integer> output= new ArrayList<Integer>();
            output.add(root.data);
            return output;
        }
        ArrayList<Integer> leftOutput= nodeToRootPath(root.left,x);
        if(leftOutput!=null){
            leftOutput.add(root.data);
            return leftOutput;
        }

        ArrayList<Integer> rightOutput= nodeToRootPath(root.right,x);
        if(rightOutput!=null){
            rightOutput.add(root.data);
            return rightOutput;
        }
        return null;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root=TakeInputLevelWise.takeInputLevelWise();
		ArrayList<Integer> path= nodeToRootPath(root,1);
		if(path == null) {
			System.out.println("not found");
		}else {
	        for(int i:path){
	            System.out.println(i);
	        }
		}
	}

}
