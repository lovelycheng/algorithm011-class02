package Week_03;

import java.util.*;

/**
 * @author chengtong
 * @date 2020/8/3 18:52
 */
public class PermuteUniqueSolution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];

        solve(stack, nums, lists, used);
        return lists;
    }

    private void solve(ArrayDeque<Integer> stack, int[] nums, List<List<Integer>> lists, boolean[] used) {
         if (stack.size() == nums.length) {
            lists.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                continue;
            }
            if (used[i]) {
                continue;
            }
            used[i] = true;
            stack.addLast(nums[i]);
            solve(stack, nums, lists, used);
            stack.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        PermuteUniqueSolution solution = new PermuteUniqueSolution();
        int[] ii = {1, 1, 2};
        for (List<Integer> list : solution.permuteUnique(ii)) {
            System.out.println(list);
        }
    }
}
