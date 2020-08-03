package Week_daily;

import java.util.Arrays;

/**
 * @author chengtong
 * @date 2020/8/3 00:16
 */
public class AddStringsSolution {

    public String addStrings(String num1, String num2) {


        char[] num1s = num1.toCharArray();
        char[] num2s = num2.toCharArray();

        char[] result = new char[Math.max(num1s.length,num2s.length)];

        int plus = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int number1 = i >= 0 ? num1s[i] - 48 : 0;
            int number2 = j >= 0 ? num2s[j] - 48 : 0;
            int res = (number1 + number2 + plus) % 10;

            plus = (number1 + number2 + plus) / 10;
            result[Math.max(i,j)] = (char) (res + 48);

        }
        if (plus > 0) {
            return "1"+ String.valueOf(result);
        }

        return String.valueOf(result);

    }


    public static void main(String[] args) {
        String num1 = "999";
        String num2 = "1234";
        String sum = new AddStringsSolution().addStrings(num1, num2);
        System.out.println(sum);
    }
}
