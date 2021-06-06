package editor.cn;

import java.awt.*;
import java.util.Arrays;

// 1707.与数组中元素的最大异或值(maximum-xor-with-an-element-from-array)
public class Leetcode1707_MaximumXorWithAnElementFromArray {
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class Trie {
        Trie[] child;
        Trie() {
            child = new Trie[2];
        }
    }

    Trie root = new Trie();

    public void insert(int x) {
        Trie node = root;
        for (int i = 31; i >= 0; i--) {
            int n = (x >> i) & 1;
            if (node.child[n] == null) {
                node.child[n] = new Trie();
            }
            node = node.child[n];
        }
    }

    public int findMaxXOR(int x) {
        int res = 0;
        Trie node = root;
        for (int i = 31; i >= 0; i--) {
            int n = (x >> i) & 1;
            int p = 1 - n;
            if (node.child[p] != null) {
                res = res | (p << i);
                node = node.child[p];
            } else {
                res = res | (n << i);
                node = node.child[n];
            }
        }
        return res;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        Arrays.sort(nums);
        int[][] newQueries = new int[q][3];
        for (int i = 0; i < q; i++) {
            newQueries[i][0] = queries[i][0];
            newQueries[i][1] = queries[i][1];
            newQueries[i][2] = i;
        }
        Arrays.sort(nums);
        Arrays.sort(newQueries, (a, b) -> a[1] - b[1]);

        int[] res = new int[q];
        int i = 0;
        for (int[] query : newQueries) {
            int x = query[0];
            int m = query[1];
            int idx = query[2];
            while (i < n && nums[i] <= m) {
                insert(nums[i]);
                i++;
            }
            if (i == 0) {
                res[idx] = -1;
            } else {
                res[idx] = findMaxXOR(x) ^ x;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

