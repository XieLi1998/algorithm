package 牛客题霸;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xieli on 2021/2/23.
 */
public class 实现二叉树先_中_后序遍历 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public int[][] threeOrders(TreeNode root) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        preOrder(root, list1);
        inOrder(root, list2);
        postOrder(root, list3);

        int[][] res = new int[3][list1.size()];
        for (int i = 0; i < list1.size(); i++) {
            res[0][i] = list1.get(i);
            res[1][i] = list2.get(i);
            res[2][i] = list3.get(i);
        }

        return res;
    }

    public void preOrder(TreeNode root, List<Integer> list1) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                list1.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                TreeNode tmp = stack.pop();
                root = tmp.right;
            }
        }
    }

    public void inOrder(TreeNode root, List<Integer> list2) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode tmp = stack.pop();
                list2.add(tmp.val);
                root = tmp.right;
            }
        }
    }

    public void postOrder(TreeNode root, List<Integer> list3) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                list3.add(0, root.val);
                stack.push(root);
                root = root.right;
            } else {
                TreeNode tmp = stack.pop();
                root = tmp.left;
            }
        }
    }

}
