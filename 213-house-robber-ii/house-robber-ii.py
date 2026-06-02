class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n==1: return nums[0]
        prev2 = 0
        prev1 = 0

        prev4 = 0
        prev3 = 0

        for i in range(1, n):
            curr = max(prev1, prev2 + nums[i])
            prev2 = prev1
            prev1 = curr

        for i in range(n-1):
            curr = max(prev3, prev4 + nums[i])
            prev4 = prev3
            prev3 = curr

        return max(prev3, prev1)


            