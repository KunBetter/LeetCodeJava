import java.util.*;

/**
 * 最长连续序列
 */
public class LongestConsecutive {
    Map<Integer, Integer> father = new HashMap<>();
    Map<Integer, Integer> size = new HashMap<>();

    // 并查集、数组、哈希
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        father.clear();
        size.clear();
        Set<Integer> innerNums = new HashSet<>();
        // 初始化
        for (int num : nums) {
            father.put(num, num);
            size.put(num, 1);
            innerNums.add(num);
        }

        int res = 1;
        for (int num : innerNums) {
            if (father.containsKey(num + 1)) {
                int _size = merge(num, num + 1);
                if (_size > 0 && _size > res) {
                    res = _size;
                }
            }
        }

        return res;
    }

    private int find(int x) {
        if (father.get(x) == x) {
            return x;
        } else {
            // 路径压缩
            int fa = find(father.get(x));
            father.put(x, fa);
            return fa;
        }
    }

    private int merge(int i, int j) {
        int fi = find(i);
        int fj = find(j);
        if (fi != fj) {
            father.put(fi, fj);
            int unionSize = size.get(fj) + size.get(fi);
            size.put(fj, unionSize);
            return size.get(fj);
        }

        return 0;
    }

    public static void main(String[] args) {
        LongestConsecutive lc = new LongestConsecutive();
        int[] nums = new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        int res = lc.longestConsecutive(nums);
        System.out.println(res);

        nums = new int[]{-1, 0};
        res = lc.longestConsecutive(nums);
        System.out.println(res);

        nums = new int[]{0, 0};
        res = lc.longestConsecutive(nums);
        System.out.println(res);

        nums = new int[]{4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3};
        res = lc.longestConsecutive(nums);
        System.out.println(res);

        nums = new int[]{-6, -1, -1, 9, -8, -6, -6, 4, 4, -3, -8, -1};
        res = lc.longestConsecutive(nums);
        System.out.println(res);
    }
}
