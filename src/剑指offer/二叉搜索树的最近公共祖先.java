package 剑指offer;

/**
 * Created by xieli on 2021/3/12.
 */
public class 二叉搜索树的最近公共祖先 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 迭代
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val)   // p,q 都在 root 的右子树中
                root = root.right;      // 遍历至右子节点
            else if (root.val > p.val && root.val > q.val)  // p,q 都在 root 的左子树中
                root = root.left;       // 遍历至左子节点
            else
                break;
        }
        return root;
    }

    // 递归
    public TreeNode lowestCommonAncestor_02(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }

}
