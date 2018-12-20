class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board =  new char[n][n];
        List<List<String>> ans = new LinkedList<>();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        
        helper(ans, board, 0, n );
        return ans;
    
    }
    
    private void helper (List<List<String>> ans, char[][] board, int col, int n) {
        if (col == n) {
            ans.add(construct(board));
            return;
        } 
        
        for (int row = 0; row < n; row++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                helper(ans, board, col + 1, n);
                board[row][col] = '.';
            }
        }
    }
    
    private boolean isValid(char[][] board, int row, int col) {
        // check if the row has Q before
        
        for (int i =0; i  < col; i++  ) {
            if (board[row][i] == 'Q') return false;
        }
        
        // Check diagonal
        
        for (int i = row - 1, j = col -1; i >= 0 && j >= 0; i--, j--) {
            
            if (board[i][j] == 'Q') return false;
        }
        
        for (int i = row + 1, j = col -1; i < board.length && j >= 0; i++, j--) {
            if(board[i][j] == 'Q') return false;
        }
        
        return true;
    }
    
    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        
        return res;
        
    }
}