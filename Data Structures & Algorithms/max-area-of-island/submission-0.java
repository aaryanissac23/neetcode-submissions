class Solution {
    private int dfs(int[][] grid , boolean[][] vis , int i , int j ){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || vis[i][j]) return 0;
        vis[i][j] = true;
        return 1 + dfs(grid , vis , i+1 , j ) +
        dfs(grid , vis , i-1 , j ) +
        dfs(grid , vis , i , j-1 ) +
        dfs(grid , vis , i , j+1 );

    }
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    ans = Math.max(ans , dfs(grid , new boolean[n][m] , i , j ));
                }
            }
        }
        return ans;
    }
}
