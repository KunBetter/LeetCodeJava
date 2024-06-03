import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 【柱状图中最大的矩形】
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class LargestRectangleArea {

    // 栈
    // 数组
    // 单调栈
    public int largestRectangleArea(int[] heights) {
        // 通过单调栈，找到矩形左右两边可扩展到的最远矩形
        // 遇到比自己低的柱子结束
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        // 单调栈
        Deque<Integer> monoStack = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                monoStack.pop();
            }
            left[i] = monoStack.isEmpty() ? -1 : monoStack.peek();
            monoStack.push(i);
        }

        monoStack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                monoStack.pop();
            }
            right[i] = monoStack.isEmpty() ? n : monoStack.peek();
            monoStack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        LargestRectangleArea lrl = new LargestRectangleArea();
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        int area = lrl.largestRectangleArea(heights);
        System.out.println(area);
    }
}
