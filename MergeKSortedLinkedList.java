import java.util.PriorityQueue;

/****************************************************
 * Following is the Node class for the Singly Linked List
 * 
 * class LinkedListNode<Integer> {
 * int data;
 * LinkedListNode<Integer> next;
 * 
 * public LinkedListNode(int data) {
 * this.data = data;
 * }
 * }
 * 
 TIME COMPLEXTIY : O(N*K LOGK)
 SPACE COMPLEXITY : O(k)
 ****************************************************/
class Node implements Comparable<Node> {
    int val;
    LinkedListNode<Integer> add;

    public Node(int val, LinkedListNode<Integer> add) {
        this.val = val;
        this.add = add;
    }

    @Override
    public int compareTo(Node n) {
        return Integer.compare(this.val, n.val);
    }
}

public class Solution {
    public static LinkedListNode<Integer> mergeKLists(LinkedListNode<Integer>[] listArray) {
        // Write your code here.
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        LinkedListNode<Integer> dummy = new LinkedListNode<>(0);
        LinkedListNode<Integer> current = dummy;

        // Initialize the min heap with the first node from each list
        for (LinkedListNode<Integer> list : listArray) {
            if (list != null) {
                minHeap.offer(new Node(list.data, list));
            }
        }

        // Process the lists until the min heap is empty
        while (!minHeap.isEmpty()) {
            Node minNode = minHeap.poll();
            current.next = minNode.add;
            current = current.next;

            if (minNode.add.next != null) {
                minHeap.offer(new Node(minNode.add.next.data, minNode.add.next));
            }
        }

        return dummy.next;
    }
}
