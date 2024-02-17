package hashmap;
import java.util.*;
public class ExtractUniqueElement {
	public static String uniqueChar(String str){

        HashMap<Character,Integer> map = new HashMap<>();
        String newstr="";
        for (int i=0;i<str.length();i++)
        {
            char c = str.charAt(i);
            if (map.containsKey(c))
            {
                map.put(c, map.get(c)+1);
            }
            else
            {
                newstr=newstr+c;
                map.put(c,1);
            }
        }
        return newstr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String str="abbcddd";
       System.out.println(uniqueChar(str));
	}

}
