class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor) return 1;
        if (dividend == -2147483648 && divisor == -1) return Integer.MAX_VALUE;
        boolean sign = (dividend >= 0) == (divisor >= 0);

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        int ans = 0;

        while (n >= d) {
            int count = 0;
            while (n >= (d << (count + 1))) {
                count++;
            }
            ans += 1 << count;
            n -= d << count;
        }

        if (!sign) ans = -ans;

        if (ans >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (ans <= Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return ans;
    }
}
