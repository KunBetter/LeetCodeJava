/**
 * 盛最多水的容器
 */
public class MaxArea {

    // 贪心、数组、双指针
    public int maxArea(int[] height) {
        // 左右两个指标，分别往之间移动，利用贪心算法，记录最大的水容量
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;

        while (left < right) {
            int curMaxArea = (right - left) * Math.min(height[left], height[right]);
            if (curMaxArea > maxArea) {
                maxArea = curMaxArea;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        MaxArea ma = new MaxArea();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int area = ma.maxArea(height);
        System.out.println(area);
    }
}
