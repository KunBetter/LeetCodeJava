/**
 * 【完全平方数】
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
public class NumSquares {

    // 广度优先搜索
    // 数学
    // 动态规划
    public int numSquares(int n) {
        /*
         * f[i] = 1 + min{f[i-j^2]}. 1<= j <= sqrt(i)
         */
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }

        return f[n];
    }

    public static void main(String[] args) {
        NumSquares ns = new NumSquares();
        int n = 12;
        int cnt = ns.numSquares(n);
        System.out.println(cnt);
    }
}
