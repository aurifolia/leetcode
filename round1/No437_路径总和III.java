package round1;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No437_路径总和III {
    public static void main(String[] args) {
        // [10,5,-3,3,2,null,11,3,-2,null,1]
        Solution437 solution437 = new Solution437();
        System.out.println(solution437.pathSum(new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))), new TreeNode(-3, null, new TreeNode(11))), 8));
    }
}

class Solution437 {
    public int pathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return pathSum(root, targetSum, false);
    }

    public int pathSum(TreeNode root, long targetSum, boolean middle) {
        if (root == null) {
            return 0;
        }
        long nextTargetSum = targetSum - root.val;
        if (middle) {
            return pathSum(root.left, nextTargetSum, middle) + pathSum(root.right, nextTargetSum, middle) + (root.val == targetSum ? 1 : 0);
        }
        else {
            return pathSum(root.left, nextTargetSum, true) + pathSum(root.right, nextTargetSum, true) + (root.val == targetSum ? 1 : 0)
                    + pathSum(root.left, targetSum, false) + pathSum(root.right, targetSum, false);
        }
    }

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        preorderTraversal(root, targetSum, 0, map);
        return paths;
    }

    private int paths;

    private void preorderTraversal(TreeNode root, int targetSum, long length, Map<Long, Integer> map) {
        if (root == null) {
            return;
        }
        long current = length + root.val;
        if (map.containsKey(current - targetSum)) {
            paths += map.getOrDefault(current - targetSum, 0);
        }
        map.put(current, map.getOrDefault(current, 0) + 1);
        preorderTraversal(root.left, targetSum, current, map);
        preorderTraversal(root.right, targetSum, current, map);
        map.put(current, map.getOrDefault(current, 1) - 1);
    }
}
