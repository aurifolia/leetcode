import java.util.Stack;

/**
 * @author vneli
 * @since 1.0
 */
public class No71_简化路径 {
    public static void main(String[] args) {
        Solution711 solution = new Solution711();
        System.out.println(solution.simplifyPath("/a//b////c/d//././/.."));
        System.out.println(solution.simplifyPath("/home/"));
        System.out.println(solution.simplifyPath("/../"));
        System.out.println(solution.simplifyPath("/home//foo/"));
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));
    }
}

class Solution711 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        if (path.charAt(path.length() - 1) != '/') {
            path = path + "/";
        }
        int n = path.length();
        for (int i = 0, start = 0; i < n; i++) {
            if (path.charAt(i) == '/') {
                if (path.charAt(start) != '/') {
                    String subPath = path.substring(start, i);
                    start = i;
                    if (subPath.equals(".")) {
                        continue;
                    }
                    else if (subPath.equals("..")) {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                    }
                    else {
                        stack.push(subPath);
                    }
                }
            }
            else if (path.charAt(start) == '/') {
                start = i;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            stringBuilder.append("/").append(stack.get(i));
        }
        return stringBuilder.isEmpty() ? "/" : stringBuilder.toString();
    }
}
