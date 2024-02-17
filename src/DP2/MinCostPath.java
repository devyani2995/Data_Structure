package DP2;

public class MinCostPath {
	
	private static int minCostPathHelper(int cost[][],int i,int j) {
		int m=cost.length;
		int n=cost[0].length;
		
		//Special case
		if(i==m-1 && j==n-1) {
			return cost[i][j];
		}
		//Base
		if(i>=m || j>=n) {
			return Integer.MAX_VALUE;
		}
		int ans1=minCostPathHelper(cost, i+1, j); //down
		int ans2=minCostPathHelper(cost,i,j+1); //to the right
		int ans3 = minCostPathHelper(cost, i+1, j+1); //to the diagonal
		
		int myAns = cost[i][j]+Math.min(ans1, Math.min(ans2, ans3));
		
		return myAns;
	}

	//-------memoization---------
    public static int minCostPath2(int[][] cost, int i, int j, int[][] dp) {
          int m = cost.length;
          int n = cost[0].length;
          
          // Special Case 
          if(i==m-1 && j==n-1) {
             return cost[i][j];
          }
          
          // Base Case 
          if(i>=m | j>=n) {
            return Integer.MAX_VALUE;
          }
          
          int ans1, ans2, ans3;
          
          if (dp[i+1][j] == Integer.MIN_VALUE) {
            ans1 = minCostPathHelper(cost, i+1, j);
            dp[i+1][j] = ans1; 
          }else{
             ans1 = dp[i+1][j];
          }
          
         if(dp[i][j+1] == Integer.MIN_VALUE) {
            ans2 = minCostPathHelper(cost, i, j+1);
            dp[i][j+1] = ans2;
         }else{
            ans2 = dp[i][j+1];
         }
         
         if (dp [i+1] [j+1] == Integer.MIN_VALUE) {
            ans3 = minCostPathHelper(cost,i+1, j+1);
            dp [i+1] [j+1] = ans3; 
         }else{
            ans3 = dp[i+1] [j+1];
         }
         int myAns = cost[i][j] + Math.min(ans1, Math.min(ans2, ans3));
         return myAns;
    }
	//------recursive-------
	public static int minCostPath(int[][] input) {
		return minCostPathHelper(input,0,0);
	}
	
	//----------iterartive--------
	public static int minCostPath3(int[][] cost) {
		//Find number of rows m  and number of cols n
				int m=cost.length;
				int n=cost[0].length;
						
				//Create (m+1) * (n+1) dp matrix with all values = infinity
				int[][] dp = new int[m+1][n+1];
				for (int i=0;i<dp.length;i++)
				{
					for (int j=0;j<dp[0].length;j++)
					{
						//We initialize each element as -infinity as the cost can be any positive or negative value (including +infinity)
						dp[i][j]=Integer.MAX_VALUE;
					}
				}
				
				//We start filling the minimum cost values for elements from (m-1,n-1) to (0,0)
				for (int i=m-1;i>=0;i--)
				{
					for (int j=n-1;j>=0;j--)
					{
						//Handle special case for i=m-1, j=n-1
						if (i==m-1 && j==n-1)
						{
							dp[i][j]=cost[i][j];
							continue;
						}
						int ans1=dp[i+1][j];
						int ans2=dp[i][j+1];
						int ans3=dp[i+1][j+1];
						
						dp[i][j]=cost[i][j]+Math.min(ans1, Math.min(ans2, ans3));
					}
				}
				return dp[0][0];	
	}
	public static void main(String[] args) {
		int cost[][]= {{1,5,11},{8,13,12},{2,3,7},{15,16,18}};
//        System.out.println(minCostPath(cost));
		
//		int[][] dp = new int[cost.length+1] [cost[0]. length+1];
//		for(int i=0;i<dp.length; i++) {
//		for(int j=0; j<dp[0].length; j++) {
//		dp[i][j] = Integer.MIN_VALUE;
//		}
//		}
//		int ans= minCostPath2(cost,0,0,dp);
//		System.out.println(ans);
		
		System.out.println(minCostPath3(cost));
	}

}
