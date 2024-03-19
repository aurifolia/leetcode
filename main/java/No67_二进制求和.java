/**
 * @author vneli
 * @since 1.0
 */
public class No67_二进制求和 {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution671 solution = new Solution671();
        System.out.println(solution.addBinary("1", "111"));
    }
}

class Solution671 {
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int na = a.length() - 1;
        int nb = b.length() - 1;
        int signify = 0, sum;
        while (na >= 0 && nb >= 0) {
            sum = (a.charAt(na) - '0') + (b.charAt(nb) - '0') + signify;
            if (sum > 1) {
                signify = sum / 2;
                sum %= 2;
            }
            else {
                signify = 0;
            }
            stringBuilder.append(sum);
            na--;
            nb--;
        }
        while (na >= 0) {
            sum = (a.charAt(na) - '0') + signify;
            if (sum > 1) {
                signify = sum / 2;
                sum %= 2;
            }
            else {
                signify = 0;
            }
            stringBuilder.append(sum);
            na--;
        }
        while (nb >= 0) {
            sum = (b.charAt(nb) - '0') + signify;
            if (sum > 1) {
                signify = sum / 2;
                sum %= 2;
            }
            else {
                signify = 0;
            }
            stringBuilder.append(sum);
            nb--;
        }
        if (signify != 0) {
            stringBuilder.append(signify);
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}
