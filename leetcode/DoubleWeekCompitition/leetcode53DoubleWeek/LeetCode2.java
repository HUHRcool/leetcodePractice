package DoubleWeekCompitition.leetcode53DoubleWeek;

import javafx.scene.layout.Priority;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetCode2 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b - a);
        while (i < j) {
            heap.add(nums[i] + nums[j]);
            i++;
            j--;
        }
        return heap.remove();
    }


}
