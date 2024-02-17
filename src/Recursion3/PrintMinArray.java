package Recursion3;

public class PrintMinArray {
    public static int minArrayReturn(int arr[],int startIndex) {
    	//base case
    	if(startIndex == arr.length) {
    		return Integer.MAX_VALUE;
    	}
    	
    	int minSmallArray = minArrayReturn(arr, startIndex + 1);
    	if(arr[startIndex] < minSmallArray)
    		return arr[startIndex];
    	else 
    		return minSmallArray;
    }
    
    public static void printMinArray1(int arr[]) {
    	int min = minArrayReturn(arr,0);
    	System.out.println(min);
    }
    
    public static void printMinArray2(int a[],int startIndex,int minSoFar){
    	if(startIndex == a.length) {
    		System.out.println(minSoFar);
    		return;
    	}
    	
    	int newMin = minSoFar;
    	if(a[startIndex] < minSoFar)
    	  newMin = a[startIndex];
    	
    	printMinArray2(a,startIndex + 1,newMin);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int arr[]= {23,6,7,1,2,8};
//       System.out.println(minArrayReturn(arr,0));
//       printMinArray1(arr);
       System.out.println("Min array");
       printMinArray2(arr,0,Integer.MAX_VALUE);
	}

}
