/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No9_回文数 {
    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     *
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 例如，121 是回文，而 123 不是。
     *
     *
     * 示例 1：
     *
     * 输入：x = 121
     * 输出：true
     * 示例 2：
     *
     * 输入：x = -121
     * 输出：false
     * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3：
     *
     * 输入：x = 10
     * 输出：false
     * 解释：从右向左读, 为 01 。因此它不是一个回文数。
     *
     *
     * 提示：
     *
     * -231 <= x <= 231 - 1
     * @param args
     */
    public static void main(String[] args) {
        Solution91 solution = new Solution91();
        System.out.println(solution.isPalindrome(12321));
    }
}

/**
 * 直接法
 */
class Solution91 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int rev = 0;
        int xb = x;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev == xb;
    }
}
