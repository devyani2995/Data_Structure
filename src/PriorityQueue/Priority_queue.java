package PriorityQueue;

import java.util.ArrayList;

public class Priority_queue<T> {
    private ArrayList<Element<T>> heap;

	public Priority_queue() {
		heap= new ArrayList<>();
	}  
	
	public void insert(T value,int priority) {
		Element<T> e = new Element<>(value, priority);
		heap.add(e);
		int childIndex = heap.size()-1; //intially child index will be last index of arraylist
		int parentIndex = (childIndex-1)/2;
	
	  while(childIndex > 0){
		if(heap.get(childIndex).priority < heap.get(parentIndex).priority) {
			Element<T> temp = heap.get(childIndex);
			heap.set(childIndex, heap.get(parentIndex));
			heap.set(parentIndex, temp);
			childIndex=parentIndex;
			parentIndex=(childIndex-1)/2;
		}else {
			return;
		}
	  }
	} 
	
	public T getMin() throws PriorityQueueException {
		 if(isEmpty()) {
			 throw new PriorityQueueException();
		 }
		return heap.get(0).value;	 
	}
	
	public T removeMin() throws PriorityQueueException {
		 if(isEmpty()) {
			 throw new PriorityQueueException();
		 }
		 
		 Element<T> removed = heap.get(0); //element to be removed
		 T ans = removed.value;
		 
		 heap.set(0, heap.get(heap.size()-1)); //replace the 0th element with the last element 
		 heap.remove(heap.size()-1);//and remove last element
		 
		 int parentIndex =0;
		 int leftChildIndex = 2*parentIndex + 1;
		 int rightChildIndex = 2*parentIndex + 2;
		 
	  //run the loop untill u reach the bottom most part of the tree
	  //ie.parent has no child
	  //heap there is no left child then there should be not right child in case of heap
	  while(leftChildIndex < heap.size()){	 
		 int minIndex = parentIndex; //let say min index be parentIndex by default
		 
		 if(heap.get(leftChildIndex).priority < heap.get(minIndex).priority) {
			 minIndex = leftChildIndex;
		 }
		 
		 //here rightChildIndex < heap.size() condition is there bcz if parent will hv only left child
		 //if this condition is not there then it will throw IndexOutOfBound exception
		 if(rightChildIndex < heap.size() && (heap.get(rightChildIndex).priority < heap.get(minIndex).priority)) {
			 minIndex = rightChildIndex;
		 }
		 
		 //if minIndex is same as parent index then we don't need to move down further 
		 //just break the loop
		 if(minIndex == parentIndex) {
			 break;
		 }
		 
		 //swap parent index and minIndex element
		 Element<T> temp = heap.get(minIndex);
		 heap.set(minIndex, heap.get(parentIndex));
		 heap.set(parentIndex, temp);
		 
		 parentIndex = minIndex;
		 leftChildIndex = 2*parentIndex + 1;
		 rightChildIndex = 2*parentIndex + 2;
	  }
	  
	  return ans;
	}
	
	public int size() {
		 return heap.size();
	}
	
	public boolean isEmpty() {
		if(size()==0)
			return true;
		else
			return false;
	}
}
