class Solution {
    public boolean exist(char[][] board, String word) {
        int height = board.length;
        int width = board[0].length;
        int[][] flag = new int[height][width];
        char[] wordStr = word.toCharArray();
        for(int i = 0; i < height; i ++) {
            for(int j = 0; j < width; j ++) {
                if(searchForWord(board, i, j, wordStr, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchForWord(char[][] board, int i, int j, char[] wordStr, int start, int[][] flag) {
        if((start == (wordStr.length - 1)) && board[i][j] == wordStr[start]
           && flag[i][j] != 1) {
            return true;
        }
        if(board[i][j] != wordStr[start]) {
            return false;
        }
        if(board[i][j] == wordStr[start] && flag[i][j] == 1) {
            return false;
        }
        flag[i][j] = 1;
        if(i > 0) {
            if(searchForWord(board, i - 1, j, wordStr, start + 1, flag)){
               return true;
            }
        }
        if(i < board.length - 1) {
            if(searchForWord(board, i + 1, j, wordStr, start + 1, flag)){
                return true;
            }
        }
        if(j > 0) {
            if(searchForWord(board, i, j - 1, wordStr, start + 1, flag)){
                return true;
            }
        }
        if(j < board[0].length - 1) {
            if(searchForWord(board, i, j + 1, wordStr, start + 1, flag)) {
                return true;
            }
        }
        flag[i][j] = 0;
        return false;
    }
}
