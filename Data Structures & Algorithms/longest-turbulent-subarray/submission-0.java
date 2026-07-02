class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int res = 1;
        int l = 0;
        int r = 1;
        String prev = "";
        while(r < arr.length){
            if(arr[r-1] > arr[r] && !">".equals(prev)){
                res = Math.max(res , r-l+1);
                r++;
                prev = ">";
            }
            else if(arr[r-1] < arr[r] && !"<".equals(prev)){
                res = Math.max(res , r-l+1);
                r++;
                prev = "<";
            }
            else{
                r = (arr[r] == arr[r-1]) ? r+1 : r;
                l = r-1;
                prev = "";
            }
        }
        return res;
    }
}