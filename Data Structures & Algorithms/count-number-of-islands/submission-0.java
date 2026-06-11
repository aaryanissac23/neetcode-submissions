class Solution {
    private void helper(char[][] grid , boolean[][] vis , int i , int j){
        if( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vis[i][j] || grid[i][j] == '0') return;
        vis[i][j] = true;
        helper(grid , vis , i+1 , j);
        helper(grid , vis , i-1 , j);
        helper(grid , vis , i , j+1);
        helper(grid , vis , i , j-1);
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int c = 0;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    helper(grid , vis , i , j);
                    c++;
                }
            }
        }
        return c;
    }
}
