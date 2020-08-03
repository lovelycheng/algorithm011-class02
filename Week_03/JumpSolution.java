package Week_03;

/**
 * @author chengtong
 * @date 2020/8/2 22:50
 */
public class JumpSolution {

    public boolean canJump(int[] nums) {
        int count = 0;
        int len = nums.length;
        int p = 0;
        int step = nums[p];
        int temp =0 ;
        int start = 0;

        while(true){
            for(;start<=step;start++){
                int step1 = nums[start] + start;
                if(step1 > temp){
                    temp = step1;
                }
            }
            count++;
            step = temp;
            System.out.println("最远距离："+step);
            if(step >= len-1){
                return true;
            }
            if(start > step){
                return false;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {2,3,1,1,1,1,1,1,2};

        JumpSolution solution = new JumpSolution();
        solution.canJump(ints);
    }


}
