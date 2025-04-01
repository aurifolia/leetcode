import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No394_字符串解码 {
    public static void main(String[] args) {
        Solution394 solution394 = new Solution394();
        System.out.println(solution394.decodeString("3[a2[c]]"));
    }
}

class Solution394 {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int length = s.length();
        int loc = 0;
        StringBuilder builder = new StringBuilder();
        while (loc < length) {
            char ch = s.charAt(loc);
            if (ch == '[') {
                if (!builder.isEmpty()) {
                    stack.push(builder.toString());
                }
                builder.setLength(0);
                loc++;
            } else if (Character.isDigit(ch)) {
                if (!builder.isEmpty()) {
                    stack.push(builder.toString());
                    builder.setLength(0);
                }
                while (Character.isDigit(s.charAt(loc))) {
                    builder.append(s.charAt(loc));
                    loc++;
                }
                stack.push(builder.toString());
                builder.setLength(0);
            } else if (ch == ']') {
                if (!builder.isEmpty()) {
                    stack.push(builder.toString());
                }
                builder.setLength(0);
                List<String> list = new ArrayList<>();
                while (true) {
                    String pop = stack.pop();
                    if (Character.isDigit(pop.charAt(0))) {
                        stack.push(pop);
                        break;
                    }
                    list.add(pop);
                }
                builder.append(String.join("", list.reversed()).repeat(Integer.parseInt(stack.pop())));
                stack.push(builder.toString());
                builder.setLength(0);
                loc++;
            }
            else {
                builder.append(ch);
                loc++;
            }
        }
        if (!builder.isEmpty()) {
            stack.push(builder.toString());
        }
        while (stack.size() > 1) {
            String second = stack.pop();
            String first = stack.pop();
            stack.push(first + second);
        }
        return stack.isEmpty() ? null : stack.pop();
    }
}
