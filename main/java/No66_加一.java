import java.util.Arrays;

/**
 * @author vneli
 * @since 1.0
 */
public class No66_加一 {
    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * @param args
     */
    public static void main(String[] args) {
        Solution661 solution = new Solution661();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1,2,3})));
    }
}

class Solution661 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] result = new int[n];
        int signify = 0;
        int sum = digits[n - 1] + 1;
        if (sum >= 10) {
            signify = sum / 10;
            sum %= 10;
        }
        result[n - 1] = sum;
        for (int i = n - 2; i >= 0; i--) {
            sum = digits[i] + signify;
            if (sum >= 10) {
                signify = sum / 10;
                sum %= 10;
            }
            else {
                signify = 0;
            }
            result[i] = sum;
        }
        if (signify != 0) {
            int[] newResult = new int[n + 1];
            System.arraycopy(result, 0, newResult, 1, n);
            newResult[0] = signify;
            result = newResult;
        }
        return result;
    }
}
