package Week_02;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author chengtong
 * @date 2020/7/28 11:12
 */
public class TreePreOrderSolution {

    public List<Integer> preOrderUseStack(TreeNode root) { // 栈的迭代算法的问题是 右边的子树都是最后才遍历的。curr = curr.left
        // 限制了能先获得左边数据脊的数据，能满足 pre｜in - order
        // 构造 左右中的反序 - 中右左
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {

            while(curr != null){
                list.add(0,curr.val);// 中
                stack.push(curr);
                curr = curr.right;
            }

            TreeNode node = stack.pop();
            curr = node.left;

        }

        return list;
    }
}


