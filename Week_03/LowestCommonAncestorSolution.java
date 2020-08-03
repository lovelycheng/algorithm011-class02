package Week_03;

import Week_02.TreeNode;

import java.util.Stack;

/**
 * @author chengtong
 * @date 2020/8/3 14:04
 */
public class LowestCommonAncestorSolution {

    /**
     * 最开始的想法是 利用中序遍历直接走到左下角，往上遍历，但是给了树顶还得从下网上，这个其实就很不符合实际情况。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}
