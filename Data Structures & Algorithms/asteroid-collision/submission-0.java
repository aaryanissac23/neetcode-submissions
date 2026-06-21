class Solution {
    private boolean check(int a , int b){
        if( a > 0 && b < 0){
            return true;
        }
        return false;
    }
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack();
        st.push(asteroids[0]);
        for(int i = 1 ; i < asteroids.length ; i++){
            int b = asteroids[i];
            while(!st.isEmpty() && check(st.peek() , b)){
                int a = st.peek();
                if(Math.abs(a) < Math.abs(b)){
                    st.pop();
                }
                else if(Math.abs(a) == Math.abs(b)){
                    st.pop();
                    b = 0;
                    break;
                }
                else{
                    b = 0;
                    break;
                }
            }
            if(b != 0) st.push(b);
        }
        int n = st.size();
        int[] ans = new int[n];
        while(!st.isEmpty()){
            ans[--n] = st.pop();
        }
        return ans;
    }

}