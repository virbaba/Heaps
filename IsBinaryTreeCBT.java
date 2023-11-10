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
