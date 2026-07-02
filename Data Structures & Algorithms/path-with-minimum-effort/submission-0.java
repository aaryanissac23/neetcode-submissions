class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        pq.offer(new int[] {0,0,0});
        int[][] dist = new int[n][m];
        for(int[] arr : dist){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int diff = curr[2];
            if(r == n-1 && c == m-1) return diff;
            if(dist[r][c] < diff) continue;

            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr < 0 || nc < 0 || nr >= n || nc >= m){
                    continue;
                }
                int newDiff = Math.max(diff , Math.abs(heights[r][c]-heights[nr][nc]));
                if(newDiff < dist[nr][nc]){
                    dist[nr][nc] = newDiff;
                    pq.offer(new int[]{nr,nc,newDiff});
                }
            }
        }
        return 0;
    }
}