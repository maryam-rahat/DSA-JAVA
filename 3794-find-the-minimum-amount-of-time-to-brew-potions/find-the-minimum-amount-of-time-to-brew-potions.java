class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long[] prefix = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + skill[i - 1];
        }
        long[] gap = new long[m - 1];
        for (int j = 0; j < m - 1; j++) {
            long maxGap = 0;
            for (int i = 1; i <= n; i++) {
                long val = prefix[i] * mana[j] - prefix[i - 1] * mana[j + 1];
                maxGap = Math.max(maxGap, val);
            }
            gap[j] = Math.max(0, maxGap);
        }
        long[] start = new long[m];
        for (int j = 1; j < m; j++) {
            start[j] = start[j - 1] + gap[j - 1];
        }
        long totalTime = start[m - 1] + prefix[n] * mana[m - 1];
        return totalTime;
    }
}