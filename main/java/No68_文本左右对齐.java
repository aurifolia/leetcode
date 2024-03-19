import java.util.ArrayList;
import java.util.List;

/**
 * @author vneli
 * @since 1.0
 */
public class No68_文本左右对齐 {
    /**
     * 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
     *
     * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
     *
     * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
     *
     * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
     *
     * 注意:
     *
     * 单词是指由非空格字符组成的字符序列。
     * 每个单词的长度大于 0，小于等于 maxWidth。
     * 输入单词数组 words 至少包含一个单词。
     * @param args
     */
    public static void main(String[] args) {
        Solution681 solution = new Solution681();
//        System.out.println(solution.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16));
        System.out.println(solution.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
    }
}

class Solution681 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<List<String>> part = new ArrayList<>();
        List<Integer> counter = new ArrayList<>();
        for (int i = 0, loc = 0; i < n; i++) {
            if (counter.size() == loc) {
                counter.add(0);
                part.add(new ArrayList<>());
            }
            Integer count = counter.get(loc);
            List<String> list = part.get(loc);
            if (count == 0) {
                list.add(words[i]);
                counter.set(loc, words[i].length());
            }
            else if (count + 1 + words[i].length() <= maxWidth) {
                list.addLast(words[i]);
                counter.set(loc, count + 1 + words[i].length());
            }
            else {
                loc++;
                i--;
            }
        }
        List<String> result = new ArrayList<>(part.size());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < counter.size(); i++) {
            stringBuilder.setLength(0);
            List<String> list = part.get(i);
            int wordLength = 0;
            for (String s : list) {
                wordLength += s.length();
            }
            if (list.size() == 1) {
                stringBuilder.append(list.get(0));
                for (int j = maxWidth - wordLength; j > 0; j--) {
                    stringBuilder.append(" ");
                }
            }
            else if (i == counter.size() - 1) {
                for (int j = 0; j < list.size(); j++) {
                    stringBuilder.append(list.get(j)).append(" ");
                }
                stringBuilder.setLength(stringBuilder.length() - 1);
                for (int j = maxWidth - stringBuilder.length(); j > 0; j--) {
                    stringBuilder.append(" ");
                }
            }
            else {
                int whiteWidth = maxWidth - wordLength;
                int[] alloc = new int[list.size() - 1];
                int avg = whiteWidth / alloc.length;
                for (int i1 = 0; i1 < alloc.length; i1++) {
                    alloc[i1] = avg;
                }
                whiteWidth -= (avg * alloc.length);
                int loc = 0;
                while (whiteWidth > 0) {
                    alloc[loc % alloc.length]++;
                    whiteWidth--;
                    loc++;
                }
                for (int j = 0; j < list.size(); j++) {
                    stringBuilder.append(list.get(j));
                    if (j + 1 < list.size()) {
                        for (int k = 0; k < alloc[j]; k++) {
                            stringBuilder.append(" ");
                        }
                    }
                }
            }
            result.add(stringBuilder.toString());
        }
        return result;
    }
}
