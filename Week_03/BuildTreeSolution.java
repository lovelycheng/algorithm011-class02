package Week_03;

import Week_02.TreeInOrderSolution;
import Week_02.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author chengtong
 * @date 2020/8/2 13:53
 */
public class BuildTreeSolution {

    TreeNode buildTree(int[] preorder, int[] inorder) {

        int rootIndexPreOrder = 0;
        int rootIndexInOrder = 0;

        HashMap<Integer, Integer> val2Index = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            val2Index.put(inorder[i], i);
            if (inorder[i] == preorder[0]) {
                rootIndexInOrder = i;
            }
        }

        return buildChild(rootIndexPreOrder, rootIndexInOrder, preorder, val2Index,
                rootIndexInOrder, inorder.length - rootIndexInOrder - 1);
    }

    /**
     * @param rootIndexInPreOrder 当前节点在前序遍历数组的下标
     * @param rootIndexInInOrder  当前节点在中序遍历数组的下标
     * @param preorder            前序遍历数组
     * @param val2Index           中序遍历数据 的 val-index 映射
     * @param leftLength          当前节点的左子树长度
     * @param rightLength         当前节点的右子树长度
     * @return
     */
    private TreeNode buildChild(int rootIndexInPreOrder, int rootIndexInInOrder, int[] preorder,
                                HashMap<Integer, Integer> val2Index, int leftLength, int rightLength) {

        TreeNode node = new TreeNode(preorder[rootIndexInPreOrder], null, null);

        if (leftLength > 0) {
            int leftChildIndex = val2Index.get(preorder[rootIndexInPreOrder + 1]);
            int leftChildRightLength = rootIndexInInOrder - leftChildIndex - 1;
            int leftChildLeftLength = leftLength - leftChildRightLength - 1;
            node.left = buildChild(rootIndexInPreOrder + 1, leftChildIndex, preorder, val2Index, leftChildLeftLength, leftChildRightLength);
        }

        if (rightLength > 0) {
            int rightChildIndex = rootIndexInPreOrder + leftLength + 1;
            int val = preorder[rightChildIndex];
            int rightChildInInOrderIndex = val2Index.get(val);
            int rightChildLeftLength = rightChildInInOrderIndex - rootIndexInInOrder - 1;
            int rightChildRightLength = rightLength - rightChildLeftLength - 1;
            node.right = buildChild(rightChildIndex, rightChildInInOrderIndex, preorder,
                    val2Index, rightChildLeftLength, rightChildRightLength);
        }

        return node;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        BuildTreeSolution solution = new BuildTreeSolution();
        TreeNode s = solution.buildTreeAdvanced(preorder, inorder);

        TreeInOrderSolution solution1 = new TreeInOrderSolution();

        List<Integer> list = solution1.inorderTraversal(s);

        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println("");


        new ArrayList<>(new HashSet<>());
    }


    TreeNode buildTreeAdvanced(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> val2Index = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            val2Index.put(inorder[i], i);
        }

        return buildTree(0,inorder.length- 1,val2Index,preorder,inorder,0);

    }

    /**
     * 返回子树的root，根据传入的数据指针确定左右节点。
     * iStart - iEnd 是 inOrder的区段 表示子树的数据
     *
     * @return
     */
    TreeNode buildTree(int iStart,int iEnd,HashMap<Integer,Integer> val2index,int[] preorder,int[] inorder,int root) {

        // terminator
        if(iStart > iEnd){
            return null;
        }

        TreeNode treeNode = new TreeNode(preorder[root],null,null);
        int index = val2index.get(treeNode.val);

        TreeNode left = buildTree(iStart, index - 1, val2index, preorder, inorder,  root+1);
        TreeNode right = buildTree(index + 1,iEnd,val2index,preorder,inorder,root + (index - iStart) + 1);
        treeNode.left = left;
        treeNode.right = right;

        // reverse state
        return treeNode;
    }


}
