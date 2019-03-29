/*
Question:

Given a binary tree, find its minimum depth.The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

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
    public int run(TreeNode root) {
        if(root == null){
            return 0;
        }

        //如果两边都不为null
        else if(root.left != null && root.right != null){
            int minLeft = run(root.left);
            int minRight = run(root.right);

            //判断哪一边更浅
            if(minLeft<minRight){
                return minLeft+1;
            }else{
                return minRight+1;
            }

        //如果只是左不为null
        }else if(root.left!=null){
            return run(root.left)+1;

        //如果只是右不为null或左右都是null
        }else{
            return run(root.right)+1;
        }
    }
}