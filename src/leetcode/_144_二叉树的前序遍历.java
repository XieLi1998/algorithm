package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xieli on 2021/2/23.
 */
public class _144_二叉树的前序遍历 {

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

    public List<Integer> preorderTraversal(TreeNode root) {
        inorder(root);
        return res;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        inorder(root.left);
        inorder(root.right);
    }

    // 迭代
    public List<Integer> preorderTraversal_02(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                list.add(root.val);     //步骤一，取根节点的值
                stack.push(root);       //把根节点放入栈中
                root = root.left;       //步骤二，遍历左子树
            } else {
                TreeNode tmp = stack.pop();
                root = tmp.right;       //步骤三，遍历右子树
            }
        }
        return list;
    }

    /**
     * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/16xing-dai-ma-mo-ban-qing-song-gao-ding-qian-xu-zh/
     */

}
