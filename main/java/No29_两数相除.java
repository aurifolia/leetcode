import java.util.*;

/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No29_两数相除 {
    /**
     * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
     *
     * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
     *
     * 返回被除数 dividend 除以除数 divisor 得到的 商 。
     *
     * 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−231,  231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 231 − 1 ；如果商 严格小于 -231 ，则返回 -231 。
     * @param args
     */
    public static void main(String[] args) {
        Solution291 solution = new Solution291();
//        System.out.println(solution.multiply(10, 1997));
//        System.out.println(solution.divide(10, 3));
//        System.out.println(solution.divide(7, -3));
//        System.out.println(solution.divide(-2147483648, 2));
        System.out.println(solution.divide(2147483647, 1));
    }
}

class Solution291 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return  Integer.MAX_VALUE;
            }
            else if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
        }
        boolean negative = false;
        if (dividend > 0) {
            dividend = -dividend;
            negative = !negative;
        }
        if (divisor > 0) {
            divisor = -divisor;
            negative = !negative;
        }
        if (dividend > divisor) {
            return 0;
        }
        int left = dividend, right = -1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            int multiply = multiply(divisor, -mid);
            if (multiply > 0 || multiply < dividend) {
                left = mid + 1;
            }
            else {
                if (mid == right) {
                    return negative ? mid : -mid;
                }
                right = mid;
            }
        }
        return negative ? right : -right;
    }

    public int multiply(int a, int b) {
        int sum = a, power = 2;
        List<Integer> sums = new ArrayList<>();
        List<Integer> powers = new ArrayList<>();
        while (power > 0 && power <= b) {
            sum += sum;
            if (sum >= 0) {
                return 1;
            }
            sums.add(sum);
            powers.add(power);
            power <<= 1;
        }
        power >>>= 1;
        b -= power;
        if (b == 0) {
            return sum;
        }
        for (int i = sums.size() - 1; i >= 0; i--) {
            Integer currentPower = powers.get(i);
            if (currentPower <= b) {
                sum += sums.get(i);
                if (sum >= 0) {
                    return 1;
                }
                b -= currentPower;
            }
        }
        while (b > 0) {
            sum += a;
            if (sum >= 0) {
                return 1;
            }
            b--;
        }
        return sum;
    }
}
