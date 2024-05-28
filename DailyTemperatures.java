import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，
 * 请在该位置用 0 来代替。
 */
public class DailyTemperatures {

    // 栈
    // 数组
    // 单调栈
    public int[] dailyTemperatures(int[] temperatures) {
        // 🔥单调栈存储数组的下标
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] nextDay = dt.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(nextDay));
    }
}
