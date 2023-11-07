/*
  TIME COMPLEXITY : O(N)
  SPACE COMPLEXITY : O(N)

  REMEMBER THAT FROM N / 2 TO N IN ARRAY IS ALREADY IS IN HEAP SO WE TRAVERSE FROM N / 2 - 1 TO 0
  Approach:
  we considered i'th element is largest element according to MAX heap and then we check it to left and right side in order to find max to current element if find then we swap it and 
  than the we treaverse from largest to leaf and this process is continue for each i'th node

*/
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static void build(ArrayList<Integer> arr, int i, int n){
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;


		if(left < n && arr.get(largest) < arr.get(left))
			largest = left;
		if(right < n && arr.get(largest) < arr.get(right))
			largest = right;
		
		if(largest != i){
			int t = arr.get(largest);
			arr.set(largest, arr.get(i));
			arr.set(i, t);
			build(arr, largest, n);
		}
	}
    public static ArrayList<Integer> buildHeap(ArrayList<Integer> arr, int n) {
        //  Write your code here...
		for(int i = n/2-1; i >= 0; i--){
			build(arr, i, n);
		}

		return arr;
    }
}
