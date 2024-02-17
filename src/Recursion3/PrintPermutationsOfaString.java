package Recursion3;

public class PrintPermutationsOfaString {
    private static void print(String input,String output){
        if(input.length() == 0){
            System.out.println(output);
            return;
        }
        
        for(int i=0;i<input.length();i++){
            String str = input.substring(0,i) + input.substring(i+1,input.length());    
            print(str , output + input.charAt(i));
        }        
    }
	public static void permutations(String input){
		// Write your code here
       print(input,"");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="abc";
		permutations(input);
	}

}
