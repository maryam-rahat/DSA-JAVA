class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        def function(idx, path):
            if idx == len(nums):
                res.append(path[:])
                return
            
            path.append(nums[idx])
            function(idx+1, path)
            path.pop()

            while idx + 1 < len(nums) and nums[idx] == nums[idx + 1]:
                idx += 1

            function(idx + 1, path)

        function(0, [])

        return res   