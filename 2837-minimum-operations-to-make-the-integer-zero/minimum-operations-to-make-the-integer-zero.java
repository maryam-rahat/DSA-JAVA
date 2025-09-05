class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int i = 1; i <= 60; i++) {
            long rem = (long) num1 - (long) i * num2; 
            if (rem < i) continue;  
            if (Long.bitCount(rem) <= i && i <= rem) {
                return i;
            }
        }
        return -1;
    }
}