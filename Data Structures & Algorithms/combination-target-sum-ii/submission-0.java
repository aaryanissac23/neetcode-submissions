class Solution {
    private void helper(int[] nums , int target , List<List<Integer>> ans , 
    List<Integer> curr , int idx , int currsum){
        if(currsum > target) return;
        if(currsum == target){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = idx ; i < nums.length ; i++){
            if(i > idx && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            helper(nums , target , ans , curr , i+1, currsum + nums[i]);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates , target , ans , new ArrayList<>() , 0 , 0);
        return ans;
    }
}
