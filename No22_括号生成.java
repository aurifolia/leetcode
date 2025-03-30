import java.util.*;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No22_括号生成 {
    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        System.out.println(solution22.generateParenthesis(3));
    }
}

class Solution22 {
    public List<String> generateParenthesis1(int n) {
        char[] chars = new char[2 * n];
        for (int i = 0; i < n; i++) {
            chars[i] = '(';
            chars[i + n] = ')';
        }
        List<String> result = new ArrayList<>();
        dfs(chars, new boolean[chars.length], result, new StringBuilder(), new HashSet<>());
        return result;
    }

    private void dfs(char[] chars, boolean[] visited, List<String> result, StringBuilder path, Set<String> visitedPath) {
        if (path.length() == chars.length) {
            String pathStr = path.toString();
            if (judge(pathStr)) {
                result.add(pathStr);
            }
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            }
            path.append(chars[i]);
            visited[i] = true;
            if (visitedPath.add(path.toString())) {
                dfs(chars, visited, result, path, visitedPath);
            }
            visited[i] = false;
            path.setLength(path.length() - 1);
        }
    }

    private boolean judge(String str) {
        char[] chars = str.toCharArray();
        return judge(chars);
    }

    private static boolean judge(char[] chars) {
        Stack<Character> stack = new Stack<>();
        for (Character c : chars) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        dfs1(new char[2 * n], 0, result);
        return result;
    }

    private void dfs1(char[] data, int index, List<String> result) {
        if (index == data.length) {
            if (judge(data)) {
                result.add(new String(data));
            }
            return;
        }
        data[index] = '(';
        dfs1(data, index + 1, result);
        data[index] = ')';
        dfs1(data, index + 1, result);
    }

    public List<String> generateParenthesis3(int n) {
        List<String> result = new ArrayList<>();
        dfs2(new char[2 * n], 0, n, n, result);
        return result;
    }

    private void dfs2(char[] data, int index, int leftCount, int rightCount, List<String> result) {
        if (index == data.length) {
            if (judge(data)) {
                result.add(new String(data));
            }
            return;
        }
        if (leftCount > 0) {
            data[index] = '(';
            dfs2(data, index + 1, leftCount - 1, rightCount, result);
        }
        if (rightCount > 0) {
            data[index] = ')';
            dfs2(data, index + 1, leftCount, rightCount - 1, result);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs3(new char[2 * n], 0, n, n, result, new HashSet<>());
        return result;
    }

    private void dfs3(char[] data, int index, int leftCount, int rightCount, List<String> result, Set<String> visitedPath) {
        if (index == data.length) {
            if (judge(data)) {
                result.add(new String(data));
            }
            return;
        }
        if (leftCount > 0) {
            data[index] = '(';
            if (visitedPath.add(new String(data, 0, index + 1))) {
                dfs3(data, index + 1, leftCount - 1, rightCount, result, visitedPath);
            }
        }
        if (rightCount > 0) {
            data[index] = ')';
            if (visitedPath.add(new String(data, 0, index + 1))) {
                dfs3(data, index + 1, leftCount, rightCount - 1, result, visitedPath);
            }
        }
    }
}
