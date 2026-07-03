class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        pq.offer(new int[] {0 , 0 , grid[0][0]});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int t = curr[2];
            if(r == n-1 && c == n-1) return t;
            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr < 0 || nc < 0 || nr >= n || nc >= n || vis[nr][nc]) continue;
                vis[nr][nc] = true;
                pq.offer(new int[] {nr , nc ,Math.max(t , grid[nr][nc])});
            }
        }
        return n*n;
    }
}
