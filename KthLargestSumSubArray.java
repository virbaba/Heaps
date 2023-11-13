/*
  Time Complexity : O(n^2 * log k)
  Space Complexity : O(k)
*/
import java.util.*;

public class Solution {

	public static int getKthLargest(ArrayList<Integer> arr, int k) {
		/*
		 * firstly track from all sub array to store sum
		 * for each subarray & store into min heap if min
		 * heap size is less than equal to k
		 * if size == k then we check if current sum is greater
		 * then to q1.peek then we remove peek one and insert
		 * current sum and at the end the peek element is
		 * kth largest sum of continugous subarray
		 */
		PriorityQueue<Integer> q1 = new PriorityQueue<>();
		for (int i = 0; i < arr.size(); i++) {
			int sum = 0;
			for (int j = i; j < arr.size(); j++) {
				sum += arr.get(j);
				if (q1.size() < k) {
					q1.offer(sum);
				} else {
					if (sum > q1.peek()) {
						q1.poll();
						q1.offer(sum);
					}
				}
			}
		}

		return q1.peek();
	}
}
