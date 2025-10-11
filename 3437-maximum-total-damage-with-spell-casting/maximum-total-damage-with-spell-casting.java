public class Solution {
    public long maximumTotalDamage(int[] power) {
        if (power == null || power.length == 0) return 0;

        TreeMap<Integer, Long> damageMap = new TreeMap<>();
        for (int p : power) {
            damageMap.put(p, damageMap.getOrDefault(p, 0L) + (long)p);
        }

        List<Integer> uniquePowers = new ArrayList<>(damageMap.keySet());
        int n = uniquePowers.size();

        long[] dp = new long[n];

        for (int i = 0; i < n; i++) {
            int currPower = uniquePowers.get(i);
            long currDamage = damageMap.get(currPower);

            if (i == 0) {
                dp[i] = currDamage;
            } else {
                int j = i - 1;
                while (j >= 0 && uniquePowers.get(j) >= currPower - 2) {
                    j--;
                }
                long prevCompatible = j >= 0 ? dp[j] : 0L;

                dp[i] = Math.max(dp[i - 1], prevCompatible + currDamage);
            }
        }
        return dp[n - 1];
    }
}
