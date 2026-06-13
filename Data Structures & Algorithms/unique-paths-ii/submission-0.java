class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[n-1][m-1] == 1) return 0;
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                if( i == 0 && j == 0) continue;
                int left = j > 0 ? dp[i][j-1] : 0;
                int right = i > 0 ? dp[i-1][j] : 0;
                dp[i][j] = left + right;
            }
        }
        return dp[n-1][m-1];
    }
}