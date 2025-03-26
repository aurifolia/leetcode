import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Peng Dan
 * @since 1.0
 */
public class No108_将有序数组转换为二叉搜索树 {
    public static void main(String[] args) throws IOException {
        AvlTree avlTree = new AvlTree();
        int times = 20000;
        int[] data = new int[times];
        for (int i = 0; i < times; i++) {
            int val = ThreadLocalRandom.current().nextInt(10000);
            data[i] = val;
        }
        data = new int[]{83, 56, 47, 63, 79, 28, 46, 57, 32, 48, 46, 46, 46};
        data = Arrays.stream(Files.readString(Paths.get("C:\\Users\\Aurifolia\\Desktop\\a.txt")).split(",")).map(String::trim).map(Integer::parseInt).mapToInt(Integer::valueOf).toArray();
        for (int val : data) {
            avlTree.insert(val);
        }

        System.out.println();
        for (int i = data.length - 1; i >= 0; i--) {
            avlTree.delete(data[i]);
            if (!avlTree.isBalanced()) {
                System.out.println("not");
                break;
            }
            List<Integer> integers = avlTree.preorderTraversal();
            Set<Integer> source = new HashSet<>(i + 1);
            for (int j = 0; j < i; j++) {
                source.add(data[j]);
            }
            Set<Integer> target = new HashSet<>(integers);
            if (source.size() != target.size() || !source.containsAll(target)) {
                System.out.println("element not");
                break;
            }
        }
        System.out.println("finish");
    }
}

class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }
}

class AvlTreeNode {
    public int val;
    public AvlTreeNode left;
    public AvlTreeNode right;
    public int height;
    public int count;

    public AvlTreeNode(int val) {
        this.val = val;
        this.height = 1;
        this.count = 1;
    }
}

class AvlTree {
    public AvlTreeNode root;

    public AvlTree() {
        this.root = null;
    }

    /**
     * 右旋
     *
     * @param root 根节点
     * @return 旋转后的根节点
     */
    public AvlTreeNode spinRight(AvlTreeNode root) {
        AvlTreeNode left = root.left;
        root.left = left.right;
        left.right = root;

        calcNodeHeight(root);
        calcNodeHeight(left);
        return left;
    }

    /**
     * 左旋
     *
     * @param root 根节点
     * @return 旋转后的根节点
     */
    public AvlTreeNode spinLeft(AvlTreeNode root) {
        AvlTreeNode right = root.right;
        root.right = right.left;
        right.left = root;

        calcNodeHeight(root);
        calcNodeHeight(right);
        return right;
    }

    public void insert(int val) {
        this.root = insert(this.root, val);
    }

    private AvlTreeNode insert(AvlTreeNode root, int val) {
        if (root == null) {
            return new AvlTreeNode(val);
        }
        if (val == root.val) {
            root.count++;
            return root;
        }
        else if (val < root.val) {
            // 插入到左子树
            root.left = insert(root.left, val);
        }
        else {
            // 插入到右子树
            root.right = insert(root.right, val);
        }
        // 调整当前节点高度
        calcNodeHeight(root);
        // 判断是否平衡
        int nodeBalanceFactor = getBalanceFactor(root);
        int leftNodeBalanceFactor = getBalanceFactor(root.left);
        int rightNodeBalanceFactor = getBalanceFactor(root.right);
        // LL型, 右旋
        if (nodeBalanceFactor > 1 && leftNodeBalanceFactor >= 0) {
            root = spinRight(root);
        }
        // LR型，左右旋
        else if (nodeBalanceFactor > 1 && leftNodeBalanceFactor < 0) {
            root.left = spinLeft(root.left);
            root = spinRight(root);
        }
        // RR型，左旋
        else if (nodeBalanceFactor < -1 && rightNodeBalanceFactor <= 0) {
            root = spinLeft(root);
        }
        // RL型，右左旋
        else if (nodeBalanceFactor < -1 && rightNodeBalanceFactor > 0) {
            root.right = spinRight(root.right);
            root = spinLeft(root);
        }
        return root;
    }

