package fulltest1;
import java.util.*;
public class JumpingNumbers {
	static void dfs(long cnum, long num){
        if (cnum > num) // base case
            return;
 
        System.out.print(cnum
                         + " "); // print the current number
 
        int l_dig = (int)(cnum % 10); // get the last digit
                                      // of current number
 
        // for the next digit we have two options
        long first = cnum * 10 + l_dig + 1;
        long second = cnum * 10 + l_dig - 1;
 
        if (l_dig == 0) // here as second option will give
                        // us a -ve number we will skip it
            dfs(first, num);
        else if (l_dig
                 == 9) // here as first option will give
                       // us a -ve number we will skip it
            dfs(second, num);
        else // else we call on both the options
        {
            dfs(first, num);
            dfs(second, num);
        }
    }
	
	
	public static void showJumpingNos(int x) {
		 System.out.print(0 + " ");
	        for (long i = 1L; i <= 9; i++) {
	            dfs(i, x); // generate all the numbers starting
	                       // from i
	        }
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
	    showJumpingNos(x);
	}

}
