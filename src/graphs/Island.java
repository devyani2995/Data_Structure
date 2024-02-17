/*
 * An island is a small piece of land surrounded by water . A group of islands is said to 
 * be connected if we can reach from any given island to any other island in the same group .
 *  Given V islands (numbered from 0 to V-1) and E connections or edges between islands. 
 *  Can you count the number of connected groups of islands.
 *  
Sample Input 1:
5 8
0 1
0 4
1 2
2 0
2 4
3 0
3 2
4 3

Sample Output 1:
1 
 */

package graphs;
import java.util.*;
public class Island {
	 public static void BFS(int edges[][], int sv,boolean visited[]){
	       Queue<Integer> q = new LinkedList<>();
	       q.add(sv);
	       visited[sv]=true;
	       while(q.size()!=0){
	           int firstelem = q.remove();
	        //    System.out.print(firstelem+" ");
	           for(int i=0; i<edges.length; i++){
	               if(edges[firstelem][i]==1 && !visited[i]){
	                   q.add(i);
	                   visited[i]=true;
	               }       
	           }
	       }   
	   }
	// This function returns number islands (connected
	// components) in a graph. It simply works as
	// BFS for disconnected graph and returns count
	// of BFS calls.
	public static int numConnected(int[][] edges, int n) {
	        
		// Call BFS for every unvisited vertex
	    // Whenever we see an univisted vertex,
	    // we increment count (number of islands)
	    // also.
			int count=0;
	       boolean visited[] = new boolean[n];
	       for(int i=0; i< n; i++){
	           if(!visited[i]){
	               BFS(edges, i, visited);   
				   count++;
	           }
	       }
		   return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner s = new Scanner(System.in);
	        int V = s.nextInt();
	        int E = s.nextInt();
	        int edges[][]=new int[V][V];
	        for(int i=0;i<E;i++){
	            int sv=s.nextInt();
	            int ev=s.nextInt();
	            edges[sv][ev]=1;
	            edges[ev][sv]=1;
	        }
	        
	        System.out.println(numConnected(edges, edges.length));
	}

}
