import java.util.Arrays;

/**
 * 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 */
public class SortColors {

    // 数组
    // 双指针
    // 排序
    public void sortColors(int[] nums) {
        int redIx = 0;
        int blueIx = nums.length - 1;
        int i = 0;

        while (i < blueIx) {
            if (nums[blueIx] == 2) {
                blueIx--;
            } else {
                if (nums[i] == 2) {
                    int tmp = nums[i];
                    nums[i] = nums[blueIx];
                    nums[blueIx] = tmp;
                    blueIx--;
                }
                i++;
            }
        }

        i = 0;
        while (i < nums.length) {
            if (nums[redIx] == 2) {
                redIx++;
            } else {
                if (nums[i] == 0) {
                    int tmp = nums[i];
                    nums[i] = nums[redIx];
                    nums[redIx] = tmp;
                    redIx++;
                }
            }
            i++;
        }
    }

    public static void main(String[] args) {
        SortColors sc = new SortColors();
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sc.sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2, 0, 1};
        sc.sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 0, 1};
        sc.sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 0};
        sc.sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2, 1, 2};
        sc.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
