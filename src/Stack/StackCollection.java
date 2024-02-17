package Stack;
import java.util.*;
public class StackCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//        Stack<Integer> stk = new Stack<>();
//        stk.push(10);
//        System.out.println(stk.size());
//        System.out.println(stk.peek());  // to get the topmost element in a stack
//        System.out.println(stk.pop());
//        System.out.println(stk.size());
//        int arr[] = {2,3,5,6,7,8,9};
//        for(int elem:arr) {
//        	stk.push(elem);
//        }
//        while(!stk.isEmpty()) {
//        	System.out.print(stk.pop()+ " ");
//        }
	      Stack<Integer> stack=new Stack<Integer>();
	        stack.push(5);
	        stack.push(10);
	        stack.push(15);
	     
	        System.out.print(stack.pop()+stack.size());
	}

}
