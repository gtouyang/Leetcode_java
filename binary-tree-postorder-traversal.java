//Question: Given a binary tree, return the postorder traversal of its nodes' values.

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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        //TODO 用递归法后序遍历
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null){
            return result;
        }

        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);

        return result;

    }
}