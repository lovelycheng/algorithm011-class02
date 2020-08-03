package Week_03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * @author chengtong
 * @date 2020/8/3 18:14
 */
public class PermuteSolution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> stack = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        doPermute(stack, lists, nums, used);
        return lists;
    }

    private void doPermute(ArrayList<Integer> stack, List<List<Integer>> lists, int[] nums, boolean[] used) {
        if (stack.size() == nums.length) {
            lists.add(stack);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            stack.add(nums[i]);
            doPermute(stack, lists, nums, used);
            stack.remove(stack.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        PermuteSolution solution = new PermuteSolution();
        int[] ints = {1, 2, 3};
        List<List<Integer>> lists = solution.permute(ints);

        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }


}
