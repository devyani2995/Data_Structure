package hashmap;

import java.util.HashMap;
import java.util.Set;

public class InbuiltMapUse {
	public static void main(String[] args){
		HashMap<String, Integer> map = new HashMap<>();
		
		//insert
		map.put("abc", 10);
		map.put("def", 20);
		map.put("efg", 30);
		
		//size
		System.out.println(map.size());
		
		//presence
		if(map.containsKey("abc")) {
			System.out.println("map has abc");
		}
		
		if(map.containsKey("abc1")) {
			System.out.println("map has abc1");
		}
		
		//get value
		  // Checking if a key is present and if
        // present, print value by passing
        // random element
        if (map.containsKey("abc")) {
  
            // Mapping
            Integer a = map.get("abc");  //or int a = map.get("abc");
  
            // Printing value for the corresponding key
            System.out.println("value for key"
                               + " \"abc\" is:- " + a);
        }
        
        //remove
//        map.remove("abc");
//        if(map.containsKey("abc")) {
//        	System.out.println("map has abc");
//        }
//        
        //iterate
        Set<String> keys = map.keySet(); //map.keySet() gives us keys in the form of Set data structure
        for(String s:keys) {
          System.out.println(s);	
        };
	}
}
