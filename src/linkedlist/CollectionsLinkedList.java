package linkedlist;

import java.util.LinkedList;

public class CollectionsLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          LinkedList<Integer> list = new LinkedList<Integer>();
          list.add(10);
          list.add(20);
          list.add(30);
         list.add(1,100);
         list.set(0, 120); //replace the value
         list.remove(); //remove the first element bydefault
         System.out.println(list.get(1));
         System.out.println(list.size());
         for(int i=0;i<list.size();i++) {
        	 System.out.print(list.get(i)+" ");
         }
	}

}
