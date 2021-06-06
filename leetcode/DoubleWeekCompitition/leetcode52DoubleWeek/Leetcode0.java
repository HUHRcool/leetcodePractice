package DoubleWeekCompitition.leetcode52DoubleWeek;

import java.util.Arrays;

public class Leetcode0 {

    public String sortSentence(String s) {
        String[] ss = s.split(" ");
        Arrays.sort(ss, (o1, o2) -> o1.charAt(o1.length() - 1) - o2.charAt(o2.length() - 1));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            sb.append(ss[i].substring(0, ss[i].length()));
        }

        return sb.toString();
    }
}
