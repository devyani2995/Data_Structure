/*
 * Given an integer array (of length n), find and return all the subsets of input array.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in 
the input array.

Note :
The order of subsets are not important.
 */
package Recursion3;
public class ReturnSubsetOfAnArray {
	 private static int[][] subsets(int input[],int si) {
	        if(si>=input.length){
	            int ans[][]=new int[1][0];
	            return ans;
	        }
	        int[][] smallans=subsets(input,si+1);
	        int[][] ans=new int[smallans.length*2][];
	        int k=0;
	        for(int i=0;i<smallans.length;i++){
	            ans[i]=new int[smallans[i].length];
	            for(int j=0;j<smallans[i].length;j++){
	                ans[i][j]=smallans[i][j];
	            }
	            k++;
	        }

	        for(int i=0;i<smallans.length;i++){ 
				ans[k+i]=new int[smallans[i].length+1];
	          ans[k+i][0]=input[si];
	            for(int j=1;j<=smallans[i].length;j++){
	                ans[i+k][j]=smallans[i][j-1];
	            } 
	        }
	        return ans;
	    }
		
		// Return a 2D array that contains all the subsets
		public static int[][] subsets(int input[]) {
			// Write your code here
	        return subsets(input,0);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int arr[] = {15,20,12};
       int output[][] = subsets(arr);
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}

}
