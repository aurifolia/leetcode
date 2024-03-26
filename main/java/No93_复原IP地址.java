import java.util.ArrayList;
import java.util.List;

/**
 * @author vneli
 * @since 1.0
 */
public class No93_复原IP地址 {
    /**
     * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     *
     * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
     * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
     * @param args
     */
    public static void main(String[] args) {
        Solution931 solution = new Solution931();
        System.out.println(solution.restoreIpAddresses("0279245587303"));
        System.out.println(solution.restoreIpAddresses("101023"));
        System.out.println(solution.restoreIpAddresses("0000"));
        System.out.println(solution.restoreIpAddresses("25525511135"));
    }
}

class Solution931 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrace(result, s, 0, 3, "");
        return result;
    }

    public void backtrace(List<String> result, String s, int start, int remind, String current) {
        if (remind == 0) {
            if (start < s.length() && (s.charAt(start) != '0' && (s.length() - start) <= 3 && Integer.parseInt(s.substring(start)) <= 255 || s.charAt(start) == '0' && start == s.length() - 1)) {
                result.add(current + s.substring(start));
            }
            return;
        }
        for (int i = 1; i <= 3 && start + i <= s.length(); i++) {
            String substring = s.substring(start, start + i);
            if (substring.charAt(0) == '0' && substring.length() > 1) {
                break;
            }
            if (substring.length() <= 3 && Integer.parseInt(substring) <= 255) {
                backtrace(result, s, start + i, remind - 1, current + substring + ".");
            }
        }
    }
}
