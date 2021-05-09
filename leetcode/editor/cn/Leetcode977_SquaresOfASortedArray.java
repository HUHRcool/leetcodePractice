package editor.cn;

//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
// Related Topics 数组 双指针 
// 👍 224 👎 0


// 有序数组的平方

public class Leetcode977_SquaresOfASortedArray {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }
        int index = 0;
        int min = nums[index];
        for (int i = 1; i < n; i++) {
            if (nums[i] < min) {
                index = i;
                min = nums[i];
            }
        }
        int[] res = new int[n];
        merge(nums, index, res);
        return res;
    }

    private void merge(int[] nums, int index, int[] res) {
        int i = index;
        int j = index + 1;
        for (int k = 0; k < nums.length; k++) {
            if (i < 0) {
                res[k] = nums[j];
                j++;
            } else if (j >= nums.length) {
                res[k] = nums[i];
                i--;
            } else if (nums[i] < nums[j]) {
                res[k] = nums[i];
                i--;
            } else {
                res[k] = nums[j];
                j++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}

