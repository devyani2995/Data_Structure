package graphs;
import java.util.*;
public class IsConnected {
	 public static boolean isConnected(int[][] edges){
			if(edges.length==0)
				   return true;
			
	        boolean[] visited=new boolean[edges.length];
	        DFS(edges,0,visited);
	        for(boolean elem:visited)
	        {
	            if(elem==false)
	                return false;
	        }
	        return true;
	 }
	 public static void  DFS(int[][] edges,int startver,boolean[] visited){
	        visited[startver]=true;
	        for(int i=0;i<edges.length;i++){
	            if(edges[startver][i]==1 && !visited[i]){
	                visited[i]=true;
	                DFS(edges,i,visited);

	            }
	        }
	        return ;
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
	        boolean ans=isConnected(edges);
	        System.out.println(ans);
	}

}
