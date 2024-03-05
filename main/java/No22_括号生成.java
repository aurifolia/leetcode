import java.util.*;

/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No22_括号生成 {
    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     *
     * 输入：n = 1
     * 输出：["()"]
     * @param args
     */
    public static void main(String[] args) {
        Solution221 solution = new Solution221();
        System.out.println(solution.generateParenthesis(3));
    }
}

class Solution221 {
    public List<String> generateParenthesis(int n) {
        char[] data = new char[n << 1];
        for (int i = 0; i < n; i++) {
            data[i] = '(';
            data[i + n] = ')';
        }
        boolean[] visited = new boolean[n << 1];
        return find(data, visited, "", 0, new HashSet<>());
    }

    public List<String> find(char[] data, boolean[] visited, String prefix, int chars, Set<String> handled) {
        if (chars == data.length) {
            return judge(prefix) ? Arrays.asList(prefix) : Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;

            String nextPrefix = prefix + data[i];
            int nextChars = chars + 1;
            String key = nextPrefix + nextChars;
            if (!handled.contains(key)) {
                handled.add(key);
                result.addAll(find(data, visited, nextPrefix, nextChars, handled));
            }
            visited[i] = false;
        }
        return new ArrayList<>(result);
    }

    public boolean judge(String str) {
        Stack<Character> stack = new Stack<>();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
