package DP1;

public class Fibonacci {
	
	//without DP
    public static int fib(int n) {
    	if(n==0 || n==1)
    		return n;
    	int ans1=fib(n-1);
    	int ans2=fib(n-2);
    	
    	int myans=ans1 + ans2;
    	
    	return myans;
    	
    }
    
    //with DP
    public static int fib2(int n,int dp[]) {
    	if(n==0 || n==1)
    		return n;
    	
    	int ans1,ans2;
    	
    	if(dp[n-1] == -1) {
    		ans1=fib2(n-1,dp);
    		dp[n-1]=ans1;
    	}else {
    		ans1=dp[n-1];
    	}
    	
    	if(dp[n-2] == -1) {
    		ans2=fib2(n-2,dp);	
    		dp[n-2]=ans2;
    	}else {
    		ans2=dp[n-2];
    	}
    	
    	int myans=ans1 + ans2;
    	
    	return myans;
    	
    }
    
    //iterative DP
    public static int fib3(int n) {
    	if(n==0 || n==1)
    		return n;
    	
    	int[] dp=new int[n+1];
    	dp[0]=0;
    	dp[1]=1;
    	
    	for(int i=2;i<=n;i++) {
    		dp[i]=dp[i-1] + dp[i-2];
    	}
    	
    	return dp[n];
    } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(fib(6)); 
		int n=10;
		int[] dp=new int[n+1];
		for(int i=0;i<dp.length;i++) {
			dp[i]= -1;
		}
		int ans=fib2(n,dp);
		System.out.println(ans);
	}

}
