/*
Question:
Given a binary tree containing digits from0-9only, each root-to-leaf path could represent a number.
*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if(root == null){
            return 0;
        }
        return sumNumbersHelper(root, sum);
        
    }
    
    private int sumNumbersHelper(TreeNode root, int sum){
        sum = sum * 10 + root.val;

        if(root.left == null && root.right == null){
            return sum;
        }

        int left_v = 0;
        int right_v = 0;
        if(root.left != null){
            left_v = sumNumbersHelper(root.left, sum);
        }
        if(root.right != null){
            right_v = sumNumbersHelper(root.right, sum);
        }
        return left_v + right_v;
    }
}