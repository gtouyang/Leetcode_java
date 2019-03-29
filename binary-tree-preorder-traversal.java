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
        //TODO 用迭代法前序遍历
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null){
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        stack.push(root);

        while(!stack.isEmpty()){
            //将当前结点(根)放入result中，并将左右孩子放入栈中，右孩子先进，让左孩子在栈顶
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }

        return result;
    }
}

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