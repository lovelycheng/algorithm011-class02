package Week_02;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author chengtong
 * @date 2020/7/28 11:12
 */
public class TreePreOrderSolution {

    public List<Integer> preOrder(TreeNode treeNode) {

        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        List<Integer> list = new ArrayList<>();
        TreeNode curr = treeNode;
        while (curr != null || !queue.isEmpty()) {

            while(curr != null){
                queue.add(curr);
                curr = curr.left;
            }

            TreeNode node = queue.poll();
            list.add(node.val);
            curr = curr.right;

        }

        return list;
    }


}
