class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
      
        int[] result = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int left = 0;
            int right = potions.length;
          
            while (left < right) {
                int mid = (left + right) >> 1;
            
                if ((long) spells[i] * potions[mid] >= success) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            result[i] = potions.length - left;
        }
      
        return result;
    }
}