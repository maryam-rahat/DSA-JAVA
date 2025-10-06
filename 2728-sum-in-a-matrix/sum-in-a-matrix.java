class Solution {
    public int matrixSum(int[][] nums) {
        int rows = nums.length;
        int cols = nums[0].length;

        int sum = 0;
        for (int i = 0; i < rows; i++) {
            Arrays.sort(nums[i]);
        }

        for(int j = 0; j < cols; j++){
            int max = 0;
            for(int i = 0; i < rows; i++){
                max = Math.max(max, nums[i][j]);
            }
            sum+=max;
        }
        return sum;
    }
}