class FoodRatings {
    private Map<String, Integer> foodRatings;  
    private Map<String, String> foodCuisines;  
    private Map<String, TreeSet<String>> cuisineFoods;  

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRatings = new HashMap<>();
        foodCuisines = new HashMap<>();
        cuisineFoods = new HashMap<>();
        
        for (int i = 0; i < foods.length; i++) {
            foodRatings.put(foods[i], ratings[i]);
            foodCuisines.put(foods[i], cuisines[i]);
            
            cuisineFoods.putIfAbsent(cuisines[i], new TreeSet<>((a, b) -> {
                int ratingCompare = Integer.compare(foodRatings.get(b), foodRatings.get(a));  
                if (ratingCompare != 0) return ratingCompare;  
                return a.compareTo(b); 
            }));
            cuisineFoods.get(cuisines[i]).add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodCuisines.get(food);

        cuisineFoods.get(cuisine).remove(food);
        
        foodRatings.put(food, newRating);
        cuisineFoods.get(cuisine).add(food);
    }

    public String highestRated(String cuisine) {
        return cuisineFoods.get(cuisine).first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
