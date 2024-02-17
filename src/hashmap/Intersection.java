package hashmap;
import java.util.*;
public class Intersection {
	public static void intersection(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int key:arr1)
        {	
            if(map.containsKey(key))
        	{
            	map.put(key,map.get(key)+1);
        	}
            else
            {
                map.put(key,1);
            }
            
        }
        Arrays.sort(arr2);
        for (int key:arr2)
        {
            if (map.containsKey(key))
            {
                int val = map.get(key);
                if (val>0)
                {
                    System.out.print(key + " ");
                    map.put(key,val-1);
                }
                
            }
        } 
	}
	public static void main(String[] args){
		 int arr1[]= {2,6,1,2};
		 int arr2[]= {1,2,3,4,2};
		 
		 intersection(arr1, arr2);
	}
}
