class StockSpanner {
    ArrayList<Integer> res;

    public StockSpanner() {
        res = new ArrayList<>();
    }
    
    public int next(int price) {
        res.add(price);
        int count = 1;

        for(int i = res.size()-2; i>= 0; i--){
            if(res.get(i) <= price) count++;
            else break;
        }
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */