class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        prefProd = [1] * n
        suffProd = [1] * n

        res = [0] * n

        for i in range(1, n):
            prefProd[i] = prefProd[i-1] * nums[i-1]

        for j in range(n-2, -1, -1):
            suffProd[j] = nums[j+1] * suffProd[j+1]
        
        for i in range(n):
            res[i] = prefProd[i] * suffProd[i]

        return res