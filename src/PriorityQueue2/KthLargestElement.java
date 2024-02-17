package PriorityQueue2;
import java.util.*;
public class KthLargestElement {
	public static int kthLargest(int n, int[] input, int k) {
		// Write your code here
      	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<k;i++)
        {
            pq.add(input[i]);
        }
        
        for(int i=k;i<input.length;i++)
        {
            int minVal=pq.peek();
            if(minVal<input[i])
                minVal=input[i];
            if(minVal!=pq.peek())
            {
                pq.poll();
                pq.add(minVal);
            }
        }
        
        int minVal=Integer.MAX_VALUE;
        while(!pq.isEmpty())
        {
            int check=pq.poll();
            if(check<minVal)
                minVal=check;
        }
        return minVal;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2,6,10,11,13,4,1,20};
		int k=4;
		System.out.println(kthLargest(arr.length,arr,k));
	}

}
