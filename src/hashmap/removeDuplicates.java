package hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class removeDuplicates {
	private static ArrayList<Integer> removeDupliacte(int[] arr) {
		ArrayList<Integer> output = new ArrayList<>();
		
		HashMap<Integer, Boolean> map = new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				continue;
			}
			
			output.add(arr[i]);
			map.put(arr[i], true);
		}
		
		return output;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int arr[]= {1,2,3,2,2,4,5,6,7};
       ArrayList<Integer> output = removeDupliacte(arr);
       System.out.println(output);
	}
}
