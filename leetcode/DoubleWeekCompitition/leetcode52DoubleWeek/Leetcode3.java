package DoubleWeekCompitition.leetcode52DoubleWeek;

import java.util.Arrays;

public class Leetcode3 {
    public int sumOfFlooredPairs(int[] nums) {
        final int mod = (int)1e9 + 7;
        int n = nums.length;
        int res = 0;
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        while (i < n) {
            while (j < n && nums[j] == nums[i]) {
                j++;
            }
            res += (j - i) % mod;
            int high = nums[i] / nums[0];
            int low = 1;
            int temp = i;
            for (int k = low; k <= high; k++) {
                int target = nums[i] / (k + 1);
                int left = 0;
                int right = temp;
                while (left < right) {
                    int mid = (left + right) >>> 1;
                    if (nums[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                if (nums[left] == target) {
                    left++;
                }
                res += k * (i - left);
                temp = left - 1;
            }
            i++;
        }

        return res;
    }




}
