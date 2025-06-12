import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        // Parse the binary strings as BigInteger
        BigInteger c = new BigInteger(a, 2);
        BigInteger d = new BigInteger(b, 2);
        
        // Add the two BigIntegers
        BigInteger sum = c.add(d);
        
        // Convert the sum back to a binary string and return it
        return sum.toString(2);
    }
}