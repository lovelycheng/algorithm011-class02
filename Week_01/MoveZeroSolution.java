package Week_01;

/**
 * @author chengtong
 * @date 2020/7/24 06:32
 */
public class MoveZeroSolution {
    /**
     * 理论上是快慢指针。移动其实是个幌子，问题不是移动。赋值永远比交换快。
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int p = 0;
        for(int i:nums){
            if(i != 0){
                nums[p] =i;
                p++;
            }
        }
        while(p < nums.length){
            nums[p++] = 0;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        new MoveZeroSolution().moveZeroes(nums);
    }
}



