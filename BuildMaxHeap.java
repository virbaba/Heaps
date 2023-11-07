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
