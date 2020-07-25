package Week_01;

/**
 * @author chengtong
 * @date 2020/7/24 04:00
 */
public class MergeSolution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m + n - 1, i3 = n - 1;
        int i2 = m - 1;
        while (i1 >= 0 && i3 >= 0 && i2 >= 0) {
            nums1[i1] = nums1[i2] >= nums2[i3] ? nums1[i2--] : nums2[i3--];
            i1--;
        }
        if(i3>=0){ //第二个数组仍然有剩下
            System.arraycopy(nums2,0,nums1,0,i3+1);
        }

    }


    public static void main(String[] args) {
        MergeSolution mergeSolution = new MergeSolution();

        int[] nums1 = {4,5,6,0,0,0};//
        int[] nums2 = {3,7,8};
        // 为什么能允许 [0],0,[1],1的输入？
        mergeSolution.merge(nums1, 3, nums2, 3);

    }

}
