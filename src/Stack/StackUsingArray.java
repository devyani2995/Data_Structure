package Stack;

public class StackUsingArray {
  private int data[];
  private int topIndex; //index of the topmost element of the stack
  
  public StackUsingArray() {
	  data = new int[2];
	  topIndex = -1;
  }
  
  public StackUsingArray(int size) {
	  data = new int[size];
	  topIndex = -1;
  }
  
  //O(1)
  public int size() {
	 return topIndex + 1;
  }
   
  //O(1)
  public boolean isEmpty() {
	  if(topIndex == -1)
		  return true;
	  else
		  return false;
  }
  
  //O(1)
  public void push(int elem){
	  //if stack is full
	  if(topIndex == data.length -1) {
		  //throw an exception
//		  StackFullException e = new StackFullException();
//		  throw e;
//		  throw new StackFullException();
		  doubleCapacity();
	  }
	  
	   data[++topIndex] = elem;
  }
  
  private void doubleCapacity() {
	// TODO Auto-generated method stub
	  System.out.println("Double capacity");
	int temp[]= data;
	data = new int[2*temp.length];
	for(int i=0;i<temp.length;i++) {
		data[i] = temp[i];
	}
}

//O(1)
  public int top() throws StackEmptyException {
	  if(topIndex == -1) {
		  throw new StackEmptyException();
	  }
	   return data[topIndex];
  }
  
  //O(1)
  public int pop() throws StackEmptyException {
	  if(topIndex == -1) {
		  throw new StackEmptyException();
	  }
	  int temp = data[topIndex];
	  topIndex--;
	  return temp;
	  
  }   
}
