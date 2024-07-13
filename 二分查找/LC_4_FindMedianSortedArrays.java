package 二分查找;

/**
 * 【寻找两个正序数组的中位数】
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class LC_4_FindMedianSortedArrays {

    // 数组
    // 二分查找
    // 分治
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return innerFindMedianSortedArrays(nums1, nums2);
        }
        return innerFindMedianSortedArrays(nums2, nums1);
    }

    private double innerFindMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;

        int iMin = 0;
        int iMax = m;
        int halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1;
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1;
            } else {
                double maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                double minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2;
            }
        }

        return 0D;
    }

    public static void main(String[] args) {
        LC_4_FindMedianSortedArrays fsa = new LC_4_FindMedianSortedArrays();
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        double m = fsa.findMedianSortedArrays(nums1, nums2);
        System.out.println(m);

        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        m = fsa.findMedianSortedArrays(nums1, nums2);
        System.out.println(m);
    }
}
