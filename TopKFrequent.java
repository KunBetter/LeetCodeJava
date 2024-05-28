import java.util.*;

/**
 * 前K个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class TopKFrequent {

    // 数组
    // 哈希表
    // 分治
    // 桶排序
    // 计数
    // 快速选择
    // 排序
    // 堆（优先队列）
    public int[] topKFrequent(int[] nums, int k) {
        // 首先使用哈希表统计频率，统计完成后，创建一个数组，
        // 将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标即可。
        List<Integer> res = new ArrayList<>();
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            // 获取出现的次数作为下标
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList<>();
            }
            list[i].add(key);
        }

        int n = 0;

        // 倒序遍历数组获取出现顺序从大到小的排列
        for (int i = list.length - 1; i >= 0 && res.size() < k; i--) {
            if (list[i] == null) {
                continue;
            }
            res.addAll(list[i]);
        }

        int[] r = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }

        return r;
    }

    public static void main(String[] args) {
        TopKFrequent tk = new TopKFrequent();
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] e = tk.topKFrequent(nums, k);
        System.out.println(Arrays.toString(e));

        nums = new int[]{1, 2};
        k = 2;
        e = tk.topKFrequent(nums, k);
        System.out.println(Arrays.toString(e));
    }
}
