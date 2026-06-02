class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)

        if n == 1:
            return nums[0]

        def solve(arr):
            dp = [-1] * len(arr)

            def helper(i):
                if i < 0:
                    return 0

                if dp[i] != -1:
                    return dp[i]

                pick = arr[i] + helper(i - 2)
                notpick = helper(i - 1)

                dp[i] = max(pick, notpick)
                return dp[i]

            return helper(len(arr) - 1)

        return max(solve(nums[:-1]), solve(nums[1:]))
