class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<int[]>[] graph = new ArrayList[points.length];
        for(int i = 0 ; i < points.length ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < points.length ; i++){
            for(int j = i + 1; j < points.length ; j++){
                int wt = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                graph[i].add(new int[] {j , wt});
                graph[j].add(new int[] {i , wt});
            }
        }
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[] {0,0});
        boolean[] vis = new boolean[points.length];
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(vis[curr[0]]) continue;
            vis[curr[0]] = true;
            ans += curr[1];
            for(int[] arr : graph[curr[0]]){
                pq.add(new int[] {arr[0],arr[1]});
            }
        }
        return ans;
    }
}
