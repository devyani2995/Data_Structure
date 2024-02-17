/*
 * Given a NxM matrix containing Uppercase English Alphabets only. Your task is to tell if there is a path in the given matrix which 
 * makes the sentence “CODINGNINJA” .
There is a path from any cell to all its neighbouring cells. For a particular cell, neighbouring cells are those cells that share an 
edge or a corner with the cell.

Input Format :
The first line of input contains two space separated integers N and M, where N is number of rows and M is the number of columns in 
the matrix. 
Each of the following N lines contain M characters. Please note that characters are not space separated.

Output Format :
Print 1 if there is a path which makes the sentence “CODINGNINJA” else print 0.

Sample Input 1:
2 11
CXDXNXNXNXA
XOXIXGXIXJX
Sample Output 1:
1
 */
package graphs;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class PathInCodingNinja {
	 public static boolean dfs(String[] graph, boolean[][] visited, String searchString,int i,int j) {

			if(searchString.length() == 0) {
				visited[i][j] = true;
				return true;
			}

			visited[i][j] = true;
			// To traverse in 8 different directions
			int[] X_Dir = {-1,1,0,0,1,-1,1,-1 };
			int[] Y_Dir = {0,0,-1,1,1,-1,-1,1 };

			for(int k=0;k<X_Dir.length;k++) {

				int x = i+ X_Dir[k];
				int y = j+ Y_Dir[k];

				if( x>=0 && y>=0 && x< graph.length &&
						y < graph[x].length() && 
						graph[x].charAt(y) ==searchString.charAt(0) && !visited[x][y]  ) {

					boolean smallAns = dfs(graph, visited, searchString.substring(1), x, y);
					if(smallAns) {
						return smallAns;
					}
					
				}


			}
			
			visited[i][j] = false;
			return false;
	}
	public static int solve(String[] Graph , int N, int M){
	        
			String searchingString = "CODINGNINJA";
			boolean[][] visited = new boolean[Graph.length][];

			for(int i=0;i<Graph.length;i++) { 
				visited[i] = new boolean[Graph[i].length()];
			}

			for(int i=0;i<Graph.length;i++) {

				for(int j=0;j<Graph[i].length();j++) {
					if(Graph[i].charAt(j) == 'C' ) {
						
						boolean ans =  dfs( Graph,visited,searchingString.substring(1),i,j);
						if(ans) {
							return 1;
						}
	                   

					}
				}

			}
			return 0;
	}
	  
	    
	    public static String[] takeInput() throws IOException {
	    	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
			String[] strNums;
	        strNums = br.readLine().split("\\s");
	        int size = 2;
	        int[] input = new int[size];
	        for (int i = 0; i < size; ++i) {
	            input[i] = Integer.parseInt(strNums[i]);
	        }


			String[] Graph = new String[input[0]];
			
	        for (int i = 0; i < input[0]; ++i) {
	            Graph[i] = br.readLine();
	        }

	        return Graph;
	    }
	public static void main(String[] args) throws NumberFormatException,IOException {
		// TODO Auto-generated method stub
		   String[] Graph = takeInput();
	        System.out.println(solve(Graph,Graph.length,Graph[0].length()));
	}

}