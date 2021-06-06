package WeekCompitition.leetcode243WeekCompition;

import javafx.scene.layout.Priority;

import java.util.*;

public class Leetcode3 {

    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        PriorityQueue<int[]> rest = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[2] == b[2] ? (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]) : a[2] - b[2]);
        for (int i = 0; i < n; i++) {
            rest.add(new int[]{servers[i], i, 0});
        }
        int[] res = new int[m];

        for (int i = 0; i < m; i++) {
            while (!busy.isEmpty() && i >= busy.peek()[2]) {
                rest.add(busy.remove());
            }
            int[] top;
            if (!rest.isEmpty()) {
                top = rest.remove();
                busy.add(new int[]{top[0], top[1], i + tasks[i]});
            } else {
                top = busy.remove();
                busy.add(new int[]{top[0], top[1], top[2] + tasks[i]});
            }
            res[i] = top[1];
        }

        return res;
    }


    public static void main(String[] args) {


    }

}
