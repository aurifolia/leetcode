package round1;

/**
 * @author Peng Dan
 * @since 1.0
 */
public class No101_对称二叉树 {
    public static void main(String[] args) {

    }
}

class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricCore(root.left, root.right);
    }

    public boolean isSymmetricCore(TreeNode left, TreeNode right) {
        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        }
        if (left == null) {
            return true;
        }
        return left.val == right.val && isSymmetricCore(left.left, right.right) && isSymmetricCore(left.right, right.left);
    }
}
