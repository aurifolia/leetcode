/**
 * @author vneli
 * @since 1.0
 */
public class No91_解码方法 {
    /**
     * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
     *
     * 'A' -> "1"
     * 'B' -> "2"
     * ...
     * 'Z' -> "26"
     * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
     *
     * "AAJF" ，将消息分组为 (1 1 10 6)
     * "KJF" ，将消息分组为 (11 10 6)
     * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
     *
     * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
     *
     * 题目数据保证答案肯定是一个 32 位 的整数。
     * @param args
     */
    public static void main(String[] args) {
        Solution911 solution = new Solution911();
//        System.out.println(solution.numDecodings("2101"));
//        System.out.println(solution.numDecodings("10"));
//        System.out.println(solution.numDecodings("12"));
//        System.out.println(solution.numDecodings("226"));
        System.out.println(solution.numDecodings("230"));
    }
}

class Solution911 {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        if ((s.charAt(0) - '0') * 10 + (s.charAt(1) - '0') <= 26) {
            if (s.charAt(1) == '0') {
                dp[1] = 1;
            }
            else {
                dp[1] = 2;
            }
        }
        else {
            if (s.charAt(1) == '0') {
                return 0;
            }
            else {
                dp[1] = 1;
            }
        }
        for (int i = 2; i < n; i++) {
            if ((s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0') <= 26) {
                if (s.charAt(i) == '0' && s.charAt(i - 1) != '0') {
                    dp[i] = dp[i - 2];
                }
                else if (s.charAt(i) == '0' && s.charAt(i - 1) == '0') {
                    return 0;
                }
                else if (s.charAt(i) != '0' && s.charAt(i - 1) == '0') {
                    dp[i] = dp[i - 1];
                }
                else {
                    dp[i] = dp[i - 2] + dp[i - 1];
                }
            }
            else {
                if (s.charAt(i) == '0') {
                    return 0;
                }
                else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[n - 1];
    }
}
