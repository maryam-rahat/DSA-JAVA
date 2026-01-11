class Solution {
    public int findJudge(int n, int[][] trust) {
        int length = trust.length;
        if (length == 0) return n == 1 ? 1 : -1;

        int [] incoming = new int[n+1];
        int[] outgoing = new int[n+1];

        for(int i = 0; i < length; i++){
            outgoing[trust[i][0]]++;
            incoming[trust[i][1]]++;
        }
        for(int i = 1; i <= n; i++){
            if(incoming[i] == n-1 && outgoing[i] == 0)return i;
        }
        return -1;
    }
}