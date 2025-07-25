package round1;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No32_最长有效括号 {
    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        System.out.println(solution32.longestValidParentheses("((()))())"));
    }
}

class Solution32 {
    public int longestValidParentheses1(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (judge(s, i, j)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    private boolean judge(String str, int start, int end) {
        int balance = 0;
        while (start <= end) {
            if (str.charAt(start) == '(') {
                balance++;
            }
            else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
            start++;
        }
        return balance == 0;
    }

    public int longestValidParentheses2(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 0;
        if (s.charAt(0) == '(' && s.charAt(1) == ')') {
            dp[1] = 2;
        }
        int max = dp[1];
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i - 1) == '(' && s.charAt(i) == ')') {
                dp[i] = dp[i - 2] + 2;
            }
            else if (s.charAt(i - 1) == ')' && s.charAt(i) == ')') {
                if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(' && dp[i - 1] > 0) {
                    if (i - dp[i - 1] - 2 >= 0 ) {
                        dp[i] = dp[i - dp[i - 1] - 2] + dp[i - 1] + 2;
                    }
                    else {
                        dp[i] = dp[i - 1] + 2;
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int longestValidParentheses(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == '(' && s.charAt(i) == ')') {
                dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
            }
            else if (s.charAt(i - 1) == ')' && s.charAt(i) == ')') {
                if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(' && dp[i - 1] > 0) {
                    dp[i] = (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
