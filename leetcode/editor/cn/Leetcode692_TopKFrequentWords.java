package editor.cn;

import java.util.*;

// 692.前K个高频单词(top-k-frequent-words)
public class Leetcode692_TopKFrequentWords {
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || k > words.length || k <= 0) {
            return null;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String[]> heap = new PriorityQueue<>((o1, o2) -> Integer.valueOf(o1[1]).equals(Integer.valueOf(o2[1])) ? o1[0].compareTo(o2[0]) : Integer.parseInt(o1[2]) - Integer.parseInt(o1[1]));
        for (String key : map.keySet()) {
            String value = String.valueOf(map.get(key));
            heap.add(new String[]{key, value});
        }

        List<String> res = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            res.add(heap.remove()[0]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

