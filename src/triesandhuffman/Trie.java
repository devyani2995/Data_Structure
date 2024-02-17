package triesandhuffman;

import java.util.ArrayList;

class TrieNode{
	char data;
	boolean isTerminal;
	TrieNode children[];
	int childCount;
	public TrieNode(char data) {
		this.data=data;
		this.isTerminal=false;
		this.children = new TrieNode[26];
		this.childCount=0;
	}
}
public class Trie {
  private TrieNode root;
  public Trie() {
	  root=new TrieNode('\0'); //intialize root with null character	  
  }
  
  private void addHelper(TrieNode root ,String word) {
	  //base case
	  if(word.length()==0) {
		  root.isTerminal = true;
		  return;
	  }
	  int childIndex =word.charAt(0) - 'A';
	  TrieNode child = root.children[childIndex];
	  
	  //if child does not exist
	  if(child == null) {
		  child = new TrieNode(word.charAt(0));
		  root.children[childIndex] = child;
		  root.childCount++;
	  }
	  
	  //if child node exist
	  addHelper(child, word.substring(1));
  }
  
  //ADD WORD
  public void add(String word) {
	addHelper(root, word);
  }
  
  private boolean searchHelper(TrieNode root, String word) {
	  //base case
	  if(word.length()==0) {
		  return root.isTerminal;
	  }
	  int childIndex =word.charAt(0) - 'A';
	  TrieNode child = root.children[childIndex];
	  
	  //if child does not exist
	  if(child == null) {
		return false;  
	  }
	  
	  return searchHelper(child, word.substring(1));
	}
  
  //SEARCH WORD
  public boolean search(String word) {
	  return searchHelper(root,word);
  }

  //REMOVE WORD
  public void remove(String word) {
	 removeHelper(root,word); 
  }

  private void removeHelper(TrieNode root, String word) {
	 //base case
	 if(word.length()==0) {
		 root.isTerminal = false;
		 return;
	 }
	 int childIndex =word.charAt(0) - 'A';
	  TrieNode child = root.children[childIndex];
	  
	  //if child does not exist
	  if(child == null) {
		return;
	  }
	  
	  removeHelper(child, word.substring(1));
	  
	  if(!child.isTerminal && child.childCount == 0) {
		  root.children[childIndex]=null;
		  root.childCount--;
	  }
	
    }
  
	private void printHelper(TrieNode root, String word) {
		if (root == null) {
			return;
		}
		
		if (root.isTerminal) {
			System.out.println(word);
		}
		
		for (TrieNode child : root.children) {
			if (child == null) {
				continue;
			}
			String fwd = word + child.data;
			printHelper(child, fwd);
		}
	}
	
	//PRINT ELEMENT
	public void print() {
		printHelper(this.root, "");
	}
  
    //PATTERN MATCHING
	public boolean patternMatching(ArrayList<String> vect, String pattern) {
	  for (int i = 0; i < vect.size(); i++) {
        String word = vect.get(i); 
        for (int j = 0; j < word.length(); j++) {
            add(word.substring(j)); }
        }
        return search(pattern);
	}
	
	  public boolean isPalindrome(String word) {
	        int start = 0;
	        int end = word.length() - 1;
	        while (start < end) {
	            if (word.charAt(start) != word.charAt(end)) {
	                return false;
	            }
	            start++;
	            end--;
	        }
	        return true;
	    }

	    public boolean isPalindromePair(ArrayList<String> words) {
	        for (String word : words) {
	            String reverse = new StringBuilder(word).reverse().toString();
	            if (search(reverse) || isPalindrome(word)) {
	                return true;
	            }
	        }
	        for (String word1 : words) {
	            String reverse1 = new StringBuilder(word1).reverse().toString();
	            for (String word2 : words) {
	                if (word1 != word2) {
	                    String concat = word1 + word2;
	                    String reverse2 = new StringBuilder(concat).reverse().toString();
	                    if (isPalindrome(concat) || search(reverse1) || search(reverse2)) {
	                        return true;
	                    }
	                }
	            }
	        }
	        return false;
	    }
	    
		private TrieNode findword(TrieNode root, String word) { 
	        if(word.length() == 0){
	            return root;
	        }
	        int childIndex = word.charAt(0) - 'a';
	        TrieNode child = root.children[childIndex];
	        if(child == null){
	            return null; 
	        }
	        return findword(child, word.substring(1));
	    } 
	    
	    private void allwords(TrieNode root,String word,String output){    
	        if(root==null){
	            return;
	        }
	        
	        if(root.childCount == 0) { 
	            if(output.length() > 0) {
	                System.out.println(word + output); 
	            }
	            return; 
	        }
	        if(root.isTerminal == true) {
	            System.out.println(word + output);
	        }

	        for(int i = 0; i < root.children.length; i++) {
	            if(root.children[i] != null) {
	                String ans = output + root.children[i].data; 
	                allwords(root.children[i],word,ans);
	            }
	       }
	    }
	    
	    //AUTOCOMPLETE
		public void autoComplete(ArrayList<String> input, String word) {

	        // Write your code here
			 int i=0; 
	        while(i<input.size()){
	            String str=input.get(i);
	            add(str); 
	            i++;
	         }  
	        if(root == null || root.childCount == 0) { 
	            return;
	        }
	       TrieNode a=findword(root,word);
	        String output = ""; 
	        allwords(a,word,output); 

	    }
//	private String reverse(String i){
//        String newString = "";
//        while (i.length() != 0){
//        	newString = i.charAt(0) + newString;
//            i = i.substring(1);
//        }
//      
//        return newString;
//    }
//	//find Palindrome Pair
//	public boolean isPalindromePair(ArrayList<String> words) {
//		//Your code goes here
//		 ArrayList<String> s=new ArrayList<>();
//			for(int i=0;i<words.size();i++){
//		        String st=words.get(i);
//		         add(st);
//		        String str=reverse(st);
//		        s.add(str);
//		    }
//		    for(int i=0;i<s.size();i++){
//		        boolean b=search(s.get(i));
//		         if(b==true)
//		         return true;
//		    }
//		        return false;
//	}
}
