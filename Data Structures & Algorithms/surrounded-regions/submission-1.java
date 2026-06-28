class Solution {
    int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};
    int m , n;
    private void dfs(char[][] board , int i , int j , boolean[][] vis){
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] == 'X' || vis[i][j]) return;
        vis[i][j] = true;
        if(board[i][j] == 'O') board[i][j] = 'T';
        for(int[] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(board , r , c , vis);
        }
        vis[i][j] = false;

    }
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0 ; i < m ; i++){
            if(board[i][0] == 'O') board[i][0] = 'T';
        }
        for(int i = 0 ; i < m ; i++){
            if(board[i][n-1] == 'O') board[i][n-1] = 'T';
        }
        for(int j = 0 ; j < n ; j++){
            if(board[0][j] == 'O') board[0][j] = 'T';
        }
        for(int j = 0 ; j < n ; j++){
            if(board[m-1][j] == 'O') board[m-1][j] = 'T';
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == 'T'){
                    dfs(board , i , j , vis);
                }
            }
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }
}
