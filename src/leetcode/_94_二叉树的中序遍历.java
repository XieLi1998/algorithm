package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xieli on 2021/2/23.
 */
public class _94_二叉树的中序遍历 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 递归
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return res;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }

    // 迭代
    public List<Integer> inorderTraversal_02(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);       //把根节点放入栈中
                root = root.left;       //步骤一，遍历左子树
            } else {
                TreeNode tmp = stack.pop();
                list.add(tmp.val);      //步骤二，取根结点的值
                root = tmp.right;       //步骤三，遍历右子树
            }
        }
        return list;
    }

}
