class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int fullBottles = numBottles;   
        int emptyBottles = 0;           
        int totalDrunk = 0;              

        while (fullBottles > 0) {
            totalDrunk += fullBottles;
            emptyBottles += fullBottles;
            fullBottles = 0;

            if (emptyBottles >= numExchange) {
                fullBottles = 1;       
                emptyBottles -= numExchange;
                numExchange++;
            } else {
                break;
            }
        }

        return totalDrunk;
    }
}