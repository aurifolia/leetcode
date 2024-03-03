/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No4_寻找两个正序数组的中位数 {
    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     *
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * 示例 2：
     *
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * @param args
     */
    public static void main(String[] args) {
        Solution42 solution = new Solution42();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{-1, 3}));
    }
}

/**
 * 先计算中位数的位置，然后直接查找
 */
class Solution41 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int index = length >> 1;
        int left1 = 0, left2 = 0;
        int prior = 0, current = 0;
        while ((left1 < nums1.length || left2 < nums2.length) && left1 + left2 <= index) {
            if (left1 >= nums1.length) {
                prior = current;
                current = nums2[left2];
                left2++;
                continue;
            }
            if (left2 >= nums2.length) {
                prior = current;
                current = nums1[left1];
                left1++;
                continue;
            }
            if (nums1[left1] <= nums2[left2]) {
                prior = current;
                current = nums1[left1];
                left1++;
            }
            else {
                prior = current;
                current = nums2[left2];
                left2++;
            }
        }
        return (length & 1) == 1 ? current : ((double) prior + current) / 2;
    }
}

/**
 * 二分法，每次排除k/2个元素
 */
class Solution42 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if ((length & 1) == 1) {
            return findTopK(nums1, nums2, length / 2 + 1);
        }
        else {
            return ((double) findTopK(nums1, nums2, length / 2) + findTopK(nums1, nums2, length / 2 + 1)) / 2;
        }
    }

    public int findTopK(int[] nums1, int[] nums2, int k) {
        int l1 = 0, l2 = 0;
        while (true) {
            if (l1 >= nums1.length) {
                return nums2[l2 + k - 1];
            }
            if (l2 >= nums2.length) {
                return nums1[l1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[l1], nums2[l2]);
            }

            int loc = k >> 1;
            int t1 = Math.min(l1 + loc, nums1.length) - 1;
            int t2 = Math.min(l2 + loc, nums2.length) - 1;
            if (nums1[t1] <= nums2[t2]) {
                k -= t1 - l1 + 1;
                l1 = t1 + 1;
            }
            else {
                k -= t2 - l2 + 1;
                l2 = t2 + 1;
            }
        }
    }
}
