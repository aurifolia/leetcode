package round1;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些 子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No131_分割回文串 {
    public static void main(String[] args) {
        Solution131 solution131 = new Solution131();
        System.out.println(solution131.partition("efe"));
    }
}

class Solution131 {
    public List<List<String>> partition(String s) {
        ArrayList<List<String>> result = new ArrayList<>();
        dfs(s, 0, result, new ArrayList<>());
        return result;
    }

    public void dfs(String data, int index, List<List<String>> result, List<String> path) {
        if (index == data.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        String current = "";
        for (int i = index, length = data.length(); i < length; i++) {
            current += data.charAt(i);
            if (!judge(current)) {
                continue;
            }
            path.add(current);
            dfs(data, i + 1, result, path);
            path.remove(path.size() - 1);
        }
    }

    private boolean judge(String str) {
        for (int i = 0, j = str.length() - 1; i < j ; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
