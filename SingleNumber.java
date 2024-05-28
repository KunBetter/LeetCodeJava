/**
 * 只出现一次的数字
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 */
public class SingleNumber {

    // 位运算。& 与运算（都1为1、其余为0）、| 或运算（都0为0、其余为1）、^ 异或运算（不同为1、其余为0）
    // 数组
    public int singleNumber(int[] nums) {
        int num = 0;
        for (int j : nums) {
            num ^= j;
        }

        return num;
    }

    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
        int[] nums = new int[]{4, 1, 2, 1, 2};
        int num = sn.singleNumber(nums);
        System.out.println(num);
    }
}
