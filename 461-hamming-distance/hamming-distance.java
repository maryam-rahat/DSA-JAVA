class Solution {
    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        int count = 0;
        String binary = Integer.toBinaryString(res);
        for(int i = 0; i < binary.length(); i++){
            if(binary.charAt(i)=='1')count++;
        }
        return count;
    }
}