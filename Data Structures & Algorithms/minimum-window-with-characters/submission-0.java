class Solution {
    public String minWindow(String s, String t) {
        if(s.isEmpty()) return "";
        HashMap<Character,Integer> th= new HashMap<>();
        HashMap<Character , Integer> Map = new HashMap<>();
        for(char c : t.toCharArray()){
            th.put(c , th.getOrDefault(c,0)+1);
        }
        int have = 0;
        int need = th.size();
        int[] res = {-1,-1};
        int ans = Integer.MAX_VALUE;
        int l = 0;
        for(int r = 0 ; r < s.length() ; r++){
            char c = s.charAt(r);
            Map.put(c , Map.getOrDefault(c,0)+1);
            if(th.containsKey(c) && th.get(c) == Map.get(c)) have++;
            while(have == need){
                if(r-l+1 < ans){
                    ans =  r-l+1;
                    res[0] = l;
                    res[1] = r;
                }
                char leftchar = s.charAt(l);
                Map.put(leftchar , Map.getOrDefault(leftchar,0)-1);
                if(th.containsKey(leftchar) && th.get(leftchar) > Map.get(leftchar)){
                    have--;
                }
                l++;
            }
        }
        return ans == Integer.MAX_VALUE ? "" : s.substring(res[0],res[1]+1);
    }
}
