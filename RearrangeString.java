/*
  Time complexity : O(n+k*logk)
  Space complexity : O(n+k)
*/
import java.util.* ;
import java.io.*; 

class Node implements Comparable<Node>{
    String s;
    int freq;
    public Node(String s, int freq){
        this.s = s;
        this.freq = freq;
    }

    @Override
    public int compareTo(Node n){
        return (this.freq <= n.freq)? -1: 1;
    }
}
public class Solution {

    public static String reArrangeString(String s) {
        // Write your code here.
       // Convert the HashMap to a TreeMap to get keys in sorted order
        Map<Character, Integer> map = new TreeMap<>();

        PriorityQueue<Node> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, 1);
            }
            else    
                map.put(c, map.get(c)+1);
        }

        // Get the keys in sorted order
        Set<Character> sortedKeys = map.keySet();

        for(Character c : sortedKeys ){
           q.offer(new Node(""+c, map.get(c)));
        }


        StringBuffer ans = new StringBuffer();

        Node curr = q.poll();
        ans.append(curr.s);

        Node block = new Node(curr.s, curr.freq);
        Node temp = null;
        block.freq -= 1;

        while(!q.isEmpty()){
            temp = q.poll();
            ans.append(temp.s);
            if(block.freq > 0)
                q.offer(block);
            block = temp;
            block.freq -= 1;
        }

        if(q.isEmpty() && block.freq > 0)
            return "not possible";
            
        return ans.toString();

        


    }

}
