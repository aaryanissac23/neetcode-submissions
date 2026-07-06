class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int j = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++){
            while(!q.isEmpty() && nums[i] >= nums[q.getLast()]){
                q.removeLast();
            }
            q.addLast(i);
            while(!q.isEmpty() && i - q.getFirst() >= k) q.removeFirst();
            if(i >= k-1){
                ans[j++] = nums[q.peekFirst()];
            }
        }
        return ans;
    }
}
