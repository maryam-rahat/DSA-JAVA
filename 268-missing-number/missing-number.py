class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        ret = 0
        n = len(nums)
        for i in range(n):
            ret ^= i
            ret ^= nums[i]
        return ret^n
