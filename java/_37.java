class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        
        helper(board);
        
    }
    
    public boolean helper(char[][] board) {
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i , j, c)) {
                            board[i][j] = c;
                            if (helper(board)) {
                                return true;
                            }
                            else {
                                board[i][j] = '.';
                            }
                        }       
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int r, int c, char ch) {
        for (int i = 0; i < 9; i++) {
            // validate row
            if (board[r][i] != '.' && board[r][i] == ch) return false;
            if (board[i][c] != '.' && board[i][c] == ch) return false;
        }
        
        //validate box
        
        int boxX = 3 * (r/3);
        int boxY = 3 * (c/3);
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + boxX][j + boxY] != '.' && board[i + boxX][j + boxY] == ch) return false;
            }
        }
        return true;
    }
}