class Solution:
    def numberOfSubarrays(self, nums: List[int], k: int) -> int:
        freq = defaultdict(int)
        freq[0] = 1

        prefix = 0
        count = 0

        for num in nums:
            prefix += num % 2

            count += freq[prefix - k]
            freq[prefix] += 1
        return count