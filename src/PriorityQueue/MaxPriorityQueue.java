package PriorityQueue;
import java.util.*;
public class MaxPriorityQueue {
	ArrayList<Integer> heap;
	
	 public MaxPriorityQueue() {
		heap=new ArrayList<>();
	 }
	
	 public int getSize(){
	        return heap.size();
	 }
	 
	 public boolean isEmpty(){
	        return heap.size()==0;
	 }
	 
	 int getMax() {
			 if(isEmpty())
	            return Integer.MIN_VALUE;
	        return heap.get(0);
	 }
	 
	 public void insert(int element){
	        heap.add(element);
	        int childindex=heap.size()-1;
	        int parentindex=(childindex-1)/2;
	        //upheapify------
	        while(childindex>0){
	            if(heap.get(childindex)>heap.get(parentindex))
	            {
	                int temp=heap.get(parentindex);
	                heap.set(parentindex,heap.get(childindex));
	                heap.set(childindex,temp);
	                childindex=parentindex;
	                parentindex=(childindex-1)/2;
	            }
	            else
	                return;
	        }
	  }
	 
	 public int removeMax(){
	        if(isEmpty())
	            return Integer.MIN_VALUE;
	        
	        int leftchildindex=1;
	        int rightchildindex=2;
	        int parentindex=0;
	        
	        int maxindex=parentindex;
	        int temp=heap.get(0);
	        heap.set(0,heap.get(heap.size()-1));
	        heap.remove(heap.size()-1);
	        
	        while(leftchildindex<heap.size()){
	        	
	           if(heap.get(leftchildindex)>heap.get(parentindex))
	            maxindex=leftchildindex;
	        
	           if(rightchildindex<heap.size() && heap.get(rightchildindex)>heap.get(maxindex))
	            maxindex=rightchildindex;
	        
	           if(maxindex==parentindex)
	            break;
	           
	           else{
	            int temp1=heap.get(parentindex);
	            heap.set(parentindex,heap.get(maxindex));
	            heap.set(maxindex,temp1);
	            parentindex=maxindex;
	            
	            leftchildindex=2*parentindex +1;
	            rightchildindex=2*parentindex +2;

	           }
	        }
	         return temp; 
	    }
	 
}
