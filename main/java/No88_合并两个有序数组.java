/**
 * @author vneli
 * @since 1.0
 */
public class No88_合并两个有序数组 {
    /**
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     *
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     *
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     * @param args
     */
    public static void main(String[] args) {
        Solution881 solution = new Solution881();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        solution.merge(nums1, 3, nums2, 3);
        System.out.println();
    }
}

class Solution881 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (m >= 0 && n >= 0) {
                if (nums1[m] >= nums2[n])  {
                    nums1[i] = nums1[m];
                    m--;
                }
                else {
                    nums1[i] = nums2[n];
                    n--;
                }
            }
            else if (m >= 0 && n < 0) {
                break;
            }
            else if (m < 0 && n >= 0) {
                nums1[i] = nums2[n];
                n--;
            }
        }
    }
}
