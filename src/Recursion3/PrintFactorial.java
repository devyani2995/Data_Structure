package Recursion3;

public class PrintFactorial {
	private static int factHelper(int n) {
		if(n==0) {
			return 1;
		}
		
		return n * factHelper(n-1);
	}
    public static void fact1(int n) {
    	int output = factHelper(n);
    	System.out.println(output);
    }
    
    //print factorial of a number
    public static void fact2(int n,int answer) {
    	if(n==0) {
    		System.out.println(answer);
    		return;
    	}
    	
    	answer = answer * n;
    	fact2(n-1,answer);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int n=5;
//        fact1(n);   
        fact2(n,1);
	}

}
