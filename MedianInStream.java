/*
  TIME COMPLEXITY : O(NLOGk)
  SPACE COMPLEXITY: O(K)
*/
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static int[] findMedian(int[] arr, int n) {
        // Write your code here.
        /*
         * 1 2 3 4 5 6
         * int this stream we have only need 3 and 4
         * if we store first three element into max heap and last
         * three into min heap
         * max heap : 3 2 1
         * min heap : 4 5 6
         * 
         * now we can fetch 3 and 4 in O(1) time
         * 
         */
        int[] ans = new int[n];

        PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();

        int i = 0;
        for (int e : arr) {
            // if both leftMaxHeap & rightMinHeap is empty
            if (leftMaxHeap.isEmpty() && rightMinHeap.isEmpty()) {
                leftMaxHeap.offer(e);
                ans[i++] = e;
            } else {
                /*
                    if upcoming element is greater than to 
                    leftMaxHeap.peek element then we just put
                    it into rightMinHeap
                    after that we check if size is equall then 
                    we return of both heap peek addition with half

                    otherwise we just return peek of leftMaxHeap
                */
                if (e >= leftMaxHeap.peek()) {
                    rightMinHeap.offer(e);
                    if (rightMinHeap.size() > leftMaxHeap.size()) {
                        leftMaxHeap.offer(rightMinHeap.poll());
                        ans[i++] = leftMaxHeap.peek();
                    } else {
                        ans[i++] = (int) Math.floor((leftMaxHeap.peek() + rightMinHeap.peek()) / 2);
                    }
                }

                /*
                    if current element is less than to leftMaxHeap
                    then firstly we remove max from leftMaxHeap
                    and put it into rightMinHeap and put current 
                    element into leftMaxHeap
                    and then run same condition as above 
                */

                if(e < leftMaxHeap.peek()){
                    rightMinHeap.offer(leftMaxHeap.poll());
                    leftMaxHeap.offer(e);
                    if (rightMinHeap.size() > leftMaxHeap.size()) {
                        leftMaxHeap.offer(rightMinHeap.poll());
                        ans[i++] = leftMaxHeap.peek();
                    } else {
                        ans[i++] = (int) Math.floor((leftMaxHeap.peek() + rightMinHeap.peek()) / 2);
                    }
                }

            }

        }

        return ans;
    }
}
