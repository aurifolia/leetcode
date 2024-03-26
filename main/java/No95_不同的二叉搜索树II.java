import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author vneli
 * @since 1.0
 */
public class No95_不同的二叉搜索树II {
    public static void main(String[] args) {
        Solution951 solution = new Solution951();
        List<TreeNode> treeNodes = solution.generateTrees(3);
    }
}

class Solution951 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        return generate(1, n);
    }

    public List<TreeNode> generate(int start, int end) {
        if (start > end) {
            List<TreeNode> list = new ArrayList<>();
            list.add(null);
            return list;
        }
        List<TreeNode> treeNodes = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generate(start, i - 1);
            List<TreeNode> right = generate(i + 1, end);
            for (TreeNode treeNode : left) {
                for (TreeNode node : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = treeNode;
                    root.right = node;
                    treeNodes.add(root);
                }
            }
        }
        return treeNodes;
    }
}
