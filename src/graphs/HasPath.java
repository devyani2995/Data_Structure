package graphs;
import java.util.*;
public class HasPath {
	public static boolean hasPathBFS(int adjMatrix[][], int i, int b, boolean vis[]){

		Queue<Integer> q = new LinkedList<Integer>();

		if(i == b){
			return true;
		}

		q.add(i);
		vis[i] = true;

		while(!q.isEmpty()){
			int curr = q.remove();

			for(int j=0;j<adjMatrix.length;j++){
				if(adjMatrix[curr][j] == 1 && vis[j] == false){

					if(j == b){
						return true;
					}

					q.add(j);
					vis[j] = true;
				}
			}
		}

		return false;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();

		int adjMatrix[][] = new int[v][v];

		for(int i=0;i<e;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();

			adjMatrix[x][y] = 1;
			adjMatrix[y][x] = 1;
		}

		int a = sc.nextInt();
		int b = sc.nextInt();

		boolean vis[] = new boolean[adjMatrix.length];

		// boolean path = hasPath(adjMatrix,a,b,vis);
		boolean path = hasPathBFS(adjMatrix,a,b,vis);
		
		System.out.println(path);
	}

}
