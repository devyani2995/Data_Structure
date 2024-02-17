package DP1;

import java.util.Scanner;

public class MinStepToOne {
	public static int countMinStepsToOne(int n) {
		
		//iterative dp
		int storage[]=new int[n+1];
        storage[1]=0;

        for(int i=2;i<storage.length;i++)
        {
            int op1=Integer.MAX_VALUE;
            int op2=Integer.MAX_VALUE;
            int op3=Integer.MAX_VALUE;
            op1=storage[i-1];
            if(i%2==0)
                op2=storage[i/2];
            if(i%3==0)
                op3=storage[i/3];
            storage[i]=1+Math.min(Math.min(op1,op2),op3);
        }
        return storage[n];
        
        
//		if (n<=1)
//            return 0;
//        else if (n==2 || n==3)
//            return 1;
//        
//       int output1=countMinStepsToOne(n-1);
//       int output2=Integer.MAX_VALUE;
//       int output3=Integer.MAX_VALUE;
//        
//       if (n%2==0)
//           output2=countMinStepsToOne(n/2);
//        
//       if (n%3==0)
//           output3=countMinStepsToOne(n/3);
//        
//       return Math.min(Math.min(output2,output3),output1)+1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	       Scanner s=new Scanner(System.in);
	       int n=s.nextInt();
	       System.out.println(countMinStepsToOne(n));
	}

}
