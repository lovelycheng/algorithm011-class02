package Week_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chengtong
 * @date 2020/8/3 16:35
 */
public class CombineSolution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        doCombine(stack, lists, n, k, 1);
        return lists;
    }

    private void doCombine(Stack<Integer> stack, List<List<Integer>> lists, int n, int k
            , int start) {
        if(stack.size() == k){
            lists.add(new ArrayList<>(stack));
            return;
        }
        for (; start <= n - (k - stack.size()) + 1; start++) {
            stack.push(start);
            doCombine(stack, lists, n, k, start+1);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        CombineSolution solution = new CombineSolution();
        List<List<Integer>> lists = solution.combine(5,3);

        for(List<Integer> list:lists){
            System.out.println(list);
        }
    }

}
