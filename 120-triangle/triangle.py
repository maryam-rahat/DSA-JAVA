class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        def function(m, n, dp, k, triangle):
            if dp[m][n] != None:
                return dp[m][n]

            if m == k - 1:
                return triangle[m][n]

            left = triangle[m][n] + function(m + 1, n, dp, k, triangle)
            right = triangle[m][n] + function(m + 1, n + 1, dp, k, triangle)

            dp[m][n] = min(left, right)
            return dp[m][n]

        rows = len(triangle)
        dp = [[None] * rows for _ in range(rows)]

        return function(0, 0, dp, rows, triangle)