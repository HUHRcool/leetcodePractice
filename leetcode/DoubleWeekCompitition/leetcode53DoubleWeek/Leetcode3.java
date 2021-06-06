package DoubleWeekCompitition.leetcode53DoubleWeek;

import java.util.*;

public class Leetcode3 {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m < 3 && n < 3) {
            return new int[0];
        }
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int len = 1; len <= Math.min(m, n) - 2; len += 2) {
                    int upx = i - len / 2 - 1, upy = j;
                    int downx = i + len / 2 + 1, dowmy = j;
                    int leftx = i, lefty = j - len / 2 - 1;
                    int rightx = i, righty = j + len / 2 + 1;
                    int sum = 0;
                    if (0 <= upx && downx < m && 0 <= lefty && righty < m ) {
                        for (int k = leftx, l = lefty; k <= downx; k++, l++) {
                            sum += grid[k][l];
                            System.out.println(grid[k][l]);
                        }
                        for (int k = leftx, l = lefty; k >= upx; k--, l++) {
                            sum += grid[k][l];
                            System.out.println(grid[k][l]);
                        }
                        for (int k = rightx, l = righty; k >= upx; k--, l--) {
                            sum += grid[k][l];
                            System.out.println(grid[k][l]);
                        }
                        for (int k = rightx, l = righty; k <= downx; k++, l--) {
                            sum += grid[k][l];
                            System.out.println(grid[k][l]);
                        }
                        res.add(sum);
                        System.out.println();
                        System.out.println();
                    }
                }
            }
        }
        System.out.println(res);
        int[] ans = new int[res.size() + 3];
        int i = 0;
        for (int x : res) {
            ans[i++] = x;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int p = 0; p < m; p++) {
            for (int q = 0; q < n; q++) {
               heap.add(grid[p][q]);
            }
        }
        for (int a = 0; a < 3; a++) {
            ans[i++] = heap.remove();
        }
        Arrays.sort(ans);

        if (ans.length < 3) {
            return ans;
        } else {
            int[] abs = new int[3];
            for (int j = 0; j < 3; j++)
                abs[j++] = ans[j++];
            return abs;
        }
    }


}
