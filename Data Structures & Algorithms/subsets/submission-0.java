class Solution {
    private void helper(int[] nums , List<List<Integer>> ans , List<Integer> curr , int idx){
        ans.add(new ArrayList<>(curr));
        if(idx >= nums.length) return;
        for(int i = idx ; i < nums.length ; i++){
            curr.add(nums[i]);
            helper(nums , ans , curr , i+1);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums ,ans , new ArrayList<>() , 0);
        return ans;
    }
}
