/**
 * 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */
public class UniquePaths {

    // 数学
    // 动态规划  多维动态规划
    // 组合数学
    public int uniquePaths(int m, int n) {
        // 状态转移方程：dp[i+1][j+1] = dp[i+1][j] + dp[i][j+1]
        // 初始条件：dp[0][0] = 1
        // 边界条件：递推终止的条件
        // 状态和状态变量

        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        int m = 3, n = 7;
        int num = up.uniquePaths(m, n);
        System.out.println(num);

        m = 3;
        n = 2;
        num = up.uniquePaths(m, n);
        System.out.println(num);
    }
}
