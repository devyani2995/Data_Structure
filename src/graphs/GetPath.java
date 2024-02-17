package graphs;
import java.util.*;
public class GetPath {
	//------Get Path BFS-------
	public static ArrayList<Integer> getPathBFS(int[][] adjMatrix,int s,int e){
		Queue<Integer> pendingVertices =new LinkedList<>();
		HashMap<Integer, Integer> map=new HashMap<>();
		boolean visited[]=new boolean[adjMatrix.length];
		visited[s]=true;
		pendingVertices.add(s);
		map.put(s, -1);
		boolean pathFound = false;
		
		while(!pendingVertices.isEmpty()) {
			int currentVertex = pendingVertices.poll();
			for(int i=0;i<adjMatrix.length;i++) {
				if(adjMatrix[currentVertex][i]==1 && !visited[i]) {
					pendingVertices.add(i);
					visited[i]=true;
					map.put(i, currentVertex);
					if(i==e) {
						//path found
						pathFound=true;
						break;
					}
				}
			}
		}
		
		if(pathFound) {
			ArrayList<Integer> path=new ArrayList<>();
			int currentVertex = e;
			while(currentVertex != -1){
			 path.add(currentVertex);
			 int parent = map.get(currentVertex);
			 currentVertex=parent;
			}
			
			return path;
		}else {
			return null;
		}
	}
	
	//------Get Path DFS-------
	public static ArrayList<Integer> getPathDFS(int[][] edges,boolean[] visited,int V1,int V2){
        if(V1==V2){
            ArrayList<Integer> ans=new ArrayList<>();
            visited[V1]=true;
            ans.add(V1);
            return ans;
        }
        visited[V1]=true;
        for(int i=0;i<edges.length;i++){
            if(edges[V1][i]==1 && !visited[i]){ 
                ArrayList<Integer> arr=getPathDFS(edges,visited,i,V2); 
                if(arr!=null){
                    arr.add(V1);

                    return arr;
                }
            }
        }
        return null;
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
	        int V1=s.nextInt();
	        int V2=s.nextInt();
	        boolean visited[]=new boolean[V];
	        ArrayList<Integer> ans=getPathDFS(edges,visited,V1,V2);
	        ArrayList<Integer> pathBfs=getPathBFS(edges, V1, V2);
	        if(ans!=null){
	          for(int elem:pathBfs){
	            System.out.print(elem+" ");
	          }
	        }
	}
}