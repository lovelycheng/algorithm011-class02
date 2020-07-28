package Week_02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengtong
 * @date 2020/7/28 17:23
 */
public class NTreePostOrderSolution {

    public List<Integer> postorder(NTreeNode root) {
        List<Integer> list = new ArrayList<>();
        doPostOrder(root,list);
        return list;
    }

    private void doPostOrder(NTreeNode root,List<Integer> list){

        if(root == null){
            return;
        }
        for(NTreeNode node : root.children){
            doPostOrder(node,list);
        }

        list.add(root.val);

    }


    public static void main(String[] args) {

        NTreeNode  root = new NTreeNode(7,new ArrayList<>());
        new NTreeNode(5,2,root);
        new NTreeNode(4,3,root);
        new NTreeNode(1,2,root);

        NTreePostOrderSolution solution = new NTreePostOrderSolution();
        List<Integer> list = solution.postorder(root);

        for (Integer integer : list){
            System.out.print(integer+" ");
        }


    }


}
