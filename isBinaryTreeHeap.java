/*
    Approach: first we count total node into the tree and then for each node we derived left and right index and then we check that is left index or right index is less than to 
    totalcount. if index going to greater or equall to total count then we return false other wise true;
    
    Time Complexity : O(N)
    Space Complexity : O(N)

  
*/
import java.util.* ;
import java.io.*; 

public class Solution {
    // fistly count total node
    public static int countNode(TreeNode<Integer> root){
        if(root == null)
            return 0;
        
        return 1 + countNode(root.left) + countNode(root.right);
    }

    public static boolean isCBT(TreeNode<Integer> root, int index, int totalNode){
        if(root ==  null)
            return true;
        
        if(index >= totalNode)
            return false;
        
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        return isCBT(root.left, left, totalNode) && isCBT(root.right, right, totalNode);
    }
    public static int isCompleteBinaryTree(TreeNode<Integer> root) {
        // Write your code here
        int totalNode = countNode(root);
        if(isCBT(root, 0, totalNode)){
            return 1;
        }

        return 0;
    }
}