    public void delete(int val) {
        if (!contain(val)) {
            return;
        }
        this.root = delete(this.root, val);
    }

    public int getCount(int val) {
        return getCount(this.root, val);
    }

    private int getCount(AvlTreeNode node, int val) {
        if (node == null) {
            return 0;
        }
        if (val == node.val) {
            return node.count;
        }
        if (val < node.val) {
            return getCount(node.left, val);
        }
        else {
            return getCount(node.right, val);
        }
    }

    public boolean contain(int val) {
        return contain(this.root, val);
    }

    private AvlTreeNode delete(AvlTreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val < root.val) {
            root.left = delete(root.left, val);
        }
        else if (val > root.val) {
            root.right = delete(root.right, val);
        }
        else {
            if (root.count > 1) {
                root.count--;
                return root;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 选择右子树的最小节点maxLeftNode, 这个节点要作为当前方法最终节点返回
            AvlTreeNode maxLeftNode = getMaxLeftNode(root.right);
            // 删除maxLeftNode
            int maxLeftNodeCount = maxLeftNode.count;
            maxLeftNode.count = 1;
            root.right = delete(root.right, maxLeftNode.val);
            // 用maxLeftNode替换root
            maxLeftNode.count = maxLeftNodeCount;
            maxLeftNode.left = root.left;
            maxLeftNode.right = root.right;
            root = maxLeftNode;
        }
        calcNodeHeight(root);
        // 重新平衡
        int nodeBalanceFactor = getBalanceFactor(root);
        int leftNodeBalanceFactor = getBalanceFactor(root.left);
        int rightNodeBalanceFactor = getBalanceFactor(root.right);
        // LL型，右旋
        if (nodeBalanceFactor > 1 && leftNodeBalanceFactor >= 0) {
            root = spinRight(root);
        }
        // LR型, 左右旋
        else if (nodeBalanceFactor > 1 && leftNodeBalanceFactor < 0) {
            root.left = spinLeft(root.left);
            root =  spinRight(root);
        }
        // RR型，左旋
        else if (nodeBalanceFactor < -1 && rightNodeBalanceFactor <= 0) {
            root = spinLeft(root);
        }
        // RL型, 右左旋
        else if (nodeBalanceFactor < -1 && rightNodeBalanceFactor > 0) {
            root.right = spinRight(root.right);
            root = spinLeft(root);
        }
        return root;
    }

    private AvlTreeNode getMaxLeftNode(AvlTreeNode root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private boolean contain(AvlTreeNode root, int val) {
        if (root == null) {
            return false;
        }
        if (val == root.val) {
            return true;
        }
        else if (val < root.val) {
            return contain(root.left, val);
        }
        else {
            return contain(root.right, val);
        }
    }

    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorderTraversalCore(this.root, result);
        return result;
    }

    public List<Integer> preorderTraversal() {
        List<Integer> result = new ArrayList<>();
        preorderTraversalCore(this.root, result);
        return result;
    }

    private void preorderTraversalCore(AvlTreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderTraversalCore(root.left, result);
        preorderTraversalCore(root.right, result);
    }

    private void inorderTraversalCore(AvlTreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTraversalCore(root.left, result);
        result.add(root.val);
        inorderTraversalCore(root.right, result);
    }

    private void calcNodeHeight(AvlTreeNode node) {
        if (node == null) {
            return;
        }
        node.height = Math.max(getNodeHeight(node.left), getNodeHeight(node.right)) + 1;
    }

    private int getNodeHeight(AvlTreeNode node) {
        return node == null ? 0 : node.height;
    }

    private int getBalanceFactor(AvlTreeNode node) {
        return node == null ? 0 : getNodeHeight(node.left) - getNodeHeight(node.right);
    }

    public boolean isBalanced() {
        return isBalanced(this.root);
    }

    private boolean isBalanced(AvlTreeNode node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }
}