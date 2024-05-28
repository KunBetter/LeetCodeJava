/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Trap {

    // 栈、数组、双指针、动态规划、单调栈
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }

        int water = 0;

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int waterArea = trap.trap(height);
        System.out.println(waterArea);

        height = new int[]{4, 2, 0, 3, 2, 5};
        waterArea = trap.trap(height);
        System.out.println(waterArea);
    }
}
