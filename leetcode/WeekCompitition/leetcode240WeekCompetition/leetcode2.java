package WeekCompitition.leetcode240WeekCompetition;

import java.util.LinkedList;

public class leetcode2 {
    class Solution {

        final int mod = (int)1e9 + 7;

        // 单调栈 + 前缀和 + 哨兵
        public int maxSumMinProduct(int[] nums) {
            int n = nums.length + 2;
            int[] newnums = new int[n];
            newnums[0] = 0;
            System.arraycopy(nums, 0, newnums, 1, n - 2);
            newnums[n - 1] = 0;
            nums = newnums;

            long[] sum = new long[n];
            sum[0] = nums[0];
            for (int i = 1;i < n; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }

            long res = 0;
            LinkedList<Integer> stack = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && nums[stack.getLast()] >= nums[i]) {
                    int top = stack.removeLast();
                    if (!stack.isEmpty()) {
                        res = Math.max(res, nums[top] * (sum[i - 1] - sum[stack.getLast()]));
                    }
                }
                stack.add(i);
            }

            return (int)(res % mod);
        }
    }


}
