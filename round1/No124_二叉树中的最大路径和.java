package round1;

/**
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No124_二叉树中的最大路径和 {
    public static void main(String[] args) {
        Solution124 solution124 = new Solution124();
        int i = solution124.maxPathSum(new TreeNode(-3));
        System.out.println(i);
    }
}

class Solution124 {
    private int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumCore(root);
        return maxPath;
    }

    public Info maxPathSumCore1(TreeNode root) {
        Info info = new Info();
        if (root != null) {
            Info leftInfo = maxPathSumCore1(root.left);
            Info rightInfo = maxPathSumCore1(root.right);
            int maxChildrenPath = Math.max(leftInfo.notCrossMax, rightInfo.notCrossMax);
            info.notCrossMax = Math.max(maxChildrenPath + root.val, root.val);
            info.crossMax = leftInfo.notCrossMax + root.val + rightInfo.notCrossMax;
            maxPath = Math.max(maxPath, Math.max(info.crossMax, info.notCrossMax));
        }
        return info;
    }

    public int maxPathSumCore(TreeNode root) {
        int currentMax = 0;
        if (root != null) {
            int leftInfo = maxPathSumCore(root.left);
            int rightInfo = maxPathSumCore(root.right);
            int maxChildrenPath = Math.max(leftInfo, rightInfo);
            currentMax = Math.max(maxChildrenPath + root.val, root.val);
            int crossMax = leftInfo + root.val + rightInfo;
            maxPath = Math.max(maxPath, Math.max(crossMax, currentMax));
        }
        return currentMax;
    }

    class Info {
        public int crossMax;
        public int notCrossMax;
    }
}
