package 牛客题霸;

/**
 * Created by xieli on 2021/3/30.
 */
public class 平衡二叉树 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public boolean IsBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null)
            return 0;

        int left = recur(root.left);
        if (left == -1)
            return -1;

        int right = recur(root.right);
        if (right == -1)
            return -1;

        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

}
