package WeekCompitition.leetcode242WeekCompitition;

import java.util.LinkedList;
import java.util.List;

public class Leetcode3 {

    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == 1) {
            return false;
        }
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int k = 0; k < n; k++) {
            if (dp[k]) {
                for (int l = Math.min(k + maxJump, n - 1) ; l >= k + minJump; l--) {
                    if (s.charAt(l) == '0') {
                        dp[l] = true;
                        if (dp[n - 1]) {
                            return dp[n - 1];
                        }
                    }
                }
            }
        }

        return false;
    }


    
}
