class Solution {
    public class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int u , int v , int wt){
            this.src = u;
            this.dest = v;
            this.wt = wt;
        }
    }
    public class Pair{
        int v;
        int dist;
        public Pair(int v , int dist){
            this.v = v;
            this.dist = dist;
        }

    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<Edge>[] graph = new List[n];
        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] time : times){
            Edge newEdge = new Edge(time[0]-1,time[1]-1,time[2]);
            graph[time[0]-1].add(newEdge);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> (a.dist-b.dist));
        pq.offer(new Pair(k-1 , 0));
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1] = 0;
        boolean[] vis = new boolean[n];
        while(!pq.isEmpty()){
           Pair p = pq.poll();
           if(!vis[p.v]){
            vis[p.v]= true;
            for(Edge e : graph[p.v]){
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                    pq.add(new Pair(v,dist[v]));
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
