import java.util.ArrayList;
import java.util.List;

/**
 * @author vneli
 * @since 1.0
 */
public class No94_二叉树的中序遍历 {
    public static void main(String[] args) {
        Solution941 solution = new Solution941();
        System.out.println(solution.inorderTraversal(null));
    }
}

class Solution941 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        find(result, root);
        return result;
    }

    public void find(List<Integer> result, TreeNode treeNode) {
        if (treeNode != null) {
            find(result, treeNode.left);
            result.add(treeNode.val);
            find(result, treeNode.right);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}