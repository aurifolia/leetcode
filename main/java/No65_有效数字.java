/**
 * @author vneli
 * @since 1.0
 */
public class No65_有效数字 {
    /**
     * 有效数字（按顺序）可以分成以下几个部分：
     *
     * 一个 小数 或者 整数
     * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
     * 小数（按顺序）可以分成以下几个部分：
     *
     * （可选）一个符号字符（'+' 或 '-'）
     * 下述格式之一：
     * 至少一位数字，后面跟着一个点 '.'
     * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
     * 一个点 '.' ，后面跟着至少一位数字
     * 整数（按顺序）可以分成以下几个部分：
     *
     * （可选）一个符号字符（'+' 或 '-'）
     * 至少一位数字
     * 部分有效数字列举如下：["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
     *
     * 部分无效数字列举如下：["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
     *
     * 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。
     * @param args
     */
    public static void main(String[] args) {
        Solution651 solution = new Solution651();
        System.out.println(solution.isNumber("005047e+6"));
    }
}

class Solution651 {
    public boolean isNumber(String s) {
        int n = s.length();
        boolean firstSign = true, firstDot = true, firstE = true, needNum = false;
        int mode = -1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c) && c != 'e' && c!= 'E') {
                return false;
            }
            else if (c == 'e' || c == 'E') {
                if (mode == 0 && firstE) {
                    firstE = false;
                }
                else {
                    return false;
                }
                mode = 1;
                firstSign = true;
                needNum = true;
            }
            else if (c == '-' || c == '+') {
                if ((mode == -1 || mode == 1) && firstSign) {
                    firstSign = false;
                }
                else {
                    return false;
                }
            }
            else if (c == '.') {
                if (!needNum && firstDot) {
                    firstDot = false;
                }
                else {
                    return false;
                }
                firstSign = false;
            }
            else {
                mode = 0;
            }
        }
        return mode == 0;
    }
}
