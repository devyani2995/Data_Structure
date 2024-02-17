package DP2;

public class Knapsack {
	
	//---------recursive------
	private static int knapsack(int W, int[] val, int[] wt, int i) {
		if(i==val. length) {
			return 0;
		}
		
		int ans;
		if(wt[i] <= W) {
			//including ith item
			int ans1=val[i]+knapsack(W-wt[i], val, wt, i+1);
			
			//excluding ith item
			int ans2=knapsack(W, val, wt, i+1);
			ans=Math.max(ans1, ans2);
		}else {
			ans=knapsack(W, val, wt, i+1);
		}
		
		return ans;
	}
	
	//-------iterative-----
	public static int knapsackI(int W, int[] val, int[] wt) {
		
		int n=val.length;
		int[][] dp=new int[n+1][W+1];
		for (int i=n-1;i>=0;i--)
		{
			for (int w=0;w<=W;w++)
			{
				if (wt[i]<=w)
				{
					int ans1=dp[i+1][w];
					int ans2=dp[i+1][w-wt[i]] + val[i];
					dp[i][w]=Math.max(ans1, ans2);
				}
				else
				{
					dp[i][w]=dp[i+1][w];
				}
			}
		}
		return dp[0][W];
	}
	public static void main(String[] args) {
		
		int val[]= {200,300,100};
		int wt[]= {20,25,30};
		int W=50;
//		System.out.println(knapsack(W,val,wt,0));
		System.out.println(knapsackI(W,val,wt));

	}
}
