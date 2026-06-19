class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] arr = new int[n+1];
        int[] arr1 = new int[n+1];
        for(int[] a : trust){
            arr[a[0]]++;
        }
        for(int[] b : trust){
            arr1[b[1]]++;
        }
        for(int i = 1 ; i <= n ; i++){
            if(arr[i] == 0 && arr1[i] == n-1) return i;
        }
        return -1;
    }
}