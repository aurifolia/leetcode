import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No236_二叉树的最近公共祖先 {
    public static void main(String[] args) {
        Solution236 solution236 = new Solution236();
//        solution236.lowestCommonAncestor();
    }
}

class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();
        lowestCommonAncestor(root, p, pathP);
        lowestCommonAncestor(root, q, pathQ);
        TreeNode result = null;
        int size = Math.min(pathP.size(), pathQ.size());
        for (int i = 0; i < size; i++) {
            if (pathP.get(i) == pathQ.get(i)) {
                result = pathP.get(i);
                continue;
            }
            break;
        }
        return result;
    }

    public boolean lowestCommonAncestor(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root == target) {
            return true;
        }
        if (lowestCommonAncestor(root.left, target, path) || lowestCommonAncestor(root.right, target, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
}
