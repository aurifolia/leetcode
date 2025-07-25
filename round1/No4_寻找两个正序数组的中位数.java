package round1;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No4_寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(solution4.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));
    }
}

class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return ((nums1.length + nums2.length) & 0x1) == 1 ? findTopK(nums1, nums2, (nums1.length + nums2.length) / 2 + 1)
                : (double) (findTopK(nums1, nums2, (nums1.length + nums2.length) / 2) + findTopK(nums1, nums2,(nums1.length + nums2.length) / 2 + 1)) / 2;
    }

    public int findTopK(int[] nums1, int[] nums2, int k) {
        int left1 = 0;
        int left2 = 0;
        while (k > 1 && left1 < nums1.length && left2 < nums2.length) {
            int mid = k / 2;
            int currentLeft1 = Math.min(left1 + mid - 1, nums1.length - 1);
            int currentLeft2 = Math.min(left2 + mid - 1, nums2.length - 1);
            if (nums1[currentLeft1] <= nums2[currentLeft2]) {
                k -= (currentLeft1 - left1 + 1);
                left1 = currentLeft1 + 1;
            }
            else {
                k -= (currentLeft2 - left2 + 1);
                left2 = currentLeft2 + 1;
            }
        }
        if (left1 == nums1.length) {
            return nums2[left2 + k - 1];
        }
        if (left2 == nums2.length) {
            return nums1[left1 + k - 1];
        }
        return Math.min(nums1[left1], nums2[left2]);
    }
}
