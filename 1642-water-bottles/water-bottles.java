class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;

        while(numBottles >= numExchange){
            total++;
            numBottles = numBottles - (numExchange - 1);

        }
        return total;
    }
}