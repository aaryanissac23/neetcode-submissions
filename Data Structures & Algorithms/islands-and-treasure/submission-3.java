class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visit = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 0){
                    q.add(new int[] {i,j});
                }
            }
        }
        if(q.size() == 0) return;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int[] dir : dirs){
                int i = r + dir[0];
                int j = c + dir[1];
                if(i >= n || j >= m || i < 0 || j < 0 || grid[i][j] != Integer.MAX_VALUE){
                    continue;
                }
                q.add(new int[]{i,j});
                grid[i][j] = grid[r][c] + 1;
            }
        }
    }
}
