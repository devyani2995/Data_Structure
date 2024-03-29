/* Given two strings S and T with lengths M and N. Find and return the length of their shortest 'Super Sequence'.
 The shortest 'Super Sequence' of two strings is defined as the smallest string possible that will have both the 
 given strings as its subsequences.
Note :
If the two strings do not have any common characters, then return the sum of the lengths of the two strings.  
Sample Input 1 :
ab
ac
Sample Output 1 :
3
Explanation of Sample Output 1 :
Their smallest super sequence can be "abc" which has length = 3.
Sample Input 2 :
pqqrpt
qerepct
Sample Output 2 :
9
 */
package DP2;

public class SmallestSuperSequence {
	public static int smallestSuperSequence(String str1, String str2) {

         int n1=str1.length();
        int n2=str2.length();
        
        int[][] dp = new int[n1+1][n2+1];
        for (int i=n1;i>=0;i--)
        {
            dp[i][n2]=n1-i;
        }
        for (int i=n2;i>=0;i--)
        {
            dp[n1][i]=n2-i;
        }
        
        for (int i=n1-1;i>=0;i--)
        {
            for (int j=n2-1;j>=0;j--)
            {
                if(str1.charAt(i)==str2.charAt(j))
                {
					dp[i][j]=dp[i+1][j+1]+1;
                }
                else
                {
                    
                    int ans1=dp[i+1][j];
                    int ans2=dp[i][j+1];
                    
                    dp[i][j]=Math.min(ans1,ans2)+1;
                }
            }
        }
        
        return dp[0][0];
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String str1="ab";
        String str2="ac";
        System.out.println(smallestSuperSequence(str1, str2));
	}

}
