/*
 * Given a string, find and return all the possible permutations of the input string.
Note :
The order of permutations are not important
 */
package Recursion3;

public class ReturnPermutations {
	public static String[] permutationOfString(String input){
		if(input.length() == 0){
            String y[] = {""};
            return y;
        }
        
        String [] ans = permutationOfString(input.substring(1));
		String output[] = new String[ans.length*input.length()];
		 //  char ch = input.charAt(0);
        int k=0;
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<=ans[i].length();j++){
                output[k++] = ans[i].substring(0,j) + input.charAt(0) + ans[i].substring(j);
            }
        }
        
        return output;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="abc";
		String output[] = permutationOfString(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}

}
