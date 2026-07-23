class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        
        def function(idx, path):
            if idx == len(nums):
                res.append(path[:])
                return
            
            path.append(nums[idx])
            function(idx+1, path)
            path.pop()

            function(idx + 1, path)

        function(0, [])

        return res    
            

