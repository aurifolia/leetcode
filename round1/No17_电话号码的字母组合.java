package round1;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No17_电话号码的字母组合 {
    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        List<String> strings = solution17.letterCombinations("23");
        System.out.println(strings);
    }
}

class Solution17 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        char[][] data = new char[digits.length()][];
        char[] charArray = digits.toCharArray();
        for (int i = 0, length = charArray.length; i < length; i++) {
            data[i] = map.get(charArray[i]);
        }
        backtrace(result, data, new StringBuilder(), 0);
        return result;
    }

    private void backtrace(List<String> result, char[][] data, StringBuilder current, int index) {
        if (index == data.length) {
            result.add(current.toString());
            return;
        }
        for (char c : data[index]) {
            current.append(c);
            backtrace(result, data, current, index + 1);
            current.setLength(current.length() - 1);
        }
    }
}