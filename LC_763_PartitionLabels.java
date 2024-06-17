import java.util.ArrayList;
import java.util.List;

/**
 * 【划分字母区间】
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 */
public class LC_763_PartitionLabels {

    // 贪心
    // 哈希表
    // 双指针
    // 字符串
    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            int lastIndex = s.lastIndexOf(chars[i]);
            if (lastIndex > end) {
                // 遇到更远的end就替换
                end = lastIndex;
            }
            // 到达前面字符的最远下标点，就计算一次长度
            if (end == i) {
                res.add(end - start + 1);
                // 区间进入滑动
                start = i + 1;
            }
        }

        return res;
    }
}
