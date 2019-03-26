//Question: Given a binary tree, return the preorder traversal of its nodes' values.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        //TODO 用递归法前序遍历
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null){
            return result;
        }

        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        

        return result;
    }
}