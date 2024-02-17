/*
 * For the given infinite supply of coins of each of denominations, D = {D0, D1, D2, D3, ...... Dn-1}. 
 * You need to figure out the total number of ways W, in which you can make the change for Value V using coins 
 * of denominations D.
Return 0 if the change isn't possible.
Sample Input 1 :
3
1 2 3
4
Sample Output 1 :
4
Explanation to Sample Input 1 :
Number of ways are - 4 total i.e. (1,1,1,1), (1,1, 2), (1, 3) and (2, 2).
 */
package DP2;

public class CoinChange {
	public static int countWaysToMakeChange(int denominations[], int value){
        // Write your code here
		 int[] dp = new int[value+1];
        dp[0]=1;
        for (int i=0;i<denominations.length;i++)
        {
            for (int j=0;j<=value;j++)
            {
                if (j>=denominations[i])
                {
                    dp[j]=dp[j]+dp[j-denominations[i]];
                }
            }
        }
        return dp[value];
	}
	public static void main(String[] args) {
		int deno[]= {1,2,3};
		int val=4;
        System.out.println(countWaysToMakeChange(deno, val));
	}

}
