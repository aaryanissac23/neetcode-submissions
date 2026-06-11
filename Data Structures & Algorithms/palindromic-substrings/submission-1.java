class Solution {
    private int helper(String s , int l , int r){
        int count = 0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            count++;
            l--;
            r++;
        }
        return count;
    }
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            count += helper(s , i , i);      // for even palindromes
            count += helper(s , i , i+1);    // for odd palindromes
        }
        return count;
    }
}
