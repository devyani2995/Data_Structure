package PriorityQueue2;

import java.util.*;

public class KLargestElement {
	private static void printKLargest(int[] arr, int k) {
		
		  PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		  //insert first k largest elemnt into the priority queue
		  for(int i=0;i<k;i++) {
			  pq.add(arr[i]);  
		  }
		  
//	       for(int i=k;i<arr.length;i++)
//	        {
//	            int minVal=pq.peek();
//	            if(minVal<arr[i])
//	                minVal=arr[i];
//	            if(minVal!=pq.peek())
//	            {
//	                pq.poll();
//	                pq.add(minVal);
//	            }
//	        }
//	       
//	       ArrayList<Integer> a = new ArrayList<Integer>();
//	        while(!pq.isEmpty())
//	            a.add(pq.poll());
//	        return a;
	       for(int i=k;i<arr.length;i++){
	          if(pq.peek()<arr[i]) {
	        	  pq.poll();
	        	  pq.add(arr[i]);
	          }
	       }
	       
	       while(!pq.isEmpty()) {
	    	   System.out.println(pq.poll());
	       }
		  
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int arr[]= {4,1,6,3,7,2,9,8};
       int k=3;
       printKLargest(arr,k);
	}
}
