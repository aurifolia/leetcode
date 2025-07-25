package round1;

import java.util.*;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No94_二叉树的中序遍历 {
    public static void main(String[] args) {

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

class Solution94 {
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalCore(root, result);
        return result;
    }

    public void inorderTraversalCore(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTraversalCore(root.left, result);
        result.add(root.val);
        inorderTraversalCore(root.right, result);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque deque = new ArrayDeque();
        deque.add(root);
        List<Integer> result = new ArrayList<>();
        while (!deque.isEmpty()) {
            Object obj = deque.pollFirst();
            if (obj instanceof Integer) {
                result.add((Integer) obj);
            }
            else {
                TreeNode node = (TreeNode) obj;
                if (node.right != null) {
                    deque.offerFirst(node.right);
                }
                deque.offerFirst(node.val);
                if (node.left != null) {
                    deque.offerFirst(node.left);
                }
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}