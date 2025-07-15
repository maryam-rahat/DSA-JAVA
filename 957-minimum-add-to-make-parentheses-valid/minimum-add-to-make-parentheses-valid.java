class Solution {
    public int minAddToMakeValid(String s) {
        if(s.length()==0) return 0;
        Stack<Character> st = new Stack<>();
        int count = 0;

        for(char i: s.toCharArray()){
            if(i == '('){
                st.push(i);
                count++;
            }
            // else if(!st.isEmpty() && i == ')') count--;
            else if(st.isEmpty() && i == ')') count++;
            else{
                st.pop();
                count--;
            }
            
        }
        return count;
    }
}