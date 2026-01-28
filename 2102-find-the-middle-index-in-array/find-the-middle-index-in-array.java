class Solution {
    public int findMiddleIndex(int[] nums) {
        int total = 0, left=0;
        for(int num: nums) total+=num;
        for(int i = 0; i < nums.length; i++){
            int right = total - left - nums[i];
            if(right==left) return i;
            left+=nums[i];
        }
        return -1;
    }
}