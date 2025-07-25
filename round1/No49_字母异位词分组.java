package round1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Peng Dan
 * @since 1.0
 */
public class No49_字母异位词分组 {
    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        List<List<String>> lists = solution49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }
}

class Solution49 {
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Map<Character, Integer> charMap = new TreeMap<>();
            for (char c : str.toCharArray()) {
                charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            }
            StringBuilder stringBuilder = new StringBuilder();
            charMap.forEach((k, v) -> stringBuilder.append(k).append(v));
            map.computeIfAbsent(stringBuilder.toString(), key -> new LinkedList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] data = new int[26];
            for (char c : str.toCharArray()) {
                data[c - 'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                if (data[i] != 0) {
                    stringBuilder.append((char)('a' + data[i])).append(i);
                }
            }
            map.computeIfAbsent(stringBuilder.toString(), key -> new LinkedList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
                map.put(key, list);
            }
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams4(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            map.computeIfAbsent(new String(chars), key -> new ArrayList<>()).add(str);
        }
        return new ArrayList(map.values());
    }
}
