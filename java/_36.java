class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        return rowValid(board) && columnValid(board) && boxValid(board); 
    }
    
    public boolean rowValid(char[][] board) {
        Set<Character> set; 
        for (int i = 0; i < 9; i++) {
            set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !set.add(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        return true;
    }
    
    public boolean columnValid(char[][] board) {
        Set<Character> set; 
        for (int i = 0; i < 9; i++) {
            set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.' && !set.add(board[j][i])) return false;
                set.add(board[j][i]);
            }
        }
        return true;
    }
    
    public boolean boxValid(char[][] board) {
        Set<Character> set;
        for ( int i = 0; i < 9 ; i += 3 ) {
            for ( int j = 0; j < 9; j += 3 ){
                set = new HashSet<>();
                for (int x = i; x < i + 3; x++ ) {
                    for (int y = j; y < j + 3; y++) {
                        if (board[x][y] != '.' && !set.add(board[x][y])) return false; 
                        set.add(board[x][y]);
                    }
                }
            }
        }
        return true;
    }
    
}