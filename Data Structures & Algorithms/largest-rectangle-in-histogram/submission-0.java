class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] lla = new int[n];
        int[] rla = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < n ; i++){
            lla[i] = -1;
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                lla[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        for(int i = n-1 ; i >= 0 ; i--){
            rla[i] = n;
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                rla[i] = st.peek();
            }
            st.push(i);
        }

        int maxArea = 0;
        for(int i = 0 ; i < n ; i++){
            int width = rla[i]-lla[i]-1;
            int height = heights[i];
            maxArea = Math.max(maxArea , width*height);
        }
        return maxArea;
    }
}
