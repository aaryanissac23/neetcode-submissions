class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int[] ans = new int[nums.length-k+1];
        int j = 0;
        for(int i = 0 ; i < nums.length ; i++){
            while(!q.isEmpty() && nums[i] >= nums[q.getFirst()]){
                q.removeFirst();
            }
            q.addFirst(i);
            while(!q.isEmpty() && q.getLast() <= i-k){
                q.removeLast();
            }
            if(i >= k-1){
                ans[j++] = nums[q.getLast()];
            }
        }
        return ans;
    }
}
