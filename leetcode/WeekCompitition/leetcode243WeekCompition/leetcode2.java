package WeekCompitition.leetcode243WeekCompition;

public class leetcode2 {

    public String maxValue(String n, int x) {
        char[] cs = n.toCharArray();
        int len = cs.length;
        StringBuilder sb = new StringBuilder();
        if (cs[0] != '-') {
            for (int i = 0; i < len; i++) {
                if (cs[i] - '0' >= x) {
                    sb.append(cs[i]);
                } else {
                    sb.append(x);
                    sb.append(n, i, len);
                    break;
                }
                if (i == len - 1) {
                    sb.append(x);
                }
            }
        } else {
            sb.append('-');
            for (int i = 1; i < len; i++) {
                if (cs[i] - '0' <= x) {
                    sb.append(cs[i]);
                } else {
                    sb.append(x);
                    sb.append(n, i, len);
                    break;
                }
                if (i == len - 1) {
                    sb.append(x);
                }
            }
        }

        return sb.toString();
    }
}
