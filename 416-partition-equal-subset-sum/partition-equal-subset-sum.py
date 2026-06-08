class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        def subsetSumUtil(ind, target, arr, dp):
            if target == 0:
                return True

            if ind == 0:
                return arr[0] == target

            if dp[ind][target] != -1:
                return dp[ind][target] == 1

            notTaken = subsetSumUtil(ind - 1, target, arr, dp)

            taken = False
            if arr[ind] <= target:
                taken = subsetSumUtil(ind - 1, target - arr[ind], arr, dp)

            dp[ind][target] = 1 if (notTaken or taken) else 0
            return notTaken or taken

        n = len(nums)
        totSum = sum(nums)

        if totSum % 2:
            return False

        k = totSum // 2
        dp = [[-1] * (k + 1) for _ in range(n)]

        return subsetSumUtil(n - 1, k, nums, dp)