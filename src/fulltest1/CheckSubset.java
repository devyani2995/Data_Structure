package fulltest1;

import java.util.Arrays;

public class CheckSubset {
	public static boolean CheckSubset(int[] arr1, int n1, int[] arr2, int n2) {
		/*Your class should be named solution. 
		*Don't write main().
		*Don't take input, it is passed as function argument.
		*Don't print output.
		*Taking input and printing output is handled automatically.
		*/ 
//        return false;
		int i = 0;
        int j = 0;
        for (i = 0; i < n2; i++) {
            for (j = 0; j < n1; j++)
                if (arr2[i] == arr1[j])
                    break;
 
            /* If the above inner loop
            was not broken at all then
            arr2[i] is not present in
            arr1[] */
            if (j == n2)
                return false;
        }
 
        /* If we reach here then all
        elements of arr2[] are present
        in arr1[] */
        return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int a1[]= {9,17,8,19,9,19,19,10,13,1,11,13,17,13,1};
      int a2[]= {17, 16,4,16,8};
      System.out.println(CheckSubset(a1, a1.length, a2, a2.length));
      int b[]=new int[7];
    
	}

}
