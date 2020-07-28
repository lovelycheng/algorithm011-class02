package Week_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author chengtong
 * @date 2020/7/28 12:11
 */
public class TreeLevelOrderSolution {

    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
        //先等等
        return  null;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        //Queue<List<TreeNode>> queue = new LinkedBlockingQueue<>();//List 元素的 queue，占用的内存过大了
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        List<List<Integer>> list = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            //使用Size
            int size = queue.size();

            List<Integer> integers = new ArrayList<>();
            for (int i =0; i<size;i++) {
                TreeNode treeNode = queue.remove();
                integers.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }

            list.add(integers);
        }

        return list;

    }


}
