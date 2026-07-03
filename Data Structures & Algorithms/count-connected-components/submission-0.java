class Solution {
    List<Integer>[] graph;
    private void dfs(int i , boolean[] vis){
        if(vis[i]) return;
        vis[i] = true;
        for(int neigh : graph[i]){
            if(!vis[neigh]){
                dfs(neigh,vis);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        graph = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] vis = new boolean[n];
        int c = 0;
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                dfs(i , vis);
                c++;
            }
        }
        return c;
    }
}
