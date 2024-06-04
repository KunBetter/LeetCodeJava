import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 【N皇后】
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class SolveNQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[][] grid = new int[n][n];

        dfs(res, grid, 0);

        return res;
    }

    /**
     * grid中，已被皇后占用，赋值为1
     * 不可被占用，赋值为-1
     * 可被占用，为0
     */
    private void dfs(List<List<String>> res, int[][] grid, int row) {
        if (row == grid.length) {
            res.add(transfer(grid));
            return;
        }

        // 遍历行
        for (int col = 0; col < grid.length; col++) {
            if (row == 0) {
                clearGrid(grid);
            }
            //判断这个位置是否可以放皇后
            if (valid(grid, row, col)) {
                grid[row][col] = 1;
                dfs(res, grid, row + 1);
                // 🔥回溯
                grid[row][col] = 0;
            }
        }
    }

    private boolean valid(int[][] grid, int row, int col) {
        // 坐标位置的上面有没有皇后
        for (int i = 0; i < row; i++) {
            if (grid[i][col] == 1) {
                return false;
            }
        }

        // 右上角
        for (int i = row - 1, j = col + 1; i >= 0 && j < grid.length; i--, j++) {
            if (grid[i][j] == 1) {
                return false;
            }
        }

        // 左上角
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (grid[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private void clearGrid(int[][] grid) {
        for (int[] row : grid) {
            Arrays.fill(row, 0);
        }
    }

    private List<String> transfer(int[][] grid) {
        List<String> res = new ArrayList<>();
        char[] data = new char[grid[0].length];

        for (int[] row : grid) {
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1) {
                    data[j] = 'Q';
                } else {
                    data[j] = '.';
                }
            }
            res.add(String.valueOf(data));
        }

        return res;
    }

    public static void main(String[] args) {
        SolveNQueens nq = new SolveNQueens();
        int n = 5;
        List<List<String>> nQueen = nq.solveNQueens(n);
        for (List<String> rows : nQueen) {
            for (String row : rows) {
                System.out.println(row);
            }
            System.out.println("---------------------");
        }
    }
}
