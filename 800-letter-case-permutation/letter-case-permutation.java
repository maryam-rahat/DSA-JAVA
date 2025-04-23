import java.util.*;

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        solve(s, "", res);
        return res;
    }

    private void solve(String ip, String op, List<String> res) {
        if (ip.length() == 0) {
            res.add(op);
            return;
        }

        char ch = ip.charAt(0);
        String rest = ip.substring(1);

        if (Character.isLetter(ch)) {
            solve(rest, op + Character.toLowerCase(ch), res);
            solve(rest, op + Character.toUpperCase(ch), res);
        } else {
            solve(rest, op + ch, res);
        }
    }
}
