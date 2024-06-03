import java.util.*;

public class IntensitySegments {

    /**
     * 双向队列维护区间
     */
    private final Deque<Segment> segments;

    /**
     * 构造函数
     */
    public IntensitySegments() {
        this.segments = new ArrayDeque<>();
    }

    /**
     * 添加新区间
     *
     * @param from   区间起始下标
     * @param to     区间终止下标
     * @param amount 区间强度
     */
    public void add(int from, int to, int amount) {
        if (from > to) {
            throw new IllegalArgumentException("Error Input.");
        }
        segmentIntersection(new Segment(from, to, amount));
    }

    /**
     * 设置区间值
     *
     * @param from   区间起始下标
     * @param to     区间终止下标
     * @param amount 区间强度
     */
    public void set(int from, int to, int amount) {
        add(from, to, amount - getSum(from, to));
    }

    @Override
    public String toString() {
        List<Segment> segmentList = new ArrayList<>(segments);
        segmentList.sort((o1, o2) -> {
            if (o1.getStart() < o2.getStart()) {
                return -1;
            } else if (o1.getStart() > o2.getStart()) {
                return 1;
            }
            return 0;
        });
        int firstIntensityValid = 0;
        for (int i = 0; i < segmentList.size(); i++) {
            if (segmentList.get(i).getValue() != 0) {
                firstIntensityValid = i;
                break;
            }
        }
        List<Segment> res = new ArrayList<>();
        for (int i = firstIntensityValid; i < segmentList.size(); i++) {
            res.add(segmentList.get(i));
        }
        if (!segmentList.isEmpty()) {
            Segment last = segmentList.get(segmentList.size() - 1);
            if (last.getValue() != 0) {
                res.add(new Segment(last.getEnd(), last.getEnd(), 0));
            }
        }
        return res.isEmpty() ? "[]" : res.toString();
    }

    /**
     * 获取区间强度
     *
     * @param from 区间起始下标
     * @param to   区间终止下标
     * @return 区间强度
     */
    private int getSum(int from, int to) {
        return segments.stream().filter(segment -> segment.start <= to && segment.end >= from).mapToInt(Segment::getValue).sum();
    }

    public static class Segment {
        final int start;
        final int end;
        final int value;

        public Segment(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "[" + start + "," + value + "]";
        }
    }

    /**
     * 添加新的区间
     *
     * @param newSegment 新的区间
     */
    private void segmentIntersection(Segment newSegment) {
        if (segments.isEmpty()) {
            // 新增第一个区间
            segments.addLast(newSegment);
            return;
        }

        // 维护待添加区间
        Deque<Segment> toAddedSegments = new ArrayDeque<>();
        toAddedSegments.addLast(newSegment);

        while (!segments.isEmpty() && !toAddedSegments.isEmpty()) {
            Segment top = segments.pollFirst();
            Segment toAdded = toAddedSegments.pollFirst();

            if (top.end < toAdded.start || top.start > toAdded.end) {
                // 两个区间不相交
                segments.addLast(top);
                segments.addLast(toAdded);
            } else {
                int leftMin = Math.min(top.start, toAdded.start);
                int leftMax = Math.max(top.start, toAdded.start);

                int rightMin = Math.min(top.end, toAdded.end);
                int rightMax = Math.max(top.end, toAdded.end);

                // 左边部分
                Segment left = new Segment(leftMin, leftMax, top.start < toAdded.start ? top.value : toAdded.value);
                // 相交部分
                Segment mid = new Segment(leftMax, rightMin, top.value + toAdded.value);
                // 右边部分
                Segment right = new Segment(rightMin, rightMax, top.end < toAdded.end ? toAdded.value : top.value);

                if (left.start < left.end) {
                    if (left.start == toAdded.start) {
                        // 剩余待新增区间
                        toAddedSegments.addLast(left);
                    } else {
                        segments.addLast(left);
                    }
                }

                // 相交部分
                if (mid.start < mid.end) {
                    segments.addLast(mid);
                }

                if (right.start < right.end) {
                    if (right.end == toAdded.end) {
                        // 剩余待新增区间
                        toAddedSegments.addLast(right);
                    } else {
                        segments.addLast(right);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        IntensitySegments segments = new IntensitySegments();

        // Test case 1
        System.out.println(segments);
        segments.add(10, 30, 1);
        System.out.println(segments);
        segments.add(20, 40, 1);
        System.out.println(segments);
        segments.add(10, 40, -2);
        System.out.println(segments);

        // Test case 2
        segments = new IntensitySegments();
        System.out.println(segments);
        segments.add(10, 30, 1);
        System.out.println(segments);
        segments.add(20, 40, 1);
        System.out.println(segments);
        segments.add(10, 40, -1);
        System.out.println(segments);
        segments.add(10, 40, -1);
        System.out.println(segments);
    }
}