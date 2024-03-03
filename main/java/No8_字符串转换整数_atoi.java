/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No8_字符串转换整数_atoi {
    /**
     * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
     * <p>
     * 函数 myAtoi(string s) 的算法如下：
     * <p>
     * 读入字符串并丢弃无用的前导空格
     * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
     * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
     * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
     * 如果整数数超过 32 位有符号整数范围 [−2^31,  2^31 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
     * 返回整数作为最终结果。
     * 注意：
     * <p>
     * 本题中的空白字符只包括空格字符 ' ' 。
     * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution81 solution = new Solution81();
        System.out.println(solution.myAtoi("2147483648"));
    }
}

/**
 * 直接法
 */
class Solution81 {
    public int myAtoi(String s) {
        int length = s.length();
        int result = 0, prior = 0;
        boolean negative = false;
        boolean needNum = false;
        boolean number = false;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (number || needNum) {
                    break;
                }
                continue;
            } else if (c == '-') {
                if (number || needNum) {
                    break;
                }
                needNum = true;
                negative = true;
            } else if (c == '+') {
                if (number || needNum) {
                    break;
                }
                needNum = true;
            } else if (c >= '0' && c <= '9') {
                number = true;
                prior = result;
                int num = c - '0';
                result = result * 10 + num;
                // 溢出
                if (prior > result || (result - num) / 10 != prior) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            } else {
                break;
            }
        }
        return negative ? -result : result;
    }
}
