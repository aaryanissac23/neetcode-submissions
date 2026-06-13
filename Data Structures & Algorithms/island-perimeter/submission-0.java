class Solution {
    private int helper(int[][] grid , boolean[][] vis , int i , int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
            return 1;
        }
        if(vis[i][j]) return 0;
        vis[i][j] = true;
        return helper(grid , vis , i+1,j) + helper(grid , vis , i-1 , j) + helper(grid , vis , i , j-1) + helper(grid , vis , i , j+1);

    }
    public int islandPerimeter(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    return helper(grid , vis , i , j);
                }
            }
        }
        return -1;
    }
}