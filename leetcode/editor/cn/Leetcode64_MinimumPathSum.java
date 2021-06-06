package editor.cn;

//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 874 👎 0


// 最小路径和

public class Leetcode64_MinimumPathSum {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int m, n;
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                } else {
                    int up = i > 0 ? dp[i - 1][j] + grid[i][j] : Integer.MAX_VALUE;
                    int left = j > 0 ? dp[i][j - 1] + grid[i][j] : Integer.MAX_VALUE;
                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * 如果要输出总和最低的路径呢？（如果有多个答案，返回其中之一即可）
     */
    public int minPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][] dp = new int[m][n];
        int[] g = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                } else {
                    int up = i > 0 ? dp[i - 1][j] + grid[i][j] : Integer.MAX_VALUE;
                    int left = j > 0 ? dp[i][j - 1] + grid[i][j] : Integer.MAX_VALUE;
                    dp[i][j] = Math.min(up, left);
                    g[getIdx(i, j)] = up < left ? getIdx(i - 1, j) : getIdx(i, j - 1);
                }
            }
        }


        return 0;
    }

    private int getIdx(int i, int j) {
        return i * m + j;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


}

