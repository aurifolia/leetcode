import java.util.Stack;

/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No20_有效的括号 {
    public static void main(String[] args) {
        Solution201 solution = new Solution201();
        System.out.println(solution.isValid("()[]{}"));
    }
}

class Solution201 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop == '(' && c != ')'
                        || pop == '[' && c != ']'
                        || pop == '{' && c != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
