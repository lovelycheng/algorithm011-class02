package Week_01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author chengtong
 * @date 2020/7/24 05:38
 */
public class TwoSumSolution {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> valIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            valIndexMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (valIndexMap.containsKey(key) && valIndexMap.get(key) != i) {
                return new int[]{i, valIndexMap.get(key)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 我以为是有序数组，其实不是。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumSorted(int[] nums, int target) {
        int p1 = 0, p2 = nums.length - 1;
        while (true) {
            if ((nums[p2] + nums[p1]) > target) {
                p2--;
                continue;
            }
            if ((nums[p2] + nums[p1]) < target) {
                p1++;
                continue;
            }
            if ((nums[p2] + nums[p1]) == target) {
                return new int[]{p1, p2};
            }
        }
    }

    public static void main(String[] args) {
        TwoSumSolution twoSumSolution = new TwoSumSolution();

        int[] ints = {3, 2, 4};

        ints = twoSumSolution.twoSum(ints, 6);
    }
}
