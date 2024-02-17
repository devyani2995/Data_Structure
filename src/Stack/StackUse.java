package Stack;

public class StackUse {

	public static void main(String[] args) throws StackFullException, StackEmptyException {
		// TODO Auto-generated method stub
//        StackUsingArray stk = new StackUsingArray();
//		  StackUsingLL<Integer> stk= new StackUsingLL<Integer>();
		StackUsingQueue stk = new StackUsingQueue();
        int arr[] = {5,6,7,1,9};
        
        for(int i=0;i<arr.length;i++) {
        	stk.push(arr[i]);
        }
        System.out.println("Top element "+stk.top());
        while(!stk.isEmpty()) {
        	System.out.println(stk.pop());
        }
//        stk.push(10);
//        System.out.println( stk.top());     
//        stk.pop();
//        stk.size();
//        System.out.println(stk.isEmpty());
//        stk.pop();
	}

}
