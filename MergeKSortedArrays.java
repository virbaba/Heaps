/*
  The approach behind this question is that we store 0th element of each sub array and make a data structure type  Node with comparator which help to compare k value from k subarray 
  and store into min heap.
  we remove peek element from priority queue which is small into all sub k array and we also track row and column .
  we add next column value  from the current row where the value is remove from heap.
  mean when we remove element from heap we have also row and column tracking for this element and then we add same row and col + 1 element and maintain also heap
*/
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

class Node implements Comparable<Node>{
	int val, row, col;
	Node(int val, int row, int col){
		this.val = val;
		this.row = row;
		this.col = col;
	}
	@Override public int compareTo(Node n){
		if(this.val <= n.val)
			return -1;
		
		return 1;
	}
}

public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		// Write your code here.
		PriorityQueue<Node> q = new PriorityQueue<>();
		for(int row = 0; row < kArrays.size(); row++){
			q.offer(new Node(kArrays.get(row).get(0), row, 0));
		}

		ArrayList<Integer> ans = new ArrayList<>();
		while(!q.isEmpty()){
			Node curr = q.poll();
			ans.add(curr.val);

			if(curr.col < kArrays.get(curr.row).size() - 1){
				int val = kArrays.get(curr.row).get(curr.col+1);
				q.offer(new Node(val, curr.row, curr.col+1));
			}
		}

		return ans;
	}
}
