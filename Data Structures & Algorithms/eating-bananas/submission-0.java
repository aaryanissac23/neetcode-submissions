class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for(int i : piles){
            r = Math.max(r , i);
        }
        int minrate = r;
        while(l <= r){
            int hrs = 0;
            int mid = l + (r-l)/2;
            for(int i : piles){
                hrs += (i+mid-1)/mid;
            }
            if(hrs <= h){
                minrate = Math.min(minrate , mid);
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return minrate;
    }
}
