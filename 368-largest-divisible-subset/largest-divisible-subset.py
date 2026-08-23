class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        nums.sort()
        n = len(nums)

        @lru_cache(None)
        def dp(i):
            best = [nums[i]]

            for j in range(i + 1, n):
                if nums[j] % nums[i] == 0:
                    candidate = [nums[i]] + dp(j)

                    if len(candidate) > len(best):
                        best = candidate

            return best

        answer = []

        for i in range(n):
            candidate = dp(i)
            if len(candidate) > len(answer):
                answer = candidate

        return answer