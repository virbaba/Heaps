/*
    Time complexity: O(N * log(K))
    Space complexity: O(K)

    where K is the position (ordered by increasing value) of the element you need to find

    w
*/

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {
	public static int findKthLargest(ArrayList<Integer> nums, int k) {

		// Initialising min heap
		PriorityQueue<Integer> elementsInserted = new PriorityQueue<Integer>();

		// Loop to find kth largest element
		for (int i = 0; i < nums.size(); i++) {

			// If size of priority queue equals k then remove the small elements from the queue
			if (elementsInserted.size() == k) {
				if (nums.get(i) >= elementsInserted.peek()) {
					elementsInserted.poll();
					elementsInserted.add(nums.get(i));
				}
			} else {
				elementsInserted.add(nums.get(i));
			}
		}
		// Return the Kth largest element
		return elementsInserted.peek();
	}
}
