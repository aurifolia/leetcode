import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author vneli
 * @since 1.0
 */
public class No87_扰乱字符串 {
    /**
     * 使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
     * 如果字符串的长度为 1 ，算法停止
     * 如果字符串的长度 > 1 ，执行下述步骤：
     * 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
     * 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
     * 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
     * 给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。
     * @param args
     */
    public static void main(String[] args) {
        Solution871 solution = new Solution871();
        System.out.println(solution.isScramble("great", "rgeat"));
    }
}

class Solution871 {
    public boolean isScramble(String s1, String s2) {
        int length = s1.length();
        int[][][] mem = new int[length][length][length + 1];
        return dfs(mem, s1, s2, 0, 0, length);
    }

    public boolean dfs(int[][][] mem, String s1, String s2, int l1, int l2, int length) {
        if (mem[l1][l2][length] != 0) {
            return mem[l1][l2][length] == 1;
        }
        String sub1 = s1.substring(l1, l1 + length);
        String sub2 = s2.substring(l2, l2 + length);
        if (sub1.equals(sub2)) {
            mem[l1][l2][length] = 1;
            return true;
        }
        if (!checkChar(sub1, sub2)) {
            mem[l1][l2][length] = -1;
            return false;
        }
        for (int i = 1; i < length; i++) {
            if (dfs(mem, s1, s2, l1, l2, i) && dfs(mem, s1, s2, l1 + i, l2 + i, length - i)) {
                mem[l1][l2][length] = 1;
                return true;
            }
            if (dfs(mem, s1, s2, l1, l2 + length - i, i) && dfs(mem, s1, s2, i + l1, l2, length - i)) {
                mem[l1][l2][length] = 1;
                return true;
            }
        }
        mem[l1][l2][length] = -1;
        return false;
    }

    public boolean checkChar(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        int length = s1.length();
        for (int i = 0; i < length; i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < length; i++) {
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) - 1);
        }
        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
