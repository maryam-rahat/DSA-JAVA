class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        n = len(nums)
        dp = {}

        def solve(idx, target):
            if idx == 0:
                if target == 0 and nums[idx] == 0:
                    return 2
                if (nums[idx] * -1) == target or nums[idx] == target:
                    return 1
                return 0

            if (idx, target) in dp:
                return dp[(idx, target)]

            dp[(idx, target)] = solve(idx-1, target + nums[idx]) + solve(idx-1, target-nums[idx])
            return dp[(idx, target)]

        return solve(n-1, target) 

        