import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author vneli
 * @since 1.0
 */
public class No49_字母异位词分组 {
    public static void main(String[] args) {
        Solution491 solution = new Solution491();
        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}

class Solution491 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            map.computeIfAbsent(new String(charArray), key -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
