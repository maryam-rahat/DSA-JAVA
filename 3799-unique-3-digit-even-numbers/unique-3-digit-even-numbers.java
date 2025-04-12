class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> result = new HashSet<>();

        int n = digits.length;

        // Try all combinations of i, j, k (three different indices)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    // All digits must be at different positions
                    if (i != j && j != k && i != k) {
                        int d1 = digits[i]; // Hundreds place
                        int d2 = digits[j]; // Tens place
                        int d3 = digits[k]; // Units place

                        // Check if it's a valid 3-digit number
                        if (d1 != 0 && d3 % 2 == 0) { // No leading zero, and last digit must be even
                            int number = d1 * 100 + d2 * 10 + d3;
                            result.add(number); // Add to set to ensure uniqueness
                        }
                    }
                }
            }
        }

        return result.size();
    }
}