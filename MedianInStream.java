import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static int[] findMedian(int[] arr, int n) {
        // Write your code here.
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        int[] ans = new int[n];
        int index = 0;

        for (int ele : arr) {
            if (maxPQ.isEmpty()) {
                maxPQ.offer(ele);
            } else if (minPQ.isEmpty()) {
                minPQ.offer(ele);
            }else {
                if (maxPQ.peek() > ele) {
                    while (!maxPQ.isEmpty() && maxPQ.peek() > ele)
                        minPQ.offer(maxPQ.poll());
                    maxPQ.offer(ele);
                } else {
                    minPQ.offer(ele);
                }

                while (!minPQ.isEmpty() && minPQ.size() > maxPQ.size())
                    maxPQ.offer(minPQ.poll());

            }
            if (maxPQ.size() == minPQ.size()) {
                ans[index++] = (maxPQ.peek() + minPQ.peek()) / 2;
            } else if (maxPQ.size() > minPQ.size()) {
                ans[index++] = maxPQ.peek();
            }
        }
        return ans;
    }
}
