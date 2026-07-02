class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new List[n];
        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] time : times){
            graph[time[0]-1].add(new int[] {time[1]-1,time[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1]-b[1]));
        pq.offer(new int[]{k-1 , 0});
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1] = 0;
        boolean[] vis = new boolean[n];
        while(!pq.isEmpty()){
           int[] curr = pq.poll();
           if(!vis[curr[0]]){
            vis[curr[0]]= true;
            for(int[] arr : graph[curr[0]]){
                int u = curr[0];
                int v = arr[0];
                int wt = arr[1];
                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                    pq.add(new int[] {v,dist[v]});
                }
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
