/*
  TIME COMPLEXITY : O(N)
  SPACE COMPLEXITY : O(N)

  REMEMBER THAT FROM N / 2 TO N IN ARRAY IS ALREADY IS IN HEAP SO WE TRAVERSE FROM N / 2 - 1 TO 0
  Approach:
  we considered i'th element is smallest element according to MIN heap and then we check it to left and right side in order to find min to current element if find then we swap it and 
  than the we treaverse from smallest to leaf and this process is continue for each i'th node

*/
import java.util.* ;
import java.io.*; 
public class Solution
{
	public static void build(int[] arr, int i, int n){
		int smallest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;


		if(left < n && arr[smallest] > arr[left])
			smallest = left;
		if(right < n && arr[smallest] > arr[right])
			smallest = right;
		
		if(smallest != i){
			int t = arr[smallest];
			arr[smallest] = arr[i];
			arr[i] = t;
			build(arr, smallest, n);
		}
	}
	public static int[] buildMinHeap(int[] arr)
	{
		// Write your code here.
		int n = arr.length;
		for(int i = n/2-1; i >= 0; i--){
			build(arr, i, n);
		}

		return arr;

	}
}

