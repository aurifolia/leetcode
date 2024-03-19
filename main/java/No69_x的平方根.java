/**
 * @author vneli
 * @since 1.0
 */
public class No69_x的平方根 {
    /**
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     *
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     *
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     * @param args
     */
    public static void main(String[] args) {
        Solution691 solution = new Solution691();
        System.out.println(solution.mySqrt(2147395599));
        System.out.println(solution.mySqrt(3));
        System.out.println(solution.mySqrt(4));
        System.out.println(solution.mySqrt(8));
        System.out.println(solution.mySqrt(8));
        System.out.println(solution.mySqrt(9));
    }
}

class Solution691 {
    public int mySqrt(int x) {
        int result = find(x, 0, x);
        return result * result > x ? result - 1 : result;
    }

    public int find(int x, int left, int right) {
        if (left == right) {
            return left;
        }
        else if (left > right) {
            return right;
        }
        int mid = (left + right) >> 1;
        long multiply = (long) mid * mid;
        if (multiply > x) {
            return find(x, left, mid - 1);
        }
        else if (multiply < x) {
            return find(x, mid + 1, right);
        }
        else {
            return mid;
        }
    }
}
