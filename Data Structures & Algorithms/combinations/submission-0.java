class Solution {
    private void helper(int idx , int n , int k , List<Integer> curr , List<List<Integer>> ans){
        if(curr.size() == k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = idx ; i <= n ; i++){
            curr.add(i);
            helper(i+1 ,n, k , curr , ans);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(1 , n , k , new ArrayList<>() , ans);
        return ans;
    }
}