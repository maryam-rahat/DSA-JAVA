class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        def function(m, n, dp, grid):
            if m < 0 or n < 0 or grid[m][n] == 1:
                return 0
            elif m == 0 and n == 0:
                return 1

            if dp[m][n] != -1:
                return dp[m][n]
            
            dp[m][n] = function(m-1, n, dp, grid) + function(m, n-1, dp, grid)
            return dp[m][n] 
 

        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        dp = [[-1 for _ in range(n)] for _ in range(m)]
        return function(m-1, n-1, dp, obstacleGrid)
        