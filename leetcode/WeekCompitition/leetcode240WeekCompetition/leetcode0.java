package WeekCompitition.leetcode240WeekCompetition;

public class leetcode0 {

    class Solution {
        public int maximumPopulation(int[][] logs) {
            int res = 0;
            int max = 0;
            for (int i = 1950; i <= 2050; i++) {
                int tem = 0;
                for (int j = 0; j < logs.length; j++) {
                    if (logs[j][0] <= i && logs[j][1] > i) {
                        tem++;
                    }
                }
                if (tem > max) {
                    max = tem;
                    res = i;
                }
            }
            return res;
        }
    }



}
