package Tree;
import java.util.*;
import binary_tree.BinaryTreeNode;
import queue.QueueUsingLL;


public class TreeTest {
	
	private static class Pair{
	    TreeNode<Integer> node;
	    int sum;
	    Pair(TreeNode<Integer>node,int sum){
	        this.node=node;
	        this.sum=sum;
	    }
	}
	//take input levelwise
    public static TreeNode<Integer> takeInput(){
      Scanner sc=new Scanner(System.in);
      QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();
      System.out.println("enter the root data");
      int rootData = sc.nextInt();
      
      if(rootData == -1) {
    	  return null;
      }
      
      TreeNode<Integer> root = new TreeNode<Integer>(rootData);
      pendingNodes.enqueue(root);
    
      while(!pendingNodes.isEmpty()) {
    	  TreeNode< Integer> front = pendingNodes.dequeue();
    	  System.out.println("enter the no. of children for: "+front.data);
    	  int numChild = sc.nextInt();
    	  for(int i=0;i<numChild;i++) {
    		  System.out.println("enter the " + i + "th child data for: " + front.data);
    		  int childData=sc.nextInt();
    		  TreeNode<Integer> childNode = new TreeNode<Integer>(childData);
    		  front.children.add(childNode);//connect child to the parent
    		  pendingNodes.enqueue(childNode); //add in the queue
    	  }
      }
      
      return root;
    }
    
	//sum of all nodes
	public static int sumOfAllNode(TreeNode<Integer> root){
		   if(root==null) 
			   return 0;
		    int result = root.data; // root node
		    int childCount = root.children.size();
		    for(int i=0; i<childCount; i++)
		        result += sumOfAllNode(root.children.get(i));
		    return result;
	}
	
	//num of nodes
	public static int numOfNodes(TreeNode<Integer> root) {
		int count =1;
		for(int i=0;i<root.children.size();i++) {
			 int childCount = numOfNodes(root.children.get(i));
			 count =count + childCount;
		}
		
		return count;
	}
	
	//print in a preorder way
	//there is no base case
	//base case is handled in for loop but its not visible
    public static void printTree(TreeNode<Integer> root) {
    	//special case but not base case
    	if(root.data == null) {
    		return;
    	}
    	System.out.print(root.data+": ");
    	for(int i=0;i<root.children.size();i++) {
    		System.out.print(root.children.get(i).data + " ");
    	}
    	System.out.println();
    	for(int i=0;i<root.children.size();i++) {
    		TreeNode<Integer> child = root.children.get(i);
    		printTree(child);
    	}
    }
    
    // Iterative method to do level order traversal line by
    // line
	public static void printLevelWise(TreeNode<Integer> root){
		// Base Case
        if (root == null)
            return;
 
        Queue<TreeNode<Integer>> mainQueue = new LinkedList<>();
        mainQueue.add(root);
        
        Queue<TreeNode<Integer>> childQueue = new LinkedList<>();
        
        while(mainQueue.size() > 0) {
        	root = mainQueue.remove();
        	System.out.print(root.data+ " ");
        	
        	for(TreeNode<Integer> child:root.children) {
        		childQueue.add(child);
        	}
        	
        	if(mainQueue.size()==0) {
        		mainQueue = childQueue;
        		childQueue = new LinkedList<>();
        		System.out.println();
        	}
        }
 
        
	}
	
	//find number of nodes > x
	public static int numNodeGreater(TreeNode<Integer> root,int x){
		if (root == null)
	        return 0;
	 
	    int count = 0;
	 
	    // If current root is greater
	    // than x increment count
	    if (root.data > x)
	        count++;	
        
	    // Recursively calling for every
	    // child of current root
	    for(TreeNode<Integer> child : root.children)
	    {
	        count += numNodeGreater(child, x);
	    }
	 
	    // Return the count
	    return count;
	}
    
	//find height of a tree
	public static int getHeight(TreeNode<Integer> root){
     int height=0;
     
     for(TreeNode<Integer> child:root.children) {
    	 int childHeight = getHeight(child);
    	 height = Math.max(childHeight, height);
     }
     height += 1;
     
     return height;
		
	}
	
	//find no. of leaf nodes
	public static int countLeafNodes(TreeNode<Integer> root){
		    int count = 0;
	        
		    if (root == null ){
		       return 0;
		    }
		    
		    if (root.children.size() == 0){
		       count++;
		    }
		    
		    for (TreeNode<Integer> child : root.children){
		     count += countLeafNodes(child);
		   	}
		         
		    return count ;
		        
	}
	
	public static void postOrder(TreeNode<Integer> root){
	
        if(root.children.size()==0){
            System.out.print(root.data+" ");
        	return;
        }
        
        for(TreeNode<Integer> child:root.children){
            postOrder(child);
        }
        
        System.out.print(root.data+" ");      
	}
	 
	//Check if generic tree contain element x
	private static boolean isPresent=false;
    public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
	        if(root == null){
	            return isPresent;
	        }
	       if(root.data == x){
	           isPresent=true;
	           return isPresent;
	       }
	       
