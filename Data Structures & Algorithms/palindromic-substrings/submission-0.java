class Solution {
    private boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public int countSubstrings(String s) {
        int c = s.length();
        for(int i = 0 ; i < s.length()-1 ; i++){
            for(int j = i+1 ; j < s.length() ; j++){
                if(isPalindrome(s.substring(i,j+1))){
                    c++;
                }
            }
        }
        return c;
    }
}
