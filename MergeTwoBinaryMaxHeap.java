import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> mergeHeap(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        //  Write your code here...
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int e : arr1){
            q.offer(e);
        }

        for(int e : arr2){
            q.offer(e);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            ans.add(q.poll());
        }

        return ans;
    }
}
