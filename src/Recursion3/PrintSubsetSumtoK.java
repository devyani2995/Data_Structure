package Recursion3;

public class PrintSubsetSumtoK {
	private static void helper(int input[],int si,int k,int output[]){
        if(si==input.length){
            if(k==0){
                for(int i=0;i<output.length;i++){
                    System.out.print(output[i]+" ");
                }
                System.out.println();
                return;
            }
            else
                return;
        }
        helper(input,si+1,k,output);
        int newoutput[]=new int[output.length+1];
        int i=0;
        for( ;i<output.length;i++){
            newoutput[i]=output[i];
        }
            newoutput[i]=input[si];
        helper(input,si+1,k-input[si],newoutput);
  
    }
	public static void printSubsetsSumTok(int input[], int k) {
		// Write your code here
        int output[]=new int[0];
        helper(input,0,k,output);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int arr[]= {5,12,3,17,1,18,15,3,17};
        int k=6;
        printSubsetsSumTok(arr,k);
	}

}
