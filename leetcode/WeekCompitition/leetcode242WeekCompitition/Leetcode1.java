package WeekCompitition.leetcode242WeekCompitition;

public class Leetcode1 {
    public boolean checkZeroOnes(String s) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int max1 = 0;
        int max0 = 0;
        while (right < n) {
            while (right < n && s.charAt(right) == '1') {
                right++;
            }
            max1 = Math.max(max1, right - left);
            left = right;
            while (right < n && s.charAt(right) == '0') {
                right++;
            }
            max0 = Math.max(max0, right - left);
            left = right;
            right++;
        }
        System.out.println(max1);
        System.out.println(max0);

        return max1 > max0;
    }

}
