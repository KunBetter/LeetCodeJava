import java.util.Arrays;
import java.util.Comparator;

/**
 * 区间合并
 */
public class RangMerge {

    // 数组
    // 排序
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));

        int[][] res = new int[intervals.length][2];
        int idx = 0;

        for (int[] interval : intervals) {
            // 如果结果数组为空 || 区间的起始位置大于结果中最后一个区间的结束位置，则不合并
            if (idx == 0 || interval[0] > res[idx - 1][1]) {
                res[idx] = interval;
                idx++;
            } else {
                // 合并
                res[idx - 1][1] = Math.max(res[idx - 1][1], interval[1]);
            }
        }

        return Arrays.copyOf(res, idx);
    }

    public static void main(String[] args) {
        RangMerge rm = new RangMerge();
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = rm.merge(intervals);
        for (int[] interval : res) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
