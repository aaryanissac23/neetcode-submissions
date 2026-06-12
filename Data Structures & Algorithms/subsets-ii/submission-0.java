class Solution {
    private void helper(int[] nums , int idx , List<List<Integer>> ans , List<Integer> curr){
        if(idx > nums.length) return;
        ans.add(new ArrayList<>(curr));
        for(int i = idx ; i < nums.length ; i++){
            if(i > idx && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            helper(nums , i+1 , ans , curr);
            curr.remove(curr.size()-1);
        }
    }    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums , 0 , ans , new ArrayList<>());
        return ans;
    }
}
