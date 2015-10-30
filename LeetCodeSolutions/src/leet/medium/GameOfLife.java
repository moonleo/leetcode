package leet.medium;

/**
 * No.289 Game of Life
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the 
 * following four rules (taken from the above Wikipedia article):
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 */
public class GameOfLife {
	
	public void gameOfLife(int[][] board) {
        if(0 == board.length|| 0 == board[0].length) {
            return ;
        }
        int[][] matrix = new int[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                matrix[i][j] = cv(board, i, j);
            }
        }
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                board[i][j] = matrix[i][j];
            }
        }
    }
    
    private int cv(int[][] board, int i, int j) {
        int count = value(board, i-1, j-1) + value(board, i-1, j) + value(board, i-1, j+1) + 
        		value(board, i, j-1) + value(board, i, j+1) + 
        		value(board, i+1, j-1) + value(board, i+1, j) + value(board, i+1, j+1);
        if(board[i][j] == 1) {
            if(count < 2) {
                return 0;
            } else if(count > 3) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if(count == 3) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    
    private int value(int[][] board, int i, int j) {
        if(i<0 || j<0 || i>=board.length || j >= board[0].length ) {
            return 0;
        }
        return board[i][j];
    }

}
