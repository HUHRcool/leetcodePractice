package editor.cn;

import java.util.HashMap;

// 13.罗马数字转整数(roman-to-integer)
public class Leetcode13_RomanToInteger {
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            String symbol = String.valueOf(s.charAt(i));
            int cur = map.get(symbol);
            if (i < s.length() - 1 && cur < map.get(String.valueOf(s.charAt(i + 1)))) {
                res -= cur;
            } else {
                res += cur;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

