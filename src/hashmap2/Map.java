package hashmap2;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Map<K,V> {
   ArrayList<MapNode<K, V>> buckets;
   int count; //by default its zero bcz we have'nt insert any element in the arraylist and it maintains how many elemnts are there in the hashmap
   int numBuckets;
   
   public Map() {
	   buckets = new ArrayList<>();
	   numBuckets = 5;
	   for(int i=0;i<numBuckets;i++) {
		   buckets.add(null);
	   }
   }
   
   //Get Size
   public int size() {
	   return count;
   }
   
   //REMOVE KEY
   public V removeKey(K key) {
	   int bucketIndex = getBucketIndex(key);
       MapNode<K, V> head = buckets.get(bucketIndex);
       MapNode<K, V> prev = null;
       
       while(head != null) {
		   
		   //checking if key is already in the list
		   if(head.key.equals(key)) { 
			   if(prev!=null) {
				   prev.next = head.next;
			   }else {
				   buckets.set(bucketIndex, head.next); //if key matches at the starting of the node and prev == null
			   }
			   count--;
		       return head.value;
		   }
		   prev = head;
		   head = head.next;
	   }   
	   return null;
   }
   
   //GET VALUE
   public V getValue(K key) {
	   int bucketIndex = getBucketIndex(key);
       MapNode<K, V> head = buckets.get(bucketIndex);
	   
	   while(head != null) {
		   
		   //checking if key is already in the list
		   if(head.key.equals(key)) { 
			 return head.value;
		   }
		   head = head.next;
	   }   
	   return null;
   }
   
   private int getBucketIndex(K key) {
	 int hc = key.hashCode(); //to get hashcode
	 int index = hc%numBuckets; //doing compression to get the index
	  
	 return index;
   }
   
   //INSERT
   public void insert(K key,V value) {
	   int bucketIndex = getBucketIndex(key);
	   MapNode<K, V> head = buckets.get(bucketIndex);
	   
	   while(head != null) {
		   
		   //checking if key is already in the list
		   if(head.key.equals(key)) { 
			   head.value = value; //just update the value to the new value of that key and return
			   return;
		   }
		   head = head.next;
	   }
	   
	   //if elemnet is not there insert at oth position of the linked list
	   head = buckets.get(bucketIndex); //as head become null in while loop above so again initialize the head value to the previous value
	   //make a new node
	   MapNode<K, V> newNode = new MapNode<>(key, value);
	   
	   //insert newNode at the front
	   newNode.next = head;
	   buckets.set(bucketIndex, newNode); //inserting newNode in the bucketIndex
	   count++; //maintains how many elements are there in the hashmap
	   
	   double loadFactor = (1.0 * count)/numBuckets;
	   if(loadFactor > 0.7) {
		   reHash();
	   }
   }

   private void reHash() {
	 
	   ArrayList<MapNode<K, V>> temp=buckets; //storing old buckets into temp
	   buckets = new ArrayList<>();
	   for(int i=0;i<2*numBuckets;i++) {
		   buckets.add(null);
	   }
	   
	   count = 0;
	   numBuckets= numBuckets*2;
	   for(int i=0;i<temp.size();i++) {
		   MapNode<K, V> head = temp.get(i);
		   while(head!=null) {	  
			   K key=head.key;
			   V value=head.value;
			   insert(key, value);
			   head=head.next;
		   }
	   }
   }

   public double loadFactor() {
	  double loadFactor = (1.0 * count)/numBuckets;
	  return loadFactor;
   }
}
