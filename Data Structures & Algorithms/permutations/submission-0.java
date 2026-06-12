class Solution {
    private void helper(int[] nums , boolean[] used , List<List<Integer>> ans , List<Integer> curr){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0 ; i < nums.length; i++){
            if(used[i]) continue;
            used[i] = true;
            curr.add(nums[i]);
            helper(nums , used , ans , curr);
            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums , new boolean[nums.length], ans , new ArrayList<>());
        return ans;
    }
}
