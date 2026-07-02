class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[k-1] = 0;
        for(int i = 0 ; i < n-1 ; i++){
            for(int[] time : times){
                int u = time[0]-1;
                int v = time[1]-1;
                int w = time[2];
                if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }
        int ans = 0;
        for(int i : dist){
            ans = Math.max(ans , i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
