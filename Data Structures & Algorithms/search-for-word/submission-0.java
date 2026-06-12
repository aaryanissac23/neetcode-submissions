class Solution {
    private boolean helper(char[][] board , int n , int m , boolean[][] vis , int idx , int i , int j  , String word){
        if(idx == word.length()) return true;
        if(i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || board[i][j] != word.charAt(idx)){
            return false;
        }
        vis[i][j] = true;

        boolean found = helper(board, n, m, vis, idx + 1, i + 1, j , word) ||
                helper(board, n, m, vis, idx + 1, i - 1, j , word) ||
                helper(board, n, m, vis, idx + 1, i, j + 1 , word) ||
                helper(board, n, m, vis, idx + 1, i, j - 1 , word);
        
        vis[i][j] = false;
        return found;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int idx = 0;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(helper(board , n , m , vis , 0 , i , j , word)) return true;
            }
        }
        return false;
    }
}
