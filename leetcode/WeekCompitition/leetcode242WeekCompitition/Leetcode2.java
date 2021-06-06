package WeekCompitition.leetcode242WeekCompitition;

import java.text.DecimalFormat;

public class Leetcode2 {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if (hour <= n - 1) {
            return -1;
        }

        int left = 1;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            double time =  count(dist, mid);
            if (time < hour) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (count(dist, left) <= hour) {
            return left;
        } else if (count(dist, left + 1) <= hour) {
            return left + 1;
        } else {
            return -1;
        }
    }

    private double count(int[] dist, int mid) {
        double res = 0.0;
        for (int i = 0; i < dist.length - 1; i++) {
            int temp = (dist[i] - 1) / mid;
            res += temp + 1.0;
        }
        res += (dist[dist.length - 1] / (mid * 1.0));
        return res;
    }


}
