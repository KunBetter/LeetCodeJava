/**
 * 🔥【最长公共子序列】
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 */
public class LongestCommonSubSequence {

    // 多维动态规划
    public int longestCommonSubsequence(String text1, String text2) {
        // 如果两个字符串，最后一位相同，则最长公共子序列长度 = 前N-1位字符的最长公共子序列长度 + 1
        // 如果两个字符串，最后一位不同，则最长公共子序列长度 = max{<t1[0:n-1]、t2>，<t1、t2[0:n-1]>}
        if (text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }
        int n1 = text1.length(), n2 = text2.length();
        if (text1.charAt(n1 - 1) == text2.charAt(n2 - 1)) {
            return longestCommonSubsequence(text1.substring(0, n1 - 1), text2.substring(0, n2 - 1)) + 1;
        } else {
            return Math.max(longestCommonSubsequence(text1.substring(0, n1 - 1), text2), longestCommonSubsequence(text1, text2.substring(0, n2 - 1)));
        }
    }

    public int longestCommonSubsequence2(String text1, String text2) {
        // 如果两个字符串，最后一位相同，则最长公共子序列长度 = 前N-1位字符的最长公共子序列长度 + 1
        // 如果两个字符串，最后一位不同，则最长公共子序列长度 = max{<t1[0:n-1]、t2>，<t1、t2[0:n-1]>}
        if (text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }
        int n1 = text1.length(), n2 = text2.length();
        // 🔥dp[i][j]代表text1[0:i]、text2[0:j]的最长公共子序列
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i < n1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < n2; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n1; i++) {
            char t1 = text1.charAt(i - 1);
            for (int j = 1; j <= n2; j++) {
                char t2 = text2.charAt(j - 1);
                if (t1 == t2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n1][n2];
    }

    public static void main(String[] args) {
        LongestCommonSubSequence ls = new LongestCommonSubSequence();
        String text1 = "abcde", text2 = "ace";
        int len = ls.longestCommonSubsequence(text1, text2);
        System.out.println(len);

        text1 = "abcde";
        text2 = "ace";
        len = ls.longestCommonSubsequence2(text1, text2);
        System.out.println(len);
    }
}
