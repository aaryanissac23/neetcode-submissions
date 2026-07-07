class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[numCourses];
        for(int[] arr : prerequisites){
            indegree[arr[0]]++;
            graph[arr[1]].add(arr[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i++){
            if(indegree[i] == 0) q.add(i);
        }
        int c = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            c++;
            for(int i : graph[curr]){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }
        return c == numCourses;
    }
}
