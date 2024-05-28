import java.util.Arrays;

/**
 * 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 */
public class CoinChange {

    // 广度优先搜索
    // 数组
    // 动态规划
    public int coinChange(int[] coins, int amount) {
        // 状态转移方程：dp[amount] = min{dp[amount-coins[i]]}+1
        // 初始条件：dp[0] = 0
        // 边界条件：递推终止的条件. 兑换完为止：amount-coins[i] == 0
        // 状态和状态变量：剩余可兑换硬币数
        // 是否具备最优子结构：有
        // 动态规划问题存在「重叠子问题」.需要使用「备忘录」或者「DP table」来优化穷举过程，避免不必要的计算。
        // 自底向上的动态规划
        if (coins.length == 0) {
            return -1;
        }

        // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] memo = new int[amount + 1];
        // 给memo赋初值，最多的硬币数就是全部使用面值1的硬币进行换
        // amount + 1 是不可能达到的换取数量，于是使用其进行填充
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    // memo[i]有两种实现的方式，
                    // 一种是包含当前的coins[i],那么剩余钱就是 i-coins[i],这种操作要兑换的硬币数是 memo[i-coins[j]] + 1
                    // 另一种就是不包含，要兑换的硬币数是memo[i]
                    memo[i] = Math.min(memo[i], memo[i - coins[j]] + 1);
                }
            }
        }

        return memo[amount] == (amount + 1) ? -1 : memo[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int j : coins)
                if (i >= j) {
                    dp[i] = Math.min(dp[i - j] + 1, dp[i]);
                }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        int num = cc.coinChange(coins, amount);
        System.out.println(num);

        coins = new int[]{2};
        amount = 3;
        num = cc.coinChange(coins, amount);
        System.out.println(num);

        coins = new int[]{1};
        amount = 0;
        num = cc.coinChange(coins, amount);
        System.out.println(num);

        coins = new int[]{2, 5, 10, 1};
        amount = 27;
        num = cc.coinChange(coins, amount);
        System.out.println(num);

        coins = new int[]{186, 419, 83, 408};
        amount = 6249;
        num = cc.coinChange(coins, amount);
        System.out.println(num);
    }
}
