package Week_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author chengtong
 * @date 2020/7/28 17:24
 */
public class NTreeNode {

    public Integer val;

    List<NTreeNode> children;

    public NTreeNode(Integer val, List<NTreeNode> children) {
        this.val = val;
        this.children = children;
    }

    public NTreeNode(Integer val, int children, NTreeNode parent) {
        this.val = val;
        List<NTreeNode> c = new ArrayList<>();
        Random random = new Random(10);
        for(int i = 0;i<children;i++){
            c.add(new NTreeNode(random.nextInt(10),new ArrayList<>()));
        }

        this.children = c;

        parent.children.add(this);
    }
}
