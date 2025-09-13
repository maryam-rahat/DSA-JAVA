class Solution {
    public int maxFreqSum(String s) {
        String vowels = "aeiou";
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int maxVowelFreq = 0;
        int maxConsonantFreq = 0;

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();

            if (vowels.indexOf(ch) >= 0) {
                maxVowelFreq = Math.max(maxVowelFreq, count);
            } else {
                maxConsonantFreq = Math.max(maxConsonantFreq, count);
            }
        }
        return maxVowelFreq + maxConsonantFreq;
    }
}