package round1;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No98_验证二叉搜索树 {
}

class Solution98 {
    public boolean isValidBST1(TreeNode root) {
        return inorderTraversal(root, new AtomicReference<>());
    }

    public boolean inorderTraversal(TreeNode root, AtomicReference<Integer> preVal) {
        if (root == null) {
            return true;
        }
        boolean left = inorderTraversal(root.left, preVal);
        if (!left || preVal.get() != null && preVal.get() >= root.val) {
            return false;
        }
        preVal.set(root.val);
        return inorderTraversal(root.right, preVal);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min || max != null && root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
