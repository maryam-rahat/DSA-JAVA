class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        i = 0
        res = 0
        count = defaultdict(int)

        for j in range(len(nums)):
            count[nums[j]] += 1

            while count[0] > k:
                count[nums[i]] -= 1
                i+=1
            
            res = max(res, j-i+1)
        
        return res
