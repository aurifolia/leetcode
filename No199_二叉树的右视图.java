import java.util.*;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No199_二叉树的右视图 {

}

class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        // 层次遍历的最后一个节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<TreeNode> nodes = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                nodes.add(queue.poll());
            }
            result.add(nodes.get(nodes.size() - 1).val);
            for (TreeNode node : nodes) {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }
}
