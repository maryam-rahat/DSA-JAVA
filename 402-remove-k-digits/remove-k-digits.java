class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        

        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !st.isEmpty() && st.peek() > num.charAt(i)) {
                st.pop();  
                k--;
            }
            st.push(num.charAt(i));  
        }

        while (k > 0) {
            st.pop();
            k--;
        }
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        res.reverse();
        String result = res.toString().replaceAll("^0+", "");
        return result.isEmpty() ? "0" : result;
    }
}
