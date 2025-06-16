class Solution {
    public int minBitFlips(int start, int goal) {
        int result = start^goal;
        String res = Integer.toBinaryString(result);
        int count = 0;
        for(int i = 0; i<res.length(); i++){
            if(res.charAt(i)=='1') count++;
        }
        return count;
    }
}