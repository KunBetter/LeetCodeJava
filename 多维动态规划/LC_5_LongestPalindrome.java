package 多维动态规划;

/**
 * 【最长回文子串】
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LC_5_LongestPalindrome {

    // 双指针
    // 字符串
    // 动态规划
    public String longestPalindrome(String str) {
        // 状态转移方程：
        // 初始条件：
        // 边界条件：递推终止的条件.
        // 状态和状态变量：
        // 是否具备最优子结构：有
        // 动态规划问题存在「重叠子问题」.需要使用「备忘录」或者「DP table」来优化穷举过程，避免不必要的计算。

        if (str == null || str.isEmpty()) {
            return "";
        }
        String s1 = innerLongestPalindrome(str, false);
        String s2 = innerLongestPalindrome(str, true);

        if (s1.length() > s2.length()) {
            return s1;
        }

        return s2;
    }

    public static String innerLongestPalindrome(String str, boolean flag) {
        int len = str.length();
        int i = 0;
        int maxLen = 0, l = 0, r = 0;
        byte[] bs = str.getBytes();
        while (i < len) {
            int left = i;
            int right = i;
            // 解决重复的情况 cbbd
            if (flag && right + 1 < len && bs[right] == bs[right + 1]) {
                right++;
            }
            // 核心
            while (left - 1 >= 0 && right + 1 < len && bs[left - 1] == bs[right + 1]) {
                left--;
                right++;
            }
            if (maxLen < right - left + 1) {
                maxLen = right - left + 1;
                l = left;
                r = right;
            }

            i++;
        }
        return str.substring(l, r + 1);
    }

    public static void main(String[] args) {
        LC_5_LongestPalindrome lp = new LC_5_LongestPalindrome();
        String s = "babad";
        String ans = lp.longestPalindrome(s);
        System.out.println(ans);

        s = "cbbd";
        ans = lp.longestPalindrome(s);
        System.out.println(ans);
    }
}
