class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        dp = [[[-1 for _ in range(3)] for _ in range(2)] for _ in range(n)]
    
        def getAns(ind, buy, cap):
            if ind == n or cap == 0:
                return 0  
            
            if dp[ind][buy][cap] != -1:
                return dp[ind][buy][cap] 
            
            profit = 0
            
            if buy == 0:
                profit = max(0 + getAns(ind + 1, 0, cap), -prices[ind] + getAns(ind + 1, 1, cap))
            elif buy == 1:
                profit = max(0 + getAns(ind + 1, 1, cap), prices[ind] + getAns(ind + 1, 0, cap - 1))
            
            dp[ind][buy][cap] = profit
            return profit

        return getAns(0, 0, 2)