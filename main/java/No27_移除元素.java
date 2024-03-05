/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No27_移除元素 {
    public static void main(String[] args) {
        Solution271 solution = new Solution271();
        System.out.println(solution.removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(solution.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
}

class Solution271 {
    public int removeElement(int[] nums, int val) {
        int loc = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[loc++] = nums[i];
        }
        return loc;
    }
}
