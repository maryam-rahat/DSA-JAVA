class Solution {
    public long smallestNumber(long num) {
        boolean negative = num < 0;

        char[] digits = String.valueOf(Math.abs(num)).toCharArray();
        Arrays.sort(digits);

        if (!negative) {
            int i = 0;
            while (i < digits.length && digits[i] == '0') {
                i++;
            }

            if (i < digits.length) {
                char temp = digits[i];
                digits[i] = digits[0];
                digits[0] = temp;
            }

            return Long.parseLong(new String(digits));
        } else {
            StringBuilder sb = new StringBuilder(new String(digits));
            sb.reverse();
            return -Long.parseLong(sb.toString());
        }
    }
}