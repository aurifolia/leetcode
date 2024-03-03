/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No7_整数反转 {
    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     *
     * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
     *
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     * @param args
     */
    public static void main(String[] args) {
        Solution71 solution = new Solution71();
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(120));
    }
}

/**
 * 直接反转,使用先乘后除判断溢出
 */
class Solution71 {
    public int reverse(int x) {
        int result = 0;
        int prior = 0;
        while (x != 0) {
            int i = x % 10;
            x /= 10;
            prior = result;
            result = result * 10 + i;
            // 判断溢出
            if ((result - i) / 10 != prior) {
                return 0;
            }
        }
        return result;
    }
}
