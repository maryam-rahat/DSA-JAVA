class Solution:
    def minElement(self, nums: List[int]) -> int:
        min_val = float('inf')
        for num in nums:
            digit_sum = sum(int(digit) for digit in str(num))
            min_val = min(min_val, digit_sum)
        return min_val