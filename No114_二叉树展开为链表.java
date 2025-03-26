/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No114_二叉树展开为链表 {

}

class Solution114 {
    private TreeNode head;
    private TreeNode tail;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        head = new TreeNode(-1);
        tail = head;
        flattenCore(root);
        root.left = null;
        root.right = head.right.right;
    }

    public void flattenCore(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        tail.right = root;
        tail = root;
        flattenCore(left);
        flattenCore(right);
    }
}
