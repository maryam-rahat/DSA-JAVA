class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        n = len(nums)
        c = Counter(nums)

        # max_freq = max(c.values())
        most_freq =[key for key, count in c.items() if count > n//3]
        return most_freq
        