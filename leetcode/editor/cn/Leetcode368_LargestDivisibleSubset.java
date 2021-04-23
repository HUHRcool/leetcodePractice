package editor.cn;

//给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[
//j]) 都应当满足：
// 
// answer[i] % answer[j] == 0 ，或 
// answer[j] % answer[i] == 0 
// 
//
// 如果存在多个有效解子集，返回其中任何一个均可。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,2]
//解释：[1,3] 也会被视为正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,4,8]
//输出：[1,2,4,8]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 2 * 109 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数学 动态规划 
// 👍 219 👎 0


import sun.awt.image.ImageWatched;

import java.awt.geom.Line2D;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Leetcode368_LargestDivisibleSubset {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 动态规划 利用整除的传递性
     * @param nums
     * @return
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        int index = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = index; i >= 0; i--) {
            if (nums[index] % nums[i] == 0 && dp[i] == max) {
                index = i;
                res.addFirst(nums[i]);
                max--;
            }
        }
        return res;
    }


    public List<Integer> largestDivisibleSubset1(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer>[] dp = new LinkedList[nums.length];
        dp[0] = new LinkedList<>();
        dp[0].add(nums[0]);
        int max = 1;
        List<Integer> res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                if (nums[i] % dp[j].getLast() == 0 && dp[j].size() + 1 > dp[i].size()) {
                    dp[i] = new LinkedList<>(dp[j]);
                    dp[i].add(nums[i]);
                }
            }
            if (dp[i].size() == 0) {
                dp[i].add(nums[i]);
            }
            if (dp[i].size() > max) {
                res = dp[i];
                max = dp[i].size();
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

