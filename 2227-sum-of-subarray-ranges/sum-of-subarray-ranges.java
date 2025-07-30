class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }
    
    private long sumSubarrayMaxs(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        long sum = 0;
        int n = nums.length;
        
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || nums[stack.peek()] < nums[i])) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;
                sum += (long)nums[mid] * (mid - left) * (right - mid);
            }
            stack.push(i);
        }
        return sum;
    }
    
    private long sumSubarrayMins(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        long sum = 0;
        int n = nums.length;
        
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || nums[stack.peek()] > nums[i])) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;
                sum += (long)nums[mid] * (mid - left) * (right - mid);
            }
            stack.push(i);
        }
        return sum;
    }
}