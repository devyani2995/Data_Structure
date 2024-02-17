/*
 * You are given an sorted integer array of size 'n'.

Your task is to find and return all the unique subsets of the input array.

Subsets are arrays of length varying from 0 to 'n', that contain elements of the array. But the order of elements should remain the 
same as in the input array.
 */

package Recursion3;
import java.util.*;
public class GetAllUniqueSubsets {
	public static ArrayList<ArrayList<Integer>> getSubsets(int[] input) {
        // Sort the input array (if it's not already sorted)
        Arrays.sort(input);
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        ArrayList<Integer> currentSubset = new ArrayList<>();
        generateSubsets(input, 0, currentSubset, subsets);
        return subsets;
    }
    private static void generateSubsets(int[] input, int index, ArrayList<Integer>
    currentSubset, ArrayList<ArrayList<Integer>> subsets) {
        // Add the current subset to the list of subsets
        subsets.add(new ArrayList<>(currentSubset));
        for (int i = index; i < input.length; i++) {
            // Skip duplicates
            if (i > index && input[i] == input[i - 1])
                continue;
            // Add the current element to the subset
            currentSubset.add(input[i]);
            // Recursively generate subsets starting from the next index
            generateSubsets(input, i + 1, currentSubset, subsets);
            // Remove the current element from the subset to backtrack
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
	public static void printSubsets(int input[]) {
		// Write your code here
 	
	    ArrayList<ArrayList<Integer>> subsets = getSubsets(input);
        // Print the subsets
        for (ArrayList<Integer> subset : subsets) {
            for (int num : subset) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,1,2};
		printSubsets(arr);

	}

}
