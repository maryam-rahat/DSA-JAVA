class Solution {
    private Map<List<Integer>, Integer> memo;
    private String inputString;
    private int maxDistinctChars;

    public int maxPartitionsAfterOperations(String s, int k) {
        this.memo = new HashMap<>();
        this.inputString = s;
        this.maxDistinctChars = k;
        return dfs(0, 0, 1);
    }

    private int dfs(int index, int currentMask, int canChange) {
        if (index >= inputString.length()) {
            return 1; 
        }

        List<Integer> memoKey = List.of(index, currentMask, canChange);
        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }

        int charBit = 1 << (inputString.charAt(index) - 'a');
        int newMask = currentMask | charBit;
        int maxPartitions;

        if (Integer.bitCount(newMask) > maxDistinctChars) {
            maxPartitions = dfs(index + 1, charBit, canChange) + 1;
        } else {
            maxPartitions = dfs(index + 1, newMask, canChange);
        }

        if (canChange > 0) {
            for (int charIndex = 0; charIndex < 26; ++charIndex) {
                int changedMask = currentMask | (1 << charIndex);
                if (Integer.bitCount(changedMask) > maxDistinctChars) {
                    maxPartitions = Math.max(maxPartitions,
                            dfs(index + 1, 1 << charIndex, 0) + 1);
                } else {
                    maxPartitions = Math.max(maxPartitions,
                            dfs(index + 1, changedMask, 0));
                }
            }
        }

        memo.put(memoKey, maxPartitions);
        return maxPartitions;
    }
}