class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int minlen = nums.length+1;
        while(r < nums.length){
            sum += nums[r];
            while(sum >= target){
                minlen = Math.min(minlen , r-l+1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return minlen == nums.length+1 ? 0 : minlen;
    }
}