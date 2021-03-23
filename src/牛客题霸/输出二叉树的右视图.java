package 牛客题霸;

import java.util.*;

/**
 * Created by xieli on 2021/3/24.
 */
public class 输出二叉树的右视图 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] solve(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, in);
        return rightSideView(root);
    }

    int[] preOrder;
    HashMap<Integer, Integer> dic = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        this.preOrder = pre;
        for (int i = 0; i < in.length; i++) {
            dic.put(in[i], i);
        }
        return recur(0, 0, in.length - 1);
    }

    private TreeNode recur(int root, int left, int right) {
        if (left > right)
            return null;
        TreeNode node = new TreeNode(preOrder[root]);
        int i = dic.get(preOrder[root]);
        node.left = recur(root + 1, left, i - 1);
        // 右子树的根的索引为先序中的 当前根位置 + 左子树的数量 + 1
        node.right = recur(root + (i - left) + 1, i + 1, right);
        return node;
    }

    public int[] rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

                if (i == n - 1) {
                    list.add(node.val);
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

}
