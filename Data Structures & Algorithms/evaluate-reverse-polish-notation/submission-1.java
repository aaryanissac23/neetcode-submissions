class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack();
        for(String s : tokens){
            if(s.equals("+")){
                int a = st.pop();
                int b = st.pop();
                int c = a+b;
                st.push(c);
            }
            else if(s.equals("-")){
                int a = st.pop();
                int b = st.pop();
                int c = b-a;
                st.push(c);
            }
            else if(s.equals("*")){
                int a = st.pop();
                int b = st.pop();
                int c = a*b;
                st.push(c);
            }
            else if(s.equals("/")){
                int a = st.pop();
                int b = st.pop();
                int c = b/a;
                st.push(c);
            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.peek();
    }
}
