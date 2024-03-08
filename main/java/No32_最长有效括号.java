import java.util.Stack;

/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No32_最长有效括号 {
    /**
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号
     * 子串
     * 的长度。
     * @param args
     */
    public static void main(String[] args) {
        Solution321 solution = new Solution321();
        System.out.println(solution.longestValidParentheses("()"));
        System.out.println(solution.longestValidParentheses(")()())"));
    }
}

class Solution321 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int length = s.length();
        int maxSize = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            }
            else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                else {
                    maxSize = Math.max(maxSize, i - stack.peek());
                }
            }
        }
        return maxSize;
    }
}
