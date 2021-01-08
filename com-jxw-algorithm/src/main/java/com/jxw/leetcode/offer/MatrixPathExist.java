package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/1/7 14:53
 * @description https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * <p>
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * <p>
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * <p>
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>
 */
public class MatrixPathExist {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, int x, int y, String word, int index) {
        if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1 || word.charAt(index) != board[x][y]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        char temp = board[x][y];
        // 标识元素，防止
        // 回头
        board[x][y] = '/';
        //左右上下遍历  若有一个方向找到则停止
        if (exist(board, x - 1, y, word, index + 1)
                || exist(board, x + 1, y, word, index + 1)
                || exist(board, x, y + 1, word, index + 1)
                || exist(board, x, y - 1, word, index + 1)) {
            return true;
        }
        board[x][y] = temp;
        return false;
    }

}
