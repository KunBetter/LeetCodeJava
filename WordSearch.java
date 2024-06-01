/**
 * 【单词搜索】
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class WordSearch {

    // 数组
    // 字符串
    // 回溯
    // 矩阵
    public boolean exist(char[][] board, String word) {
        // 回溯矩阵，记录走过的路径
        // 剪枝条件
        // 终止条件

        int row = board.length;
        if (row == 0) {
            return false;
        }
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, word, row, col, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int i, int j, int k) {
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return false;
        }

        if (word.charAt(k) != board[i][j]) {
            return false;
        }

        if (k == word.length() - 1) {
            return true;
        }

        // reached
        board[i][j] = '\0';

        boolean res = dfs(board, word, row, col, i - 1, j, k + 1) || dfs(board, word, row, col, i + 1, j, k + 1) || dfs(board, word, row, col, i, j - 1, k + 1) || dfs(board, word, row, col, i, j + 1, k + 1);

        // 还原矩阵
        board[i][j] = word.charAt(k);

        return res;
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean flag = ws.exist(board, word);
        System.out.println(flag);

        board = new char[][]{{'a', 'b'}};
        word = "ba";
        flag = ws.exist(board, word);
        System.out.println(flag);

        board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        word = "SEE";
        flag = ws.exist(board, word);
        System.out.println(flag);

        board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        word = "ABCB";
        flag = ws.exist(board, word);
        System.out.println(flag);
    }
}
