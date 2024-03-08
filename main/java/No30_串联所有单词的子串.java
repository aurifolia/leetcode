import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 *
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No30_串联所有单词的子串 {
    /**
     * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
     *
     *  s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
     *
     * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
     * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
     * @param args
     */
    public static void main(String[] args) {
        Solution301 solution = new Solution301();
        System.out.println(solution.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }
}

class Solution301 {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>(words.length);
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int gap = words[0].length();
        int top = s.length() - gap * words.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= top; i++) {
            Map<String, Integer> currentMap = new HashMap<>();
            for (int j = 0, loc = i; j < words.length; j++) {
                String key = s.substring(loc, loc + gap);
                currentMap.put(key, currentMap.getOrDefault(key, 0) + 1);
                loc += gap;
            }
            if (currentMap.size() == map.size()) {
                boolean match = true;
                for (Map.Entry<String, Integer> entry : currentMap.entrySet()) {
                    Integer value = map.get(entry.getKey());
                    if (value == null || !value.equals(entry.getValue())) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    result.add(i);
                }
            }
        }
        return result;
    }
}
