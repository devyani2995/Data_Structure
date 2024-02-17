package queue;

public class QueueUsingArray {
  private int data[];
  private int front;  //the index where the first element is stored in the array representing the queue.
  private int rear;   //the index where the last element is stored in the array representing the queue.
  private int size;
    public QueueUsingArray() {
		data = new int[5];
		front = -1;
		rear = -1;
	}
    
    public QueueUsingArray(int capacity) {
		data = new int[capacity];
		front = -1;
		rear = -1;
	}
    
    public int size() {
    	return size;
    }
    
    public boolean isEmpty() {
    	return size==0;
    }
    
    public void enqueue(int elem) {
    	if(size == data.length) {
//    		System.out.println("Queue is full");
    	    doubleCapacity();
    	}
    	if(size==0) {
    		front++; //or front =0;
    	}
//    	rear++;
//    	if(rear==data.length){
//    		rear=0;
//    	}
    	
    	//from line 35 to 38 can also be written in a single rear=(rear+1)%data.length;
    	rear=(rear+1)%data.length;
    	
    	data[rear] = elem;
    	size++;
    }
    
    private void doubleCapacity() {
		// TODO Auto-generated method stub
    	System.out.println("double capacity");
    	
		int temp[]=data;
		data=new int[2*temp.length];
		int index=0;
		
		//copy all elements from front to end
		for(int i= front;i<temp.length;i++) {
			data[index++] = temp[i];
		}
		//copy all elements from 0 to front-1
		for(int i= 0;i<front-1;i++) {
			data[index++] = temp[i];
		}
		
		front=0;
		rear=temp.length-1;
	}

	public int front() {
    	if(size == 0) {
    		System.out.println("queue is empty");
    	}
    	return data[front];
    }
    public int dequeue() {
    	if(size == 0) {
    		System.out.println("queue is empty");
    	}
    	  int temp = data[front];
//    	  front++;
//    	  if(front==data.length) {
//    		  front=0;
//    	  }
    	  front = (front +1)%data.length;
    	  size--;
    	  if(size==0) {
    		  front=-1;
    		  rear=-1;
    	  }
    	  return temp;
    }
}
