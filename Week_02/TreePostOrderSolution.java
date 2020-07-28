package Week_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chengtong
 * @date 2020/7/28 18:14
 */
public class TreePostOrderSolution {

    public List<Integer> postOrderRecursive(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        doPostOrder(treeNode, list);
        return list;
    }

    private void doPostOrder(TreeNode treeNode, List<Integer> l) {
        if (treeNode == null) {
            return;
        }
        doPostOrder(treeNode.left, l);
        doPostOrder(treeNode.right, l);
        l.add(treeNode.val);
    }

    public List<Integer> postOrder(TreeNode treeNode) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode c = treeNode;
        while (c != null || !stack.isEmpty()) {

            while (c != null) {
                list.add(0,c.val);
                stack.push(c);
                c = c.left;
            }

            TreeNode left = stack.pop();
            c = left.right;
        }

        return list;
    }


    public List<Integer> postOrderTwo(TreeNode treeNode) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode c = treeNode;
        stack.push(treeNode);
        while (c != null || !stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
            list.add(0,node.val);
        }

        return list;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1,new TreeNode(3, new TreeNode(4,null,null),new TreeNode(5,null,null)),
                new TreeNode(2,null,null));

        TreePostOrderSolution solution = new TreePostOrderSolution();
        List list = solution.postOrderTwo(root);


    }
}
