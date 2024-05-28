import java.util.Arrays;

/**
 * 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class RotateImg {

    // 数组
    // 数学
    // 矩阵
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return;
        }
        // 第一步：上下翻转
        int rotateCnt = n / 2;
        for (int i = 0; i < rotateCnt; i++) {
            // i 行与 n-1-i 行交换
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = tmp;
            }
        }
        // 第二步：左斜向对角线翻转
        // 遍历左下角区域
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // i、j与右上角的进行交换j、i
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        RotateImg ri = new RotateImg();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ri.rotate(matrix);
        for (int[] r : matrix) {
            System.out.println(Arrays.toString(r));
        }
    }
}
