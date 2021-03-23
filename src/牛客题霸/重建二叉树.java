package 牛客题霸;

import java.util.HashMap;

/**
 * Created by xieli on 2021/3/15.
 */
public class 重建二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int[] preOrder;
    HashMap<Integer, Integer> dic = new HashMap<>();

    /**
     * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/mian-shi-ti-07-zhong-jian-er-cha-shu-di-gui-fa-qin/
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        this.preOrder = pre;
        for (int i = 0; i < in.length; i++) {
            dic.put(in[i], i);
        }
        return recur(0, 0, in.length - 1);
    }

    private TreeNode recur(int root, int left, int right) {
        if (left > right)
            return null;        // 递归终止
        TreeNode node = new TreeNode(preOrder[root]);     // 建立根节点
        int i = dic.get(preOrder[root]);            // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1);   // 开启左子树递归
        // 右子树的根的索引为先序中的 当前根位置 + 左子树的数量 + 1
        node.right = recur(root + (i - left) + 1, i + 1, right);  // 开启右子树递归
        return node;                                // 回溯返回根节点
    }

}
