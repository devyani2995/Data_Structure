package arraylist;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      ArrayList<Integer> al=new ArrayList<>();
      al.add(20);
      al.add(30);
      al.add(90);
      al.add(1,80); //insert 80 at index 1
//      al.remove(2); //remove element at index 2
      
      for(int i=0;i<al.size();i++) {
    	  System.out.println(al.get(i));
      }
      
      //enhanced for loop or for each loop
      for(int i:al) {
    	  System.out.println(i);
      }
//      Integer i=30;
//      al.remove(i);
//      al.set(0, 100);
//      System.out.println(al.size());
//      System.out.println(al.get(0));
	}

}
