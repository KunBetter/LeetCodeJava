package 动态规划;

import java.util.Deque;
import java.util.LinkedList;

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
        /*
         * 始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」，
         * 这样的做法主要是考虑了边界条件的处理，栈里其他元素维护左括号的下标：
         * -- 对于遇到的每个 ‘(’ ，我们将它的下标放入栈中
         * -- 对于遇到的每个 ‘)’ ，我们先弹出栈顶元素表示匹配了当前右括号：
         * --- 如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
         * --- 如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
         */
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<>();

        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }

        return maxans;
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
