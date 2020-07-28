package Week_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author chengtong
 * @date 2020/7/28 09:48
 */
public class TreeInOrderSolution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList();
        inOrder(root,l);
        return l;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public List<Integer> inorderTraversalUseStack(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode c = root;
        while(c != null || !stack.isEmpty()){

            while(c != null){
                stack.push(c);
                c = c.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            c = node.right;

        }

        return list;
    }
    // 反序的 右中左
    public List<Integer> inorderTraversalUseStackReverse(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        TreeNode c = root;
        while(c != null || !stack.isEmpty()){

            while(c != null){
                stack.push(c);
                c = c.right;
            }
            TreeNode node = stack.pop();
            list.add(0,node.val);
            c = node.left;

        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1,null,null);
        node.right = new TreeNode(2,new TreeNode(3,null,null),null);

        TreeInOrderSolution solution = new TreeInOrderSolution();

        List<Integer> s = solution.inorderTraversal(node);

        List<Integer> s2 = solution.inorderTraversalUseStack(node);

        List<Integer> s3 = solution.inorderTraversalUseStackReverse(node);



    }


}
