package Week_01;

/**
 * @author chengtong
 * @date 2020/7/24 06:47
 */
public class PlusOneSolution {

    /**
     * 如果最后一位加一，等于10，前一位进一，从后向前遍历。
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        boolean plus = true;//多余的标志位
        for (int i = len - 1; i >= 0; i--) {
            int d = digits[i];
            if (plus) {
                if (d + 1 == 10) {
                    digits[i] = 0;
                } else {
                    digits[i] = d + 1;
                    plus = false;
                }
            } else {
                digits[i] = d;
                plus = false;
            }
        }
        if (plus) {
            int[] ints = new int[len + 1];
            ints[0] = 1;
            return ints;
        }

        return digits;
    }

    /**
     * 如果最后一位加1不等于10  直接就返回了。不需要一个额外的标志位。
     * @param digits
     * @return
     */
    public int[] plusOneThin(int[] digits){
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


    public static void main(String[] args) {
        PlusOneSolution s = new PlusOneSolution();
        int[] ss = s.plusOne(new int[]{1,2,3});

    }

}
