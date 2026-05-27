class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # two sp searches, one for first, other for last

        def first():
            start, end = 0, len(nums) - 1
            ans = -1

            while start <= end:
                mid = start + (end - start) // 2

                if nums[mid] == target:
                    ans = mid
                    end = mid - 1
                if nums[mid] > target:
                    end = mid - 1
                if nums[mid] < target:
                    start = mid + 1

            return ans

        def last():
            start, end = 0, len(nums) - 1
            ans = -1

            while start <= end:
                mid = start + (end - start) // 2

                if nums[mid] == target:
                    ans = mid
                    start = mid + 1
                if nums[mid] > target:
                    end = mid - 1
                else:
                    start = mid + 1
            return ans

        return [first(), last()]
