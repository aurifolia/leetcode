import java.util.ArrayList;
import java.util.List;

/**
 * @author vneli
 * @since 1.0
 */
public class No43_字符串相乘 {
    public static void main(String[] args) {
        Solution431 solution = new Solution431();
        System.out.println(solution.multiply("2", "3"));
        System.out.println(solution.multiply("123", "456"));
    }
}

class Solution431 {
    public String multiply(String num1, String num2) {
        List<int[]> list = new ArrayList<>();
        int l1 = num1.length();
        int l2 = num2.length();
        for (int i = l2 - 1, offset = 0; i >= 0; i--, offset++) {
            int[] temp = new int[l1 + offset + 1];
            int signify = 0, offsetBak = offset;
            for (int j = l1 - 1, one = num2.charAt(i) - '0'; j >= 0; j--) {
                int result = one * (num1.charAt(j) - '0') + signify;
                if (result >= 10) {
                    signify = result / 10;
                    result = result % 10;
                }
                else {
                    signify = 0;
                }
                temp[offsetBak++] = result;
            }
            if (signify != 0) {
                temp[offsetBak] = signify;
            }
            list.add(temp);
        }
        while (list.size() > 1) {
            int[] one = list.remove(list.size() - 1);
            int[] another = list.remove(list.size() - 1);
            int[] sum = new int[Math.max(one.length, another.length) + 1];
            int signify = 0, loc = 0;
            for (int i = 0, j = 0; i < one.length || j < another.length; i++, j++) {
                int result = 0;
                if (i < one.length && j < another.length) {
                    result = one[i] + another[j] + signify;
                }
                else if (i < one.length) {
                    result = one[i] + signify;
                }
                else {
                    result = another[j] + signify;
                }
                if (result >= 10) {
                    signify = result / 10;
                    result = result % 10;
                }
                else {
                    signify = 0;
                }
                sum[loc++] = result;
            }
            if (signify != 0) {
                sum[loc] = signify;
            }
            list.add(sum);
        }
        StringBuilder stringBuilder = new StringBuilder();
        int[] remove = list.remove(0);
        int index = remove.length - 1;
        while (index >= 0 && remove[index] == 0) {
            index--;
        }
        while (index >= 0) {
            stringBuilder.append(remove[index--]);
        }
        String string = stringBuilder.toString();
        return string.length() == 0 ? "0" : string;
    }
}
