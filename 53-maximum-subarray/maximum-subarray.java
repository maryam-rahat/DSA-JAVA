class Solution {
    public int maxSubArray(int[] nums) {
        int maxi = nums[0];
        int sum = 0;

        for(int num : nums){
            sum = Math.max(num, sum+num);
            maxi = Math.max(sum, maxi);
        }
        return maxi;
    }
}