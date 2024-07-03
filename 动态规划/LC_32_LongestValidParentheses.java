package 动态规划;

/**
 * 【最长有效括号】
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 */
public class LC_32_LongestValidParentheses {

    // 栈
    // 字符串
    // 动态规划

    // 状态转移方程：
    // 初始条件：
    // 边界条件：递推终止的条件.
    // 状态和状态变量：
    // 是否具备最优子结构：有
    // 动态规划问题存在「重叠子问题」.需要使用「备忘录」或者「DP table」来优化穷举过程，避免不必要的计算。
    public int longestValidParentheses(String s) {
        return 0;
    }

    public static void main(String[] args) {
        LC_32_LongestValidParentheses vp = new LC_32_LongestValidParentheses();
        String s = ")()())";
        int len = vp.longestValidParentheses(s);
        System.out.println(len);

        s = ")()(()))";
        len = vp.longestValidParentheses(s);
        System.out.println(len);
    }
}
