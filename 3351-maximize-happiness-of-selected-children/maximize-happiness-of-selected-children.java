class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;

        Arrays.sort(happiness);
        long count = 0; // final op
        long y = 0;
        int x = 0; // to check if it is equal to k

        for(int i = n-1; i >= 0; i--){
            long happy = (long)happiness[i] - y;
            // if( x == k) return count;
            if( x != k && happy > 0){
                count += happy;
                y++;
                x++;
            }
            
        }
        return count;
    }
}