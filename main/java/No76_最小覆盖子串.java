import java.util.HashMap;
import java.util.Map;

/**
 * @author vneli
 * @since 1.0
 */
public class No76_最小覆盖子串 {
    public static void main(String[] args) {
        Solution761 solution = new Solution761();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }
}

class Solution761 {
    public String minWindow(String s, String t) {
        int sn = s.length();
        int tn = t.length();
        Map<Character, Integer> map = new HashMap<>(tn);
        for (int i = 0; i < tn; i++) {
            char key = t.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int counter = tn;
        int left = 0, right = 0, minLeft = 0, minRight = sn;
        while (right < sn) {
            char c = s.charAt(right);
            Integer v = map.get(c);
            if (v != null) {
                if (v > 0) {
                    counter--;
                }
                map.put(c, v - 1);
            }
            right++;
            if (counter == 0) {
                while (left < right) {
                    char key = s.charAt(left);
                    Integer value = map.get(key);
                    if (value == null) {
                        left++;
                    }
                    else if (value < 0) {
                        map.put(key, value + 1);
                        left++;
                    }
                    else {
                        break;
                    }
                }
                if (right - left < minRight - minLeft) {
                    minLeft = left;
                    minRight = right;
                }
            }
        }
        return counter == 0 ? s.substring(minLeft, minRight) : "";
    }
}
