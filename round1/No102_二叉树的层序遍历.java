package round1;

import java.util.*;

/**
 * @author Peng Dan
 * @since 1.0
 */
public class No102_二叉树的层序遍历 {
    public static void main(String[] args) {

    }
}

class Solution102 {
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> newQueue = new ArrayDeque<>();
            List<Integer> curLevel = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                curLevel.add(node.val);
                if (node.left != null) {
                    newQueue.offer(node.left);
                }
                if (node.right != null) {
                    newQueue.offer(node.right);
                }
            }
            result.add(curLevel);
            queue = newQueue;
        }
        return result;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0, length = queue.size(); i < length; i++) {
                TreeNode node = queue.poll();
                curLevel.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(curLevel);
        }
        return result;
    }
}
