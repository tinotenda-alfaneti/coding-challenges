class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        print(target)
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = (left + right)//2
            mid_num = nums[mid]
            if mid_num == target:
                return mid
            if target > mid_num:
                left = mid + 1
            elif target < mid_num:
                right = mid -1
        if nums[mid] < target:
            return mid + 1
        else:
            return mid    