package WeekCompitition.leetcode241WeekCompetition;

public class Leetcode2 {

    public int minSwaps(String s) {
        int n = s.length();
        if (n == 1) {
            return 0;
        }
        int cnt1 = 0;
        int cnt0 = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                cnt0++;
            } else {
                cnt1++;
            }
        }
        if (n % 2 == 1) {
            if (Math.abs(cnt1 - cnt0) != 1) {
                return -1;
            }
        } else {
            if (cnt1 != cnt0) {
                return -1;
            }
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder SB2 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sb1.append(0);
                SB2.append(1);
            } else {
                sb1.append(1);
                SB2.append(0);
            }
        }
        int cn1 = 0;
        int cn2 = 0;
        for (int i = 0; i < n; i++) {
            if (sb1.toString().charAt(i) != s.charAt(i)) {
                cn1++;
            }
            if (SB2.toString().charAt(i) != s.charAt(i)) {
                cn2++;
            }
        }
        if (cn1 % 2 == 0) {
            cn1 = cn1 / 2;
        }
        if (cn2 % 2 == 0) {
            cn2 = cn2 / 2;
        }
        return Math.min(cn1, cn2);
    }

}
