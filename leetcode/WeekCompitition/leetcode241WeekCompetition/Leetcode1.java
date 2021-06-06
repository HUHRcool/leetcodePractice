package WeekCompitition.leetcode241WeekCompetition;

import java.util.LinkedList;
import java.util.List;

public class Leetcode1 {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        subset(nums, 0, new LinkedList<>(), res);
        int ans = 0;

        for (List<Integer> l : res) {
            ans += xor(l);
        }
        return ans;
    }

    private int xor(List<Integer> num) {
        int res = 0;
        for (int n : num) {
            res ^= n;
        }
        return res;
    }

    private void subset(int[] nums, int i, List<Integer> temp, List<List<Integer>> res) {
        res.add(new LinkedList<>(temp));
        for (int j = i; j < nums.length; j++) {
            temp.add(nums[j]);
            subset(nums, j + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }


}
