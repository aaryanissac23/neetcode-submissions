class Solution {
    private void helper(int n , List<String> ans , int st , int end , String curr){
        if(curr.length() == 2*n){
            ans.add(curr);
            return;
        }
        if(st < n){
            helper(n, ans, st + 1, end, curr + "(");
        }
        if (end < st) {
            helper(n, ans, st, end + 1, curr + ")");
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n , ans , 0 , 0 ,"");
        return ans;
    }
}
