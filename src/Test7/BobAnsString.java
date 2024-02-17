package Test7;
import java.util.*;
public class BobAnsString {
	//time O(n^2)
	 public static int maximumChars(String str)
	    {
	        int n = str.length();
	        int res = -1;
	         
	        for (int i = 0; i < n - 1; i++)
	            for (int j = i + 1; j < n; j++)
	                if (str.charAt(i) == str.charAt(j))
	                    res = Math.max(res,
	                         Math.abs(j - i - 1));
	                          
	        return res;
	    }
	 
	private static int MAX_CHAR = 256;
     
	    static int findMaximumChars(String str)
	    {
	        int n = str.length();
	        int res = -1;
	     
	        // Initialize all indexes as -1.
	        int []firstInd = new int[MAX_CHAR];
	         
	        for (int i = 0; i < MAX_CHAR; i++)
	            firstInd[i] = -1;
	     
	        for (int i = 0; i < n; i++)
	        {
	            int first_ind = firstInd[str.charAt(i)];
	     
	            // If this is first occurrence
	            if (first_ind == -1)
	                firstInd[str.charAt(i)] = i;
	     
	            // Else find distance from previous
	            // occurrence and update result (if
	            // required).
	            else
	                res = Math.max(res, Math.abs(i
	                                  - first_ind - 1));
	        }
	         
	        return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		System.out.println("ENter test case");
		int t=s.nextInt();
		while (t!=0){
			System.out.println("Enter string");
			String str = s.next();
	        
	        System.out.println(findMaximumChars(str));
	        t--;
		}
		
	}

}
