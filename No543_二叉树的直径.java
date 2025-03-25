/**
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 *
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 *
 * 两节点之间路径的 长度 由它们之间边数表示。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No543_二叉树的直径 {
    public static void main(String[] args) {

    }
}

class Solution543 {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Info info = diameterOfBinaryTreeCore(root);
        return Math.max(info.circleMax, info.lineMax) - 1;
    }

    public Info diameterOfBinaryTreeCore(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = diameterOfBinaryTreeCore(root.left);
        Info rightInfo = diameterOfBinaryTreeCore(root.right);
        int circleMax = leftInfo.lineMax + rightInfo.lineMax + 1;
        return new Info(Math.max(leftInfo.circleMax, Math.max(rightInfo.circleMax, circleMax)), Math.max(leftInfo.lineMax, rightInfo.lineMax) + 1);
    }

    class Info {
        private int circleMax;
        private int lineMax;

        public Info(int circleMax, int lineMax) {
            this.circleMax = circleMax;
            this.lineMax = lineMax;
        }
    }
}
