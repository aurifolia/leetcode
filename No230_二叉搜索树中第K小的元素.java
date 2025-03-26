/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No230_二叉搜索树中第K小的元素 {
}

class Solution230 {
    private int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return kthSmallestCore(root);
    }

    private int kthSmallestCore(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftVal = kthSmallestCore(root.left);
        if (leftVal != -1) {
            return leftVal;
        }
        k--;
        if (k == 0) {
            return root.val;
        }
        return kthSmallestCore(root.right);
    }
}
