package DoubleWeekCompitition.leetcode52DoubleWeek;

public class Leetcode1 {

    public int[] memLeak(int memory1, int memory2) {
        int[] res = new int[3];
        int i = 1;
        while (i <= Math.max(memory1, memory2)) {
            if (memory1 == memory2) {
                memory1 -= i;
            } else if (memory1 < memory2) {
                memory2 -= i;
            } else {
                memory1 -= i;
            }
            i++;
        }
        res[0] = i;
        res[1] = memory1;
        res[2] = memory2;
        return res;
    }
}
