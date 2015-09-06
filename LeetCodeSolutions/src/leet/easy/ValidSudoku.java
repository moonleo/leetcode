package leet.easy;

/**
 * No.36 Valid Sudoku
 * Determine if a Sudoku is valid, according to: 
 * Sudoku Puzzles - The Rules. The Sudoku board could be partially 
 * filled, where empty cells are filled with the character '.'.
 * 
 */
public class ValidSudoku {
	
	public boolean isValidSudoku(char[][] board) {
		return validColumn(board) && validRow(board) && validBoxes(board);
    }
	
	/**
	 * 数独行是否合法
	 * @param board
	 * @return
	 */
	private boolean validRow(char[][] board) {
		int[] array;
		int index;
		for(int i=0; i<9; i++) {
			array = new int[9];
			for(int j=0; j<9; j++) {
				if(board[i][j] != '.') {
				    index = board[i][j]-'1';
					if(array[index] != 0) {
						return false;
					}
					else {
						array[index] = 1;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * 数独列是否合法
	 * @param board
	 * @return
	 */
	private boolean validColumn(char[][] board) {
		int[] array;
		int index;
		for(int i=0; i<9; i++) {
			array = new int[9];
			for(int j=0; j<9; j++) {
				if(board[j][i] != '.') {
				    index = board[j][i]-'1';
					if(array[index] != 0) {
						return false;
					}
					else {
						array[index] = 1;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * 数独每个格是否合法
	 * @param board
	 * @return
	 */
	private boolean validBoxes(char[][] board) {
		for(int i=0; i<9; i+=3) {
			for(int j=0; j<9; j+=3) {
				if(!validRectangle(board, i, j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean validRectangle(char[][] board, int x, int y) {
		int[] array = new int[9];
		int index;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(board[x+i][y+j]!='.') {
				    index = board[x+i][y+j]-'1';
					if(array[index] != 0) {
						return false;
					}
					else {
						array[index] = 1;
					}
				}
			}
		}
		return true;
	}

}
