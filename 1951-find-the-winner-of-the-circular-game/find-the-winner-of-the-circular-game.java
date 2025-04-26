class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 1; i<= n; i++){
            res.add(i);
        }

        return solve(res, k, 0);
    }
    private int solve(ArrayList<Integer> res, int k, int index){
        if(res.size()==1){
            return res.get(0);
        }

        index = (index + k-1) % res.size();
        res.remove(index);

        return solve(res, k, index);
        //induction is not there, so done
    }
}