class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int[][] ans = new int[n][3];
        PriorityQueue<int[] > pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        int i = 0;
        for(int[] arr : points){
            ans[i][0] = arr[0];
            ans[i][1] = arr[1];
            ans[i][2] = arr[0]*arr[0] + arr[1]*arr[1];
            i++;
        }
        for(int[] arr : ans){
            pq.offer(arr);
        }
        int[][] res = new int[k][2];
        for(i = 0; i < k; i++){
            int[] curr = pq.poll();
            res[i][0] = curr[0];
            res[i][1] = curr[1];
        }
        return res;
    }
}
