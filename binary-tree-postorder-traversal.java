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
        //TODO 用迭代法后序遍历
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null){
            return result;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode pre = null;
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();

            //当前结点左右孩子为空或左右孩子已经处理完了就处理该结点
            if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))){
                result.add(cur.val);
                stack.pop();
                pre = cur;
            }else{
                //右孩子先进栈，使左孩子在栈顶，因为要先遍历左孩子
                if(cur.right != null){
                    stack.push(cur.right);
                }
                if(cur.left != null){
                    stack.push(cur.left);
                }
            }
        }
        return result;

    }
}

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