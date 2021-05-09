package leetcode240WeekCompetition;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class leetcode5752 {
    class Solution {
        public int maxSumMinProduct(int[] nums) {
            long res = 0;
            long[] dp = new long[nums.length];
            dp[0] = nums[0];
            int[]min = new int[nums.length];
            min[0] = nums[0];
            int[] sum = new int[nums.length];
            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i];
                if (nums[i] >= min[i - 1]) {
                    dp[i] = (long)(sum[i]) * min[i - 1];
                    min[i] = min[i - 1];
                } else {
                    dp[i] = (long)(sum[i]) * nums[i];
                    min[i] = nums[i];
                }
            }
            return (int)(res % (1000000007));
        }
    }


}
