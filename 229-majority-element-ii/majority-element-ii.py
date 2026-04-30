class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = []

        freq = defaultdict(int)

        for j in range(n):
            freq[nums[j]] +=1

        for num, count in freq.items():
            if count > n // 3:
                res.append(num)
                
        return res