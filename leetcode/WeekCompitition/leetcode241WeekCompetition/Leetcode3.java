package WeekCompitition.leetcode241WeekCompetition;

import java.util.Arrays;

public class Leetcode3 {

    class FindSumPairs {
        int[] nums1;
        int[] nums2;
        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
        }

        public void add(int index, int val) {
            nums2[index] += val;
        }

        public int count(int tot) {
            int[] n1 = new int[nums1.length];
            int[] n2 = new int[nums2.length];
            System.arraycopy(nums1, 0, n1, 0, n1.length);
            System.arraycopy(nums2, 0, n2, 0, n2.length);
            Arrays.sort(n1);
            Arrays.sort(n2);
            int res = 0;
            for (int i = 0; i < n1.length; i++) {
                for (int j = n2.length - 1; j >= 0; j--) {
                    int temp = n1[i] + n2[j];
                    if (temp == tot) {
                        res++;
                    } else if (temp < tot){
                        break;
                    }
                }
            }
            return res;
        }



    }
}
