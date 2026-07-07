class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[numCourses];
        for(int[] arr : prerequisites){
            graph[arr[1]].add(arr[0]);
            indegree[arr[0]]++;
        }
        int j = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int[] ans = new int[numCourses];
        while(!q.isEmpty()){
            int curr = q.poll();
            ans[j++] = curr;
            for(int i : graph[curr]){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }
        return j == numCourses ? ans : new int[]{};
    }
}
