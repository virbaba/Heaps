import java.util.*;
import java.io.*;

/*************************************************************
 * 
 * Following is the Binary Tree Node structure:
 * 
 * class BinaryTreeNode {
 * 
 * int data;
 * BinaryTreeNode left;
 * BinaryTreeNode right;
 * 
 * BinaryTreeNode(int data) {
 * this.data = data;
 * left = null;
 * right = null;
 * }
 * }
 * 

 Approach : 1. Check is binary Tree is CBT
            2. Check is binary Tree is Max Heap
 *************************************************************/

public class Solution {

	public static int countNode(BinaryTreeNode root) {
		if (root == null)
			return 0;

		int left = countNode(root.left);
		int right = countNode(root.right);

		return 1 + left + right;
	}

	public static boolean isCBT(BinaryTreeNode root, int index, int totalNode) {
		if (root == null)
			return true;

		if (index >= totalNode)
			return false;

		int left = 2 * index + 1;
		int right = 2 * index + 2;

		return isCBT(root.left, left, totalNode) && isCBT(root.right, right, totalNode);
	}

	public static boolean isMaxHeap(BinaryTreeNode root){
		if(root == null)
			return true;
		
		if(root.left != null && root.right != null){
			if(root.data < root.left.data && root.data < root.right.data)
				return false;

		}
		if(root.left != null){
			if(root.data < root.left.data)
				return false;
		}
		
		
		return isMaxHeap(root.left) && isMaxHeap(root.right);
	}

	public static String isBinaryHeapTree(BinaryTreeNode root) {
		
		// for solve this question we have to do two thing
		// 1 check is tree CBT or not 
		// 2 check is either max heap or min heap or not
		int totalNode = countNode(root);
		if(isCBT(root, 0, totalNode) && isMaxHeap(root)){
			return "True";
		}

		return "False";

	}
}
