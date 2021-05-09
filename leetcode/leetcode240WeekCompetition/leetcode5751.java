package leetcode240WeekCompetition;

public class leetcode5751 {

    class Solution {
        public int maxDistance(int[] nums1, int[] nums2) {
            int res = 0;
            for (int i = 0; i < Math.min(nums2.length,nums1.length); i++) {
                int left = i;
                int right = nums2.length - 1;
                while (left < right) {
                    int mid = (left + right + 1) >>> 1;
                    if (nums2[mid] < nums1[i]) {
                        right = mid - 1;
                    } else {
                        left = mid;
                    }
                }
                if (nums2[left] >= nums1[i]) {
                    res = Math.max(res, left - i);
                }
            }

            return res;
        }
    }


}
