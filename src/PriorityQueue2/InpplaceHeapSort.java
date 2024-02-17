package PriorityQueue2;

public class InpplaceHeapSort {
	 //Down-heapify for min. heap order property
		private static void downHeapify(int[] arr, int i, int n)
		{
			int parentIndex=i;
			int leftChildIndex=2*parentIndex+1, rightChildIndex=2*parentIndex+2;
			
			while(leftChildIndex<n)
			{
				int minIndex=parentIndex;
				if(arr[minIndex]>arr[leftChildIndex])
					minIndex=leftChildIndex;
				
				if(rightChildIndex<n && arr[minIndex]>arr[rightChildIndex])
					minIndex=rightChildIndex;
				
				if(minIndex==parentIndex)
					return;
				
				int temp=arr[parentIndex];
				arr[parentIndex]=arr[minIndex];
				arr[minIndex]=temp;
				
				parentIndex=minIndex;
				leftChildIndex=2*parentIndex+1;
				rightChildIndex=2*parentIndex+2;
				
			}
		}
	private static void heapSort(int[] arr) {
		int n=arr.length;
		//Step 1 - Build heap using optimized method with time complexity O(n)
		for(int i=(n/2)-1;i>=0;i--)
		{
			//Perform down-heapify operation for node at index i, starting at index i and going to down to the last node (end of arr)
			downHeapify(arr,i,n);
		}
		//Step 2 - Perform remove minimum element, put them at respective last position in the heap 
		//and heap re-balancing until all the elements are out of the heap
		
		for(int i=n-1;i>=0;i--)
		{
			int temp=arr[i];
			arr[i]=arr[0];
			arr[0]=temp;
			
			//Apply down-heapify from index 0 to index i
			downHeapify(arr,0,i);
		}
	}
	public static void main(String[] args) {
		int arr[]= {4,7,3,2,8,9,6,1};
		heapSort(arr);
		System.out.println("Element after sorting:-");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}		
}