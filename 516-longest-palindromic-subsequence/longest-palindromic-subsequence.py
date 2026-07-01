class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        n = len(s)
        if n == 1: return 1 

        dp = [[-1 for _ in range(n)] for _ in range(n)]

        def solve(start, end):
            if start > end: return 0
            #think this through
            if start == end: return 1

            if dp[start][end] != -1:
                return dp[start][end] 

            take = 0
            not_take = 0
            
            if s[start] == s[end]:
                take = 2 + solve(start+1, end-1)
            else:
                not_take = 0 + max(solve(start, end-1), solve(start+1, end))

            dp[start][end] = max(take, not_take)
        
            return (dp[start][end])
        
        return solve(0, n-1)

