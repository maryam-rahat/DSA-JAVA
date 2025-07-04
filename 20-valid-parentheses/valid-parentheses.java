class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char i : s.toCharArray()) {
            if (i == '(' || i == '{' || i == '[') {
                st.push(i);
            } else {
                if (st.isEmpty()) return false;

                char top = st.peek();
                if ((i == ')' && top == '(') ||
                    (i == '}' && top == '{') ||
                    (i == ']' && top == '[')) {
                    st.pop();
                } else {
                    return false; 
                }
            }
        }

        return st.isEmpty();
    }
}
