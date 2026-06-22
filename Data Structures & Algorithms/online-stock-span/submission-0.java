class StockSpanner {
    Stack<Integer> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        st.push(price);
        Stack<Integer> temp = (Stack<Integer>) st.clone();
        int c = 0;
        while(!temp.isEmpty() && temp.peek() <= price){
            temp.pop();
            c++;
        }
        return c;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */