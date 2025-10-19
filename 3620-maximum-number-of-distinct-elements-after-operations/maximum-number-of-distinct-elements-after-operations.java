class Solution {
    public int maxDistinctElements(int[] nums, int k) {
         Arrays.sort(nums);
      
        int n = nums.length;
        int distinctCount = 0;  
        int previousValue = Integer.MIN_VALUE;  
      
        for (int currentNum : nums) {
            int optimalValue = Math.min(currentNum + k, Math.max(currentNum - k, previousValue + 1));
            if (optimalValue > previousValue) {
                distinctCount++;
                previousValue = optimalValue;
            }
        }
      
        return distinctCount;
    }
}