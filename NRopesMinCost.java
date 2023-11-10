/*
  input : 4 3 2 6
  step 1
    3 + 2 = 5 now array = 4 5 6
  step 2
    4 + 5 = 9 now array = 6 9
  step 3
    6 + 9 = 15 now array is 15

  so output is 5 + 9 + 15 = 29.

  so here we can use min heap
    
*/
import java.util.*;
public class Solution 
{
    public static long connectRopes(int[] arr)
    {
        //Write your code here
        PriorityQueue<Long> q = new PriorityQueue<>();
        for(int e : arr)
            q.offer((long)e);



        long ans = 0;
        while(q.size() >= 2){
            long a = q.poll();
            long b = q.poll();

            ans += a + b;
            q.offer(a+b);
        }

        return ans;
    }
}
