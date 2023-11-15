/*
  TIME COMPLEXITY : O(N*LOGK)
  SPACE COMPLEXITY : O(K)

  WE ALWAYS MAINTAIN MIN AND MAX AND CHECK THE DIFFERENCE IF AND MINIMUM DIFFERENCE IS OUR ANSWER
*/
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int val, row, col;

    public Node(int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }

    @Override
    public int compareTo(Node n) {
        return (this.val <= n.val) ? -1 : 1;
    }
}

public class Solution {
    public static int kSorted(int[][] a, int k, int n) {
        // Write your code here.
        PriorityQueue<Node> q = new PriorityQueue<>();
        int[] ans = new int[2];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        
        for (int row = 0; row < k; row++) {
            int val = a[row][0];
            if (max < val)
                max = val;
            if (min > val)
                min = val;
            q.offer(new Node(val, row, 0));
        }
        ans[0] = min;
        ans[1] = max;

        while (!q.isEmpty()) {

            Node curr = q.poll();
            min = curr.val;

            if ((max - min) < (ans[1] - ans[0])) {
                ans[0] = min;
                ans[1] = max;
            }

            if (curr.col + 1 < a[curr.row].length) {
                int val = a[curr.row][curr.col + 1];
                if (max < val)
                    max = val;

                q.offer(new Node(val, curr.row, curr.col + 1));

            }
            else
                break;
        }
        return ans[1] - ans[0] + 1;
    }
}
