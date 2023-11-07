/*
  Approach
  convert the tree into max heap using heapify
  and then replace first element to the last one and apply hepigy algo to top of element each time
  untill size > 0

  TIME COMPLEXITY : O(NLOGN)
  SPACE COMPLEXITY : O(N)
*/
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static void heapify(ArrayList<Integer> arr, int n, int i){
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if(left < n && arr.get(largest) < arr.get(left))
			largest = left;
		if(right < n && arr.get(largest) < arr.get(right))
			largest = right;
		
		if(largest != i){
			int t = arr.get(i);
			arr.set(i, arr.get(largest));
			arr.set(largest, t);
			heapify(arr, n, largest);
		}
		
	}
	public static ArrayList<Integer> heapSort(ArrayList<Integer> arr, int n) {
		// Write your code here.
		int i = (n / 2) - 1;
		for(; i >= 0; i--){
			heapify(arr, n, i);
		}

		//System.out.print(arr);
		int size = n - 1;

		while(size > 0){
			// swap first one to last one
			int t = arr.get(0);
			arr.set(0, arr.get(size));
			arr.set(size, t);
			size--;

			heapify(arr, size+1, 0);
		}

		return arr;
	}
}
