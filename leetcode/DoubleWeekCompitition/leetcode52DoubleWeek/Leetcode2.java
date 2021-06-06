package DoubleWeekCompitition.leetcode52DoubleWeek;

import java.util.Arrays;

public class Leetcode2 {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] newBox = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newBox[j][m - 1 - i] = box[i][j];
            }
        }
        System.out.println(Arrays.deepToString(newBox));
        for (int col = 0; col < m; col++) {
            int i = n;
            int j = n - 1;

            while (j >= 0) {
                if (newBox[j][col] == '.') {
                    j--;
                } else if (newBox[j][col] == '#') {
                    newBox[j][col] = '.';
                    j--;
                    newBox[i - 1][col] = '#';
                    i--;
                } else if (newBox[j][col] == '*'){
                    i = j;
                    j--;
                }
            }
        }
        return newBox;
    }

}
