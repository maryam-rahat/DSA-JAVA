class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> table = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return backtrack(s,table, 0, memo);
    }
    private boolean backtrack(String s, HashSet<String> wordSet, int index, Boolean[] memo) {
    if (index == s.length()) return true;
    if (memo[index] != null) return memo[index];
    for (int end = index + 1; end <= s.length(); end++) {
        String prefix = s.substring(index, end);
        if (wordSet.contains(prefix)) {
            if (backtrack(s, wordSet, end, memo)) {
                memo[index] = true;
                return true;
            }
        }
    }
    memo[index] = false;
    return false;
    }
}