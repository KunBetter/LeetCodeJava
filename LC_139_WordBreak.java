import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 【单词拆分】
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。
 * 如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class LC_139_WordBreak {

    // 字典树
    // 记忆化搜索
    // 数组
    // 哈希表
    // 字符串
    // 动态规划
    // s = "leetcode", wordDict = ["leet", "code"]
    // s = "applepenapple", wordDict = ["apple", "pen"]
    public boolean wordBreak(String s, List<String> wordDict) {
        // 状态转移方程：
        //  1、dp[i]字符串长度为i的话，dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词。
        //  2、如果确定dp[j] 是true，且 [j, i] 这个区间的子串出现在字典里，那么dp[i]一定是true。（j < i ）。
        //  3、递推公式是 if([j, i] 这个区间的子串出现在字典里 && dp[j]是true) 那么 dp[i] = true。
        // 初始条件：dp[0]表示如果字符串为空的话，说明出现在字典里。
        //      下标非0的dp[i]初始化为false，只要没有被覆盖说明都是不可拆分为一个或多个在字典中出现的单词。
        // 边界条件：递推终止的条件.
        // 状态和状态变量：
        // 是否具备最优子结构：有
        // 动态规划问题存在「重叠子问题」.需要使用「备忘录」或者「DP table」来优化穷举过程，避免不必要的计算。
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i && !valid[i]; j++) {
                if (set.contains(s.substring(j, i)) && valid[j]) {
                    valid[i] = true;
                }
            }
        }

        return valid[s.length()];
    }

    // 🔥 要熟悉这种
    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && dp[i - len] && word.equals(s.substring(i - len, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    // 回溯法+记忆化
    private Set<String> set;
    private int[] memo;

    public boolean wordBreak3(String s, List<String> wordDict) {
        memo = new int[s.length()];
        set = new HashSet<>(wordDict);
        return backtracking(s, 0);
    }

    public boolean backtracking(String s, int startIndex) {
        // System.out.println(startIndex);
        if (startIndex == s.length()) {
            return true;
        }
        if (memo[startIndex] == -1) {
            return false;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i + 1);
            // 拆分出来的单词无法匹配
            if (!set.contains(sub)) {
                continue;
            }
            boolean res = backtracking(s, i + 1);
            if (res) return true;
        }
        // 这里是关键，找遍了startIndex~s.length()也没能完全匹配，标记从startIndex开始不能找到
        memo[startIndex] = -1;
        return false;
    }
}
