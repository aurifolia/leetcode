/**
 * @author vneli
 * @since 1.0
 */
public class No58_最后一个单词的长度 {
    public static void main(String[] args) {
        Solution581 solution = new Solution581();
        System.out.println(solution.lengthOfLastWord("Hello World"));
    }
}

class Solution581 {
    public int lengthOfLastWord(String s) {
        int latestWordLength = 0;
        int length = s.length() - 1;
        while (length >= 0 && s.charAt(length) == ' ') {
            length--;
        }
        while (length >= 0 && s.charAt(length) != ' ') {
            latestWordLength++;
            length--;
        }
        return latestWordLength;
    }
}
