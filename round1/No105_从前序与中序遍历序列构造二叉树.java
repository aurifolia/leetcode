package round1;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No105_从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        Solution105 solution105 = new Solution105();
        TreeNode treeNode = solution105.buildTree(new int[]{1, 2}, new int[]{2, 1});
    }
}

class Solution105 {
    private Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>(preorder.length);
        for (int i = inorder.length - 1; i >= 0; i--) {
            map.put(inorder[i], i);
        }
        return buildTreeCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTreeCore(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int val = preorder[preStart];
        TreeNode node = new TreeNode(val);
        int inIndex = map.get(val);
        if (inIndex > inStart) {
            node.left = buildTreeCore(preorder, preStart + 1, preStart + inIndex - inStart, inorder, inStart, inIndex - 1);
        }
        if (inIndex < inEnd) {
            node.right = buildTreeCore(preorder, preEnd - (inEnd - inIndex - 1), preEnd, inorder, inIndex + 1, inEnd);
        }
        return node;
    }
}
