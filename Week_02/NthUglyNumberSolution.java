package Week_02;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author chengtong
 * @date 2020/7/29 13:09
 */
public class NthUglyNumberSolution {
    private static int[] cache = {1, 2, 3, 4, 5, 6, 8, 9, 10, 12};
    private static HashSet<Integer> set = new HashSet<>();

    static {
        Arrays.stream(cache).forEach(e -> set.add(e));
    }

    /**
     * 1。 计算所有235的乘积 < 1690, 排序 ，三个循环 too much
     * //for(int x = 0;x<1690/2;x+=1){
     * for (int y =0;y<1690/3;y+=1){
     * for (int z = 0;z<1690/5;z+=1){
     * seed = x * 2 + y * 3 + z * 5;
     * if(seed == 0){
     * continue;
     * }
     * set.add(seed);
     * }
     * }
     * }
     * 2. 遍历所有数字判断是否是 丑数
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if (n <= 10) {
            return cache[n - 1];
        }

        for (int x = 13; ; x++) {
            if (isUglyNumber(x)) {
                set.add(x);
                if (set.size() == n) {
                    return x;
                }
            }

        }
    }


    private boolean isUglyNumber(int num) {

        if (NotAUglyNum(num)) {
            return false;
        }
        while (!set.contains(num)) {
            if (num % 3 == 0) {
                num = num / 3;
            }
            if (num % 5 == 0) {
                num = num / 5;
            }
            if (num % 2 == 0) {
                num = num / 2;
            }
            if (NotAUglyNum(num)) {
                return false;
            }
        }
        return true;
    }

    private boolean NotAUglyNum(int num) {
        if (num == 1) {
            return false;
        }
        return (num % 3 != 0) && (num % 2 != 0) && (num % 5 != 0);
    }


    public static void main(String[] args) {
        NthUglyNumberSolution solution = new NthUglyNumberSolution();
        int c = solution.nthUglyNumber(446);
    }

}
