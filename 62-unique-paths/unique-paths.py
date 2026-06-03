class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        def function(m, n, dp):
            count = 0
            if m == 0 and n == 0:
                return 1
            if m == 0 or n == 0:
                return 1
            
            if dp[m][n] != -1:
                return dp[m][n] 
            
            count = function(m-1, n, dp) + function(m, n-1, dp)
            dp[m][n] = count

            return dp[m][n]
        
        dp = [[-1 for _ in range(n)] for _ in range(m)]
        return function(m-1, n-1, dp)
                
