import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class SpiralOrder {

    // 数组
    // 矩阵
    // 模拟
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return new ArrayList<>();
        }
        int col = matrix[0].length;

        int moveCnt = row * col - 1;
        int step = 0;

        int i = 0;
        int j = 0;

        List<Integer> items = new ArrayList<>();
        items.add(matrix[i][j]);

        // 🔥核心
        int direction = 0;
        // 螺旋层
        int circle = 0;

        while (step < moveCnt) {
            // 向右 0
            if (direction == 0) {
                if (j < col - 1 - circle) {
                    j++;
                    step++;
                    items.add(matrix[i][j]);
                } else {
                    direction = (direction + 1) % 4;
                }
            } else if (direction == 1) {
                // 向下 1
                if (i < row - 1 - circle) {
                    i++;
                    step++;
                    items.add(matrix[i][j]);
                } else {
                    direction = (direction + 1) % 4;
                }
            } else if (direction == 2) {
                // 向左 2
                if (j > circle) {
                    j--;
                    step++;
                    items.add(matrix[i][j]);
                } else {
                    direction = (direction + 1) % 4;
                }
            } else if (direction == 3) {
                // 向上 3
                if (i > circle + 1) {
                    i--;
                    step++;
                    items.add(matrix[i][j]);
                } else {
                    direction = 0;
                    // 🔥
                    circle++;
                }
            }
        }

        return items;
    }

    public static void main(String[] args) {
        SpiralOrder so = new SpiralOrder();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> res = so.spiralOrder(matrix);
        System.out.println(res);

        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        res = so.spiralOrder(matrix);
        System.out.println(res);
    }
}
