class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        summ = 0
        for i in range(k):
            summ+=nums[i]

        maxx = summ
        for i in range(k, len(nums)):
            summ += nums[i] - nums[i-k]
            maxx = max(summ, maxx)

        return float(maxx/k)
