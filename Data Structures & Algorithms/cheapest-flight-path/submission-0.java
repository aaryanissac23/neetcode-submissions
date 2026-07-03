class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] flight : flights){
            graph[flight[0]].add(new int[] {flight[1],flight[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[] {src , 0 ,k+1});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int dest = curr[0];
            int cost = curr[1];
            int stops = curr[2];
            if(stops < 0 ) continue;
            if(dest == dst) return cost;
            for(int[] arr : graph[(dest)]){
                int d = arr[0];
                int wt = arr[1];
                pq.add(new int[] {d , cost + wt , stops-1});
            }
        }
        return -1;
    }
}
