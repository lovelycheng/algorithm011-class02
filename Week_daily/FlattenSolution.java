package Week_daily;


import Week_02.TreeNode;

/**
 * @author chengtong
 * @date 2020/8/2 23:41
 */
public class FlattenSolution {

    void flatten(TreeNode treeNode){
        transLeftToRight(treeNode);
    }

    /**
     *
     *
     * @param node
     * @return
     */
    TreeNode transLeftToRight(TreeNode node){

        if(node.left == null && node.right == null){
            return node;
        }

        TreeNode right = node.right;
        node.right = node.left;
        node.left = null;
        TreeNode lastRight = null;
        if(node.right != null){
            lastRight = transLeftToRight(node.right);
        }

        if(right != null){
            TreeNode rightLastRight = transLeftToRight(right);
            if(lastRight != null){
                lastRight.right = right;
            }else {
                node.right = right;
            }
            lastRight = rightLastRight;
        }

        return lastRight;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,null,null);
        treeNode.left = new TreeNode(2,null,null);
        treeNode.right = new TreeNode(5,null,null);


        treeNode.left.left = new TreeNode(3,null,null);
        treeNode.left.right = new TreeNode(4,null,null);

        treeNode.right.right = new TreeNode(6,null,null);

        FlattenSolution solution = new FlattenSolution();
        solution.flatten(treeNode);
    }
}
