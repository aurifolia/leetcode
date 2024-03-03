/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No14_最长公共前缀 {
    public static void main(String[] args) {
        Solution141 solution = new Solution141();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}

/**
 *
 */
class Solution141 {
    public String longestCommonPrefix(String[] strs) {
        int loc = 0;
        StringBuilder builder = new StringBuilder();
        while (true) {
            if (loc >= strs[0].length()) {
                break;
            }
            char c = strs[0].charAt(loc);
            boolean match = true;
            for (int i = 1; i < strs.length; i++) {
                if (loc >= strs[i].length() || strs[i].charAt(loc) != c) {
                    match = false;
                    break;
                }

            }
            if (!match) {
                break;
            }
            builder.append(c);
            loc++;
        }
        return builder.toString();
    }
}
