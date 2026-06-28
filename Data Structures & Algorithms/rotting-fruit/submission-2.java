class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 2){
                    q.add(new int[] {i,j});
                }
            }
        }
        int level = 0;
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int k = 0 ; k < size ; k++){
                int[] node = q.poll();
                int r = node[0];
                int c = node[1];
                for(int[] dir : dirs){
                    int i = r + dir[0];
                    int j = c + dir[1];
                    if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) continue;
                    if(grid[i][j] == 1){
                        grid[i][j] = 2;
                        q.add(new int[] {i,j});
                    }
                }
            }
            level++;
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        return level == 0 ? 0:level-1;
    }
}
