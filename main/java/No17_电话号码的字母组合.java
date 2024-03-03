import java.util.*;

/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No17_电话号码的字母组合 {
    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * @param args
     */
    public static void main(String[] args) {
        Solution171 solution = new Solution171();
        System.out.println(solution.letterCombinations("2"));
    }
}

class Solution171 {
    public List<String> letterCombinations(String digits) {
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        return find(digits, 0, map, "");
    }

    public List<String> find(String digit, int loc, Map<String, String> map, String prefix) {
        int length = digit.length();
        if (loc == length) {
            if (prefix == "") {
                return new ArrayList<>();
            }
            return new ArrayList<>(Arrays.asList(prefix));
        }
        List<String> result = new ArrayList<>();
        String str = map.get(digit.substring(loc, loc + 1));
        for (int i = 0; i < str.length(); i++) {
            result.addAll(find(digit, loc + 1, map, prefix + str.substring(i, i + 1)));
        }
        return result;
    }
}
