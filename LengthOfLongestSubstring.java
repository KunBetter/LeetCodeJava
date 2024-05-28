import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 */
public class LengthOfLongestSubstring {

    // 哈希表、字符串、滑动窗口
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len <= 1) {
            return len;
        }
        // 使用哈希表，存储滑动窗口内的字符串重复情况
        // 使用两个游标，标记滑动窗口
        Set<Integer> dic = new HashSet<>();

        int left = 0;
        int right = -1;

        int res = 0;

        while (left < len && right + 1 < len) {
            if (!dic.contains(s.charAt(right + 1) - 'a')) {
                dic.add(s.charAt(right + 1) - 'a');
                right++;
            } else {
                // 此行容易遗漏
                dic.remove(s.charAt(left) - 'a');
                left++;
            }

            if (res < right - left + 1) {
                res = right - left + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lls = new LengthOfLongestSubstring();
        String s = "abcabcbb";
        int length = lls.lengthOfLongestSubstring(s);
        System.out.println(length);

        s = "bbbbb";
        length = lls.lengthOfLongestSubstring(s);
        System.out.println(length);

        s = "pwwkew";
        length = lls.lengthOfLongestSubstring(s);
        System.out.println(length);

        s = " ";
        length = lls.lengthOfLongestSubstring(s);
        System.out.println(length);

        s = "au";
        length = lls.lengthOfLongestSubstring(s);
        System.out.println(length);

        s = "dvdf";
        length = lls.lengthOfLongestSubstring(s);
        System.out.println(length);
    }
}
