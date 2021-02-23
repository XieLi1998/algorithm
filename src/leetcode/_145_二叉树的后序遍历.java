package leetcode;

import java.util.*;

/**
 * Created by xieli on 2021/2/23.
 */
public class _145_二叉树的后序遍历 {

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

    public List<Integer> postorderTraversal(TreeNode root) {
        inorder(root);
        return res;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        inorder(root.right);
        res.add(root.val);
    }

    // 迭代
    public List<Integer> postorderTraversal_02(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);               //把根节点放入栈中
                list.add(0, root.val);        //步骤一，在index=0处插入根结点的值
                root = root.right;              //步骤二，遍历右子树
            } else {
                TreeNode tmp = stack.pop();
                root = tmp.left;                //步骤三，遍历左子树
            }
        }
        return list;
    }

}
