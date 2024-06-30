import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 【数据流的中位数】
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 */
public class LC_295_MedianFinder {

    // 左边大顶堆，右边小顶堆
    // 小的加左边，大的加右边
    // 平衡俩堆数，新加就弹出
    // 堆顶给对家，奇数取多的，偶数取除2

    // 当数据流元素数量为偶数：l 和 r 大小相同，此时动态中位数为两者堆顶元素的平均值
    // 当数据流元素数量为奇数：l 比 r 多一，此时动态中位数为 l 的堆顶原数

    private final Queue<Integer> left;
    private final Queue<Integer> right;

    /**
     * 设计
     * 双指针
     * 数据流
     * 排序
     * 堆（优先队列）
     */
    public LC_295_MedianFinder() {
        left = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        right = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }

    // 将数据流中的整数 num 添加到数据结构中。
    /*
     * 这里每次插入元素不用比较大小的原因在于，此时来了一个新的元素，
     * 我想插入A，他有两种情况，第一种他比B的堆顶元素大，此时理论上可以直接插入A；
     * 第二种情况，他比B的堆顶元素小，此时就不能直接插入A，需要先插入B维持较小的元素都在B内，
     * 然后取B的堆顶元素插入A； 而为了简化比较操作，回到第一种情况，
     * 可以先统一把元素插入B，然后此时B基于大顶堆的结构特性，会将该元素作为新的堆顶元素，
     * 此时再执行插入A的操作就相当于此前在B处过渡了一下，
     * 最终还是会插入A 可以理解是代码更简洁，但用堆的自身调整操作替换了比较大小的操作。
     */
    public void addNum(int num) {
        if (left.size() != right.size()) {
            left.add(num);
            right.add(left.poll());
        } else {
            right.add(num);
            left.add(right.poll());
        }
    }

    public void addNum2(int num) {
        int s1 = left.size(), s2 = right.size();
        if (s1 == s2) {
            if (right.isEmpty() || num <= right.peek()) {
                left.add(num);
            } else {
                left.add(right.poll());
                right.add(num);
            }
        } else {
            if (!left.isEmpty() && left.peek() <= num) {
                right.add(num);
            } else {
                right.add(left.poll());
                left.add(num);
            }
        }
    }

    // 返回到目前为止所有元素的中位数。与实际答案相差 10^-5 以内的答案将被接受。
    public double findMedian() {
        return left.size() != right.size() ? left.peek() : (left.peek() + right.peek()) / 2.0;
    }

    public static void main(String[] args) {
        LC_295_MedianFinder medianFinder = new LC_295_MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // 返回 1.5 ((1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
    }
}
