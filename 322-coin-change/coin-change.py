class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins)
        dp = [[-1] * (amount+1) for _ in range(n)]

        def solve(idx, target):
            if idx==0:
                if target % coins[0]==0:
                    return target // coins[0]
                return float('inf')
            
            if dp[idx][target] != -1:
                return dp[idx][target]

            not_take = solve(idx-1, target)
            take = float('inf')
            if coins[idx]<=target:
                take = 1 + solve(idx, target-coins[idx])
            
            dp[idx][target] = min(take, not_take)
            return dp[idx][target]

        ans = solve(n-1, amount)
        return -1 if ans == float('inf') else ans