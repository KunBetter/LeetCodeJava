/**
 * 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class NumIslands {

    // 深度优先搜索
    // 广度优先搜索
    // 并查集
    // 数组
    // 矩阵
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int num = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    // 发现岛屿
                    num++;
                    // 淹没岛屿
                    dfs(grid, i, j, row, col);
                }
            }
        }

        return num;
    }

    private void dfs(char[][] grid, int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col) {
            // 边界判断
            return;
        }
        // 已经是海水
        if (grid[i][j] == '0') {
            return;
        }
        // 淹没
        grid[i][j] = '0';
        dfs(grid, i - 1, j, row, col);
        dfs(grid, i, j + 1, row, col);
        dfs(grid, i, j - 1, row, col);
        dfs(grid, i + 1, j, row, col);
    }

    public static void main(String[] args) {
        NumIslands nl = new NumIslands();
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int num = nl.numIslands(grid);
        System.out.println(num);

        grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        num = nl.numIslands(grid);
        System.out.println(num);
    }
}
