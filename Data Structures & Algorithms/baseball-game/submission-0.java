class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();
        for(int i = 0 ; i < operations.length ; i++){
            if(operations[i].equals("+")){
                int a = s.pop();
                int b = s.pop();
                s.push(b);
                s.push(a);
                s.push(a+b);
            }
            else if(operations[i].equals("C")){
                s.pop();
            }
            else if(operations[i].equals("D")){
                int a = s.peek();
                s.push(a*2);
            }
            else{
                s.push(Integer.parseInt(operations[i]));
            }
        }
        int ans = 0;
        while(!s.isEmpty()){
            ans += s.pop();
        }
        return ans;
    }
}