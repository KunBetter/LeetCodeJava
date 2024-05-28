/**
 * 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class StockMaxProfit {

    // 数组
    // 动态规划
    public int maxProfit(int[] prices) {
        int profit = 0;
        // 🔥核心：一个游标来记录最低的价格
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minCost = Math.min(prices[i], minCost);
            profit = Math.max(profit, prices[i] - minCost);
        }

        return profit;
    }

    public static void main(String[] args) {
        StockMaxProfit smp = new StockMaxProfit();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int profit = smp.maxProfit(prices);
        System.out.println(profit);
    }
}
