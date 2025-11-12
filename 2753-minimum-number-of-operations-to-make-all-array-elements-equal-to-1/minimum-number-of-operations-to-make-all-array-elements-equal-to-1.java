class Solution {
    public int gcd(int a, int b){
        while( b!= 0){
            int temp = b;
            b = a% b;
            a = temp;
        }
        return a;
    }
    public int minOperations(int[] nums) {
        int n = nums.length;
        int total = nums[0];

        for(int i = 1; i < n; i++){
            total = gcd(nums[i], total);
        }
        if(total > 1) return -1;

        int ones = 0;
        for (int num : nums) {
            if (num == 1) ones++;
        }
        if (ones > 0) return n - ones; 

        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }

        return (minLen - 1) + (n - 1);

    }
}