	        for(int i=0;i<root.children.size();i++){
	            isPresent=checkIfContainsX(root.children.get(i),x);
	        }
	        
	        return isPresent;
	}
    
    
    private static ArrayList<Pair> a1=new ArrayList<>();
    private static int maxSum=Integer.MIN_VALUE;
    private static Pair maxPair;
    
    
	private static Pair maxPairfn(TreeNode<Integer>root){
        int allsum=root.data;
        
        for(int i=0;i<root.children.size();i++){
            allsum+=root.children.get(i).data;
        }
        
        Pair result=new Pair(root,allsum);
        a1.add(result);
        
        for(int i=0;i<root.children.size();i++){
            maxPairfn(root.children.get(i));
        }
        
        for(int i=0;i<a1.size();i++){
            if(a1.get(i).sum>maxSum){
                maxSum=a1.get(i).sum;
                maxPair=a1.get(i);
            }
        }
        return maxPair;
    }
    
	//Node having sum of children and node is max
	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		Pair result=maxPairfn(root);
        return result.node;
	}
	
    private static ArrayList<Integer> storeNodeToArraylit(TreeNode<Integer> root,ArrayList<Integer> a){
        a.add(root.data);
        for(int i=0;i<root.children.size();i++){
            storeNodeToArraylit(root.children.get(i),a);
        }
        return a;
    }
    //Given two Generic trees, return true if they are structurally identical 
    //i.e. they are made of nodes with the same values arranged in the same way.
	public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){
		ArrayList<Integer> a1=new ArrayList<>();
            a1=storeNodeToArraylit(root1,a1);
        ArrayList<Integer> a2=new ArrayList<>();
            a2=storeNodeToArraylit(root2,a2);
        
        if(a1.size() > a2.size()  || a1.size() < a2.size()){
            return false;
        }else{
            for(int i=0;i<a1.size();i++){
                if(a1.get(i) != a2.get(i)){
                    return false;
                }
            }
            return true;
        }
        
	}
	
	static TreeNode<Integer> res =null; 
	 static void nextLargerElementUtil(TreeNode<Integer> root, int x){ 
	    if (root == null){
	        return;
	    }
	  
	    // if root is less than res but  
	    // greater than x, update res 
	    if (root.data > x){
	        if (res==null || root.data<res.data)
	        {
	            res = root; 
	        }
	    }
	  
	    // Number of children of root 
	    int numChildren = root.children.size(); 
	  
	    // Recur calling for every child 
	    for (int i = 0; i < numChildren; i++) 
	    {
	        nextLargerElementUtil(root.children.get(i),x); 
	    }  
	 } 
	//Given a generic tree and an integer n. 
	//Find and return the node with next larger element in the Tree i.e. find a node with value just greater than n.
	public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
	    nextLargerElementUtil(root,n); 
        //System.out.println(res);
       
        return res; 

	}
	
	private static TreeNode<Integer>largest=new TreeNode<>(Integer.MIN_VALUE);
    private static TreeNode<Integer>secondLargest=new TreeNode<>(Integer.MIN_VALUE);
    
    //find second largest
	public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
        if(root.data>largest.data){
            if(largest.data != Integer.MIN_VALUE){
                secondLargest=largest;
            }
            largest=root;
        }else if(root.data>secondLargest.data && root.data<largest.data){
            secondLargest=root;
        }
        
        for(int i=0;i<root.children.size();i++){
            findSecondLargest(root.children.get(i));
        }
        return secondLargest;
	}
	
	private static void replace(TreeNode<Integer>root,int depth){
        root.data=depth;
        
        for(int i=0;i<root.children.size();i++){
            replace(root.children.get(i),depth+1);
        }
    }
	
	//Replace node with depth
	public static void replaceWithDepthValue(TreeNode<Integer> root){
        int depth=0;
        replace(root,depth);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//      TreeNode<Integer> root = new TreeNode<Integer>(4);
//      TreeNode<Integer> n1 = new TreeNode<Integer>(2);
//      TreeNode<Integer> n2 = new TreeNode<Integer>(3);
//      TreeNode<Integer> n3 = new TreeNode<Integer>(1);
//      TreeNode<Integer> n4 = new TreeNode<Integer>(5);
//      TreeNode<Integer> n5 = new TreeNode<Integer>(6);
//      
//      root.children.add(n1);
//      root.children.add(n2);
//      root.children.add(n3);      
//      n2.children.add(n4);
//      n2.children.add(n5);
		
		TreeNode<Integer> root = takeInput();
//		TreeNode<Integer> ans = findSecondLargest(root);
//		System.out.println(ans.data);
		replaceWithDepthValue(root);
		printLevelWise(root);
//		TreeNode<Integer> ans =maxSumNode(root);
//		if(ans == null){
//			System.out.println(Integer.MIN_VALUE);
//		}else{
//			System.out.println(ans.data);
//		}
//		printLevelWise(root);

		
		
        
	}
}