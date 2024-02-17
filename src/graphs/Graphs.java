package graphs;
import java.util.*;
public class Graphs {
	public static void dftTraversal(int[][] adjMatrix,int currentVertex,boolean[] visited) {
		   visited[currentVertex]=true;
	    	System.out.print(currentVertex + " ");
	    	//figure out the neighbor of current vertex
	    	for(int i=0;i<adjMatrix.length;i++) {
	    		if(adjMatrix[currentVertex][i] == 1 && visited[i] == false) {
	    			//i is a neighbor of current vertex
	    			dftTraversal(adjMatrix,i,visited);
	    		}
	    	}
	}
	//------DFS-------
    public static void dftTraversal(int[][] adjMatrix) {
    	boolean visited[]=new boolean[adjMatrix.length];
    	for(int i=0;i<adjMatrix.length;i++) { //for loop req. for diconnected graph
    	  if(!visited[i]) {	
    	   dftTraversal(adjMatrix,i,visited);
//    	   System.out.println();
    	  }
    	}
    }
    
    //------BFS------
    public static void bfTraversal(int[][] adjMatrix) {
    	Queue<Integer> pendingVertices = new LinkedList<>();
    	boolean visited[]=new boolean[adjMatrix.length];
    	visited[0]=true;
    	pendingVertices.add(0);
    	while(!pendingVertices.isEmpty()) {
    		int currentVertex = pendingVertices.poll();
    		System.out.print(currentVertex + " ");
    		for(int i=0;i<adjMatrix.length;i++) {
    			if(adjMatrix[currentVertex][i] == 1 && !visited[i]) {
    				//i is unvisited neighbor of current vertex
    			    pendingVertices.add(i);	
    			    visited[i]=true;
    			}
    		}
    	}
    }
    
//    public static void printHelper(int edges[][], int sv,boolean visited[]){
//        Queue<Integer> q = new LinkedList<>();
//        q.add(sv);
//        visited[sv]=true;
//        while(q.size()!=0){
//            int firstelem = q.remove();
//            System.out.print(firstelem+" ");
//            for(int i=0; i<edges.length; i++){
//                if(edges[firstelem][i]==1 && !visited[i]){
//                    q.add(i);
//                    visited[i]=true;
//                }       
//            }
//        }   
//    }
//    we have to deal with connected and non connected graph
//    public static void print(int edges[][]){
//        boolean visited[] = new boolean[edges.length];
//        for(int i=0; i< edges.length; i++){
//            if(!visited[i]){
//                printHelper(edges, i, visited);   
//            }
//        }
//    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int e=sc.nextInt();
		
		int[][] adjMatrix=new int[n][n];
		for(int i=0;i<e;i++) {
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			adjMatrix[v1][v2]=1;
			adjMatrix[v2][v1]=1;
		}
		System.out.println("Adj. Matrix:-");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(adjMatrix[i][j]);
			}
			System.out.println();
		}
		
		dftTraversal(adjMatrix);
//		bfTraversal(adjMatrix);
	
//		Scanner s = new Scanner(System.in);
//		int V = s.nextInt();
//		int E = s.nextInt();
//        int edges[][] = new int[V][V];
//        for(int i =0; i< E; i++){
//            int fv = s.nextInt();
//            int sv = s.nextInt();
//            edges[fv][sv] = 1;   
//            edges[sv][fv] =1;
//        }
//        print(edges);
	}

}
