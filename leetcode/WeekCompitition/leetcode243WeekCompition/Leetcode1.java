package WeekCompitition.leetcode243WeekCompition;

public class Leetcode1 {


    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return count(firstWord) + count(secondWord) == count(targetWord);
    }

    private int count(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            res = res * 10 + (c - 'a');
        }
        return res;
    }

}